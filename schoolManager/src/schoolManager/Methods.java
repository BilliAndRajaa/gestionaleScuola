package schoolManager;

import Network.DatabaseController;
import Network.Queries;
import Network.QueryInsert;
import Network.QuerySelect;
import java.sql.SQLException;
import java.util.ArrayList;


public class Methods {
    /**
     * The method createTimetable, creates a Week object,
     * it takes four parameters which are: DatabaseController to communicate with the database, a SchoolClass object, an Integer called maxEnd,
     * and another Integer which is maxConsecutive, all defined by the user.
     * 
     */
    public static Week createTimetable(DatabaseController controller, SchoolClass schoolclass, int maxEnd, int maxConsecutive) throws SQLException{
        ArrayList<Course> courses=QuerySelect.selectFacultyPlanFromClass(controller, schoolclass.getId());
        Week week=new Week();
        ArrayList<Day> daysToInsert = new ArrayList<>();
        int day=0;
        int begin=8;
        int end=0;
        boolean written=false;
        boolean overlap=false;
        for(int i=0;i<courses.size();i++){
            ArrayList<Integer> teachers=QuerySelect.selectTeacherOnClassForCourse(controller, schoolclass.getId(), courses.get(i).getIdCourse());
            ArrayList<Integer> classrooms=QuerySelect.getClassroomByType(controller, courses.get(i).getType());
            int numHours=courses.get(i).getNumHours();
            int placableHours=maxConsecutive;
            day=0;
            while(day<7 && numHours>0){
                if(maxConsecutive<numHours){
                    placableHours=maxConsecutive;
                }else{
                    placableHours=numHours;
                }
                end=begin+placableHours;    
                written=false;  
                overlap=false;
                if(!Queries.TimeOverlap(controller, begin, end, schoolclass.getId(), day)){
                            for(int x=0;x<teachers.size();x++){
                              if(Queries.TimeOverlapTeacher(controller, begin, end, teachers.get(x), day)){
                                  overlap=true;
                                  break;
                              }
                            }
                            if(!overlap){
                                for(int x=0;x<classrooms.size();x++){
                                    Classroom classroom=QuerySelect.selectClassroom(controller, classrooms.get(x));
                                    if(!Queries.TimeOverlapClassroom(controller, begin, end, classroom.getId(), classroom.getNumberOfSchoolClass(),day)){
                                        if(week.getDays().isEmpty()){   
                                             Day dayToInsert = new Day(day);
                                             daysToInsert.add(dayToInsert);
                                             week.setDays(daysToInsert);
                                             QueryInsert.addHour(controller, classroom, begin, end, day, classroom.getId(),schoolclass.getId(),courses.get(i).getIdCourse(), "");
                                             for(int z=0;z<teachers.size();z++){
                                                QueryInsert.assignTeacherToHour(controller, teachers.get(z), QuerySelect.getLastIdOfHour(controller));
                                             }
                                             numHours-=placableHours;
                                             written=true;
                                        }else{
                                                boolean exist=false;
                                                for(int y=0;y<week.getDays().size();y++){
                                                    if(week.getDays().get(y).getDay()==day){   
                                                     QueryInsert.addHour(controller, classroom, begin, end, day, classroom.getId(),schoolclass.getId(),courses.get(i).getIdCourse(), "");
                                                     for(int z=0;z<teachers.size();z++){
                                                        QueryInsert.assignTeacherToHour(controller, teachers.get(z), QuerySelect.getLastIdOfHour(controller));
                                                     }
                                                     written=true;
                                                     exist=true;
                                                     numHours-=placableHours;
                                                     break;
                                                    }        
                                                }
                                                if(!exist){
                                                    Day dayToInsert = new Day(day);
                                                    daysToInsert.add(dayToInsert);
                                                    week.setDays(daysToInsert);
                                                    QueryInsert.addHour(controller, classroom, begin, end, day, classroom.getId(),schoolclass.getId(),courses.get(i).getIdCourse(), "");
                                                    for(int z=0;z<teachers.size();z++){
                                                        QueryInsert.assignTeacherToHour(controller, teachers.get(z), QuerySelect.getLastIdOfHour(controller));
                                                    }
                                                    numHours-=placableHours;
                                                    written=true;
                                                }
                                        }
                                    }
                                    if(written){
                                        break;
                                    }
                                }
                                if(!written){
                                 begin++;
                                    if(begin==maxEnd || (begin+placableHours)>=maxEnd){
                                        day++;
                                        begin=8;
                                    }
                                }else{
                                    day++;
                                    begin=8;
                                }
                            }else{
                                begin++;
                                if(begin==maxEnd || (begin+placableHours)>=maxEnd){
                                    day++;
                                    begin=8;
                                }
                            }
                }else{
                 begin++;
                 if(begin==maxEnd || (begin+placableHours)>=maxEnd){
                     day++;
                     begin=8;
                 }
                }
            }
        }        
        return QuerySelect.selectTimetableBySchoolClass(controller, schoolclass.getId());
    } 
    /**
     * The function createHour checks with the "time overlap" queries if an hour object could be created.
     */
    public static boolean createHour(DatabaseController controller,int begin, int end, int day, int IdClass,Classroom classroom, ArrayList<Integer> teachers, int IdCourse,String description) throws SQLException{
            for(int i=0;i<teachers.size();i++){
                    if(Queries.TimeOverlapTeacher(controller, begin, end, teachers.get(i), day)){
                        return false;
                    }
            }
            if(Queries.TimeOverlap(controller, begin, end, IdClass, day)){
                return false;
            }
            if(Queries.TimeOverlapClassroom(controller, begin, end, classroom.getId(), classroom.getNumberOfSchoolClass(), day)){
                return false;
            }           
            QueryInsert.addHour(controller, classroom, begin, end, day, classroom.getId(), IdClass, IdCourse, description);
            return true;
    }
    /**
     * The function assignTeacherToClass assigns automatically all the  necessary teachers to the schoolclass selected.
     */
    public static void assignTeachersToClass(DatabaseController controller,int IdClass) throws SQLException{
        int idFaculty=QuerySelect.SelectFacultyFromClass(controller, IdClass);
        ArrayList <Integer> idCourses=QuerySelect.selectCoursesIdsFromFaculty(controller, idFaculty);
        ArrayList <Integer> idTeachers=QuerySelect.selectTeachersByClass(controller, IdClass);
        boolean found=false;
        for(int i=0;i<idCourses.size();i++){
                for(int y=0;y<idTeachers.size();y++){
                    if(QuerySelect.doesTeach(controller, idTeachers.get(y), idCourses.get(i))){
                        found=true;
                    }
                }
                if(!found){
                     ArrayList <Integer> teachersResult=QuerySelect.selectTeachersByCourse(controller, idCourses.get(i));
                     int maxClasses=1;
                     int x=0;
                     while(true){
                      if(QuerySelect.numberOfClassesAssigned(controller, teachersResult.get(x))<maxClasses){
                          idTeachers.add(teachersResult.get(x));
                          QueryInsert.assignTeacherToClass(controller, teachersResult.get(x), IdClass);
                          break;
                      }
                      x++;
                      if(x==teachersResult.size()){
                       x=0;
                       maxClasses++;
                      }
                     }
                }
                found=false;
        }
    }

    
    
    
    /**
     * The function generateTable creates a String containing html code of a grid representing the Week passed as param.
     */
    public static String generateTable(DatabaseController controller,Week week, ArrayList <Course>courses,ArrayList<Integer> teachers, int mode) throws SQLException{
    String[] colors=new String[7];
        colors[4]="#62a8e1";
        colors[0]="#9869e2";
        colors[2]="#1e93be";
        colors[5]="#32b3a9";
        colors[6]="#4169e1";
        colors[3]="#00dbab";
        colors[1]="#8207c0";
    int range=8;
    String table="<html><head><style>table {\n" +
       
        "    width: 100%;\n" +
                
        "}\n" +
        "\n" +
        "th, td {\n" +
                
        "    text-align: left;\n" +
        "   \n" +
        "    padding: 8px;\n" +
        "}\n" +
        "\n" +
        "th {\n" +
                "width: 150px;"+    
                "height: 90px;"+
        "    background-color: #725fdf;\n" +
        "    color: white;\n" +
        "}\n" +
        "td {\n" +
                
                "white-space:pre"+
        "background-color: #62a8e1;\n" +
        "color:#e9e9e9;\n" +
        "}";
         for(int i=0;i<courses.size();i++){
         table+="#"+courses.get(i).getIdCourse()+"{background-color:"+colors[i]+";}";
         }
         table+="</style></head><body>"
                 + "<table>";
         String [][] content=new String[6][11];
         for(int i=0;i<week.getDays().size();i++){
             for(int x=0;x<week.getDays().get(i).getHours().size();x++){
                 int IntialPosition=week.getDays().get(i).getHours().get(x).getBegin()-range;
                 int FinalPosition=week.getDays().get(i).getHours().get(x).getEnd()-range;
                 for(int y=IntialPosition;y<FinalPosition;y++){
                            int idcourse=QuerySelect.selectIdCourseFromHour(controller,week.getDays().get(i).getHours().get(x).getIdHour());
                            int IndexCourse=0;
                            for(int z=0;z<courses.size();z++){
                            if(idcourse==courses.get(z).getIdCourse()){
                                       IndexCourse=z;
                             }
                            }
                            teachers=QuerySelect.selectTeachersByHour(controller, week.getDays().get(i).getHours().get(x).getIdHour());
                            content[week.getDays().get(i).getDay()][y]="<th id="+idcourse+">";
                            for(int z=0;z<teachers.size();z++){
                                Teacher teacher=QuerySelect.selectTeacher(controller, teachers.get(z));
                               content[week.getDays().get(i).getDay()][y]+="<br/>"+teacher.getName()+" "+teacher.getSurname();
                            }
                            Classroom classroom=QuerySelect.selectClassroomFromHour(controller, week.getDays().get(i).getHours().get(x).getIdHour());
                            content[week.getDays().get(i).getDay()][y]+="<br/>"+classroom.getName()+"\n";
                            if("normal".equals(courses.get(IndexCourse).getType())){
                                   content[week.getDays().get(i).getDay()][y]+=courses.get(IndexCourse).getName()+"<br/>\n";
                            }else{
                                   content[week.getDays().get(i).getDay()][y]+=courses.get(IndexCourse).getName()+"<br/>\n"+courses.get(IndexCourse).getType();
                            }
                            content[week.getDays().get(i).getDay()][y]+="</th>"; 
                }
            }
         
        }
        for(int i=0;i<11;i++){
         table+="<tr>";
         for(int x=0;x<6;x++){  
             if(content[x][i]!=null){
                 table+= content[x][i];
              }else{
                 table+="<th></th>";
             }
             }
            table+="</tr>";
         }
        table+="</table></body></html>";
        return table;
    }
    /**
     * The function generateTable creates a String containing html code of a grid representing the Week passed as param,
     * with the selected range of hours colored differently.
     */
 public static String generateTableWithSelectedHour(DatabaseController controller,Week week, ArrayList <Course>courses,ArrayList<Integer> teachers, int idHour) throws SQLException{
    String[] colors=new String[7];
        colors[4]="#62a8e1";
        colors[0]="#9869e2";
        colors[2]="#1e93be";
        colors[5]="#32b3a9";
        colors[6]="#4169e1";
        colors[3]="#00dbab";
        colors[1]="#8207c0";
    int range=8;
    String table="<html><head><style>table {\n" +
       
        "    width: 100%;\n" +
                
        "}\n" +
        "\n" +
        "th, td {\n" +
                
        "    text-align: left;\n" +
        "   \n" +
        "    padding: 8px;\n" +
        "}\n" +
        "\n" +
        "th {\n" +
                "width: 150px;"+    
                "height: 90px;"+
        "    background-color: #725fdf;\n" +
        "    color: white;\n" +
        "}\n" +
        "td {\n" +
                
                "white-space:pre"+
        "background-color: #62a8e1;\n" +
        "color:#e9e9e9;\n" +
        "}\n"+
        "#selected {\n" +
        "background-color: #FF8D00;\n" +
        "}";
         for(int i=0;i<courses.size();i++){
         table+="#"+courses.get(i).getIdCourse()+"{background-color:"+colors[i]+";}";
         }
         table+="</style></head><body>"
                 + "<table>";
         String [][] content=new String[6][11];
         for(int i=0;i<week.getDays().size();i++){
             for(int x=0;x<week.getDays().get(i).getHours().size();x++){
                 int IntialPosition=week.getDays().get(i).getHours().get(x).getBegin()-range;
                 int FinalPosition=week.getDays().get(i).getHours().get(x).getEnd()-range;
                 for(int y=IntialPosition;y<FinalPosition;y++){
                            int idcourse=QuerySelect.selectIdCourseFromHour(controller,week.getDays().get(i).getHours().get(x).getIdHour());
                            int IndexCourse=0;
                            for(int z=0;z<courses.size();z++){
                            if(idcourse==courses.get(z).getIdCourse()){
                                       IndexCourse=z;
                             }
                            }
                            teachers=QuerySelect.selectTeachersByHour(controller, week.getDays().get(i).getHours().get(x).getIdHour());
                            if(idHour!=week.getDays().get(i).getHours().get(x).getIdHour()){
                            content[week.getDays().get(i).getDay()][y]="<th id="+idcourse+">";
                            }else{
                            content[week.getDays().get(i).getDay()][y]="<th id=selected>";
                            }
                            for(int z=0;z<teachers.size();z++){
                                Teacher teacher=QuerySelect.selectTeacher(controller, teachers.get(z));
                               content[week.getDays().get(i).getDay()][y]+="<br/>"+teacher.getName()+" "+teacher.getSurname();
                            }
                            Classroom classroom=QuerySelect.selectClassroomFromHour(controller, week.getDays().get(i).getHours().get(x).getIdHour());
                            content[week.getDays().get(i).getDay()][y]+="<br/>"+classroom.getName()+"\n";
                            if("normal".equals(courses.get(IndexCourse).getType())){
                                   content[week.getDays().get(i).getDay()][y]+=courses.get(IndexCourse).getName()+"<br/>\n";
                            }else{
                                   content[week.getDays().get(i).getDay()][y]+=courses.get(IndexCourse).getName()+"<br/>\n"+courses.get(IndexCourse).getType();
                            }
                            content[week.getDays().get(i).getDay()][y]+="</th>"; 
                }
            }
         
        }
        for(int i=0;i<11;i++){
         table+="<tr>";
         for(int x=0;x<6;x++){  
             if(content[x][i]!=null){
                 table+= content[x][i];
              }else{
                 table+="<th></th>";
             }
             }
            table+="</tr>";
         }
        table+="</table></body></html>";
        return table;
    }
}
