package Network;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import schoolManager.AdditionalInfo;
import schoolManager.Classroom;
import schoolManager.Course;
import schoolManager.Day;
import schoolManager.Faculty;
import schoolManager.Hour;
import schoolManager.SchoolClass;
import schoolManager.Teacher;
import schoolManager.Week;



/**
 * The QuerySelect class contains all methods necessary to fetch saved in the database.
 * The functions call the function executeUpdate from the DatabaseController class, passing a string
 * formed with the values of the parameters.
 */

public class QuerySelect {
    
public static Week selectTimetableBySchoolClass(DatabaseController controller ,int idClass) throws SQLException{
    ResultSet result=controller.executeQuery("SELECT * FROM timeblock where (IDCLASS="+idClass+") ORDER BY DAYIND,H_BEGIN");
    Week timetable=new Week();
    if(result.next()){
        int currentDay=result.getInt("DAYIND");
        ArrayList<Day> days=new ArrayList<>();
        ArrayList<Hour> hours=new ArrayList<>();
        Day day=new Day(result.getInt("DAYIND"));
        Hour hour=new Hour(result.getInt("IDTIME"),result.getInt("H_BEGIN"),result.getInt("H_END"));
        hours.add(hour);
        while(result.next()){
            if(currentDay<result.getInt("DAYIND")){
                currentDay=result.getInt("DAYIND");
                day.setHours(hours);
                hours=new ArrayList<>();
                days.add(day);
                day=new Day(currentDay);
            }
            hour=new Hour(result.getInt("IDTIME"),result.getInt("H_BEGIN"),result.getInt("H_END"));
            hours.add(hour);
            
        }
        day.setHours(hours);
        days.add(day);
        timetable.setDays(days);
    }
    return timetable;
}    
public static Week selectTimetableByClassroom(DatabaseController controller,int idRoom) throws SQLException{
    ResultSet result=controller.executeQuery("SELECT * FROM timeblock where (IDROOM="+idRoom+") ORDER BY DAYIND,H_BEGIN");
    Week timetable=new Week();
      if(result.next()){
        int currentDay=result.getInt("DAYIND");
        ArrayList<Day> days=new ArrayList<>();
        ArrayList<Hour> hours=new ArrayList<>();
        Day day=new Day(result.getInt("DAYIND"));
        Hour hour=new Hour(result.getInt("IDTIME"),result.getInt("H_BEGIN"),result.getInt("H_END"));
        hours.add(hour);
        while(result.next()){
            if(currentDay<result.getInt("DAYIND")){
                currentDay=result.getInt("DAYIND");
                day.setHours(hours);
                hours=new ArrayList<>();
                days.add(day);
                day=new Day(currentDay);
            }
            hour=new Hour(result.getInt("IDTIME"),result.getInt("H_BEGIN"),result.getInt("H_END"));
            hours.add(hour);
            
        }
        day.setHours(hours);
        days.add(day);
        timetable.setDays(days);
    }
    return timetable;
}
public static Week selectTimetableByTeacher(DatabaseController controller,int idTeacher) throws SQLException{
    ResultSet result=controller.executeQuery("SELECT * FROM (prof_time join timeblock on (prof_time.IDTIME=timeblock.IDTIME))"+
                                              " WHERE prof_time.IDPROF="+idTeacher+
                                              " ORDER BY DAYIND,H_BEGIN");
    Week timetable=new Week();
   if(result.next()){
        int currentDay=result.getInt("DAYIND");
        ArrayList<Day> days=new ArrayList<>();
        ArrayList<Hour> hours=new ArrayList<>();
        Day day=new Day(result.getInt("DAYIND"));
        Hour hour=new Hour(result.getInt("IDTIME"),result.getInt("H_BEGIN"),result.getInt("H_END"));
        hours.add(hour);
        while(result.next()){
            if(currentDay<result.getInt("DAYIND")){
                currentDay=result.getInt("DAYIND");
                day.setHours(hours);
                hours=new ArrayList<>();
                days.add(day);
                day=new Day(currentDay);
            }
            hour=new Hour(result.getInt("IDTIME"),result.getInt("H_BEGIN"),result.getInt("H_END"));
            hours.add(hour);
            
        }
        day.setHours(hours);
        days.add(day);
        timetable.setDays(days);
    }
    return timetable;
}
public static Classroom selectClassroom(DatabaseController controller,int idRoom) throws SQLException{
   ResultSet result= controller.executeQuery("SELECT * FROM classroom WHERE IDROOM="+idRoom);
   Classroom room= null;
   if(result.next()){
        room= new Classroom(result.getInt("IDROOM"),result.getString("ROOMNAME"), result.getInt("NUMCLASSES"),result.getInt("MAXCAPACITY"), result.getString("ROOMTYPE"));
   }
           return room;
    
}
public static SchoolClass selectSchoolClass(DatabaseController controller, int idClass) throws SQLException{
    ArrayList<Integer> teachers=new ArrayList<>();
    int faculty=0;
    ResultSet result=controller.executeQuery("SELECT assigned.IDPROF FROM (assigned join professor on(assigned.IDPROF=professor.IDPROF))"+
                                             " WHERE (assigned.IDCLASS="+idClass+")");
    while(result.next()){
                  teachers.add(result.getInt(1));
    }
    result=controller.executeQuery("SELECT IDFACULTY FROM partof WHERE ( IDCLASS="+idClass+" )");
    if(result.next()){
        faculty=result.getInt("IDFACULTY");
    }
    result=controller.executeQuery("SELECT * FROM schoolclass WHERE ( IDCLASS="+idClass+" )");
    SchoolClass schoolclass=null;
   if(result.next()){
    schoolclass=new SchoolClass(result.getInt("IDCLASS"),result.getString("CLASSNAME"), faculty,teachers,result.getInt("MAINROOM"),result.getInt("CLASSYEAR"),result.getString("CLASSSECTION").charAt(0), result.getInt("NUMSTUD"));
   }
    return schoolclass;
}
public static Teacher selectTeacher(DatabaseController controller,int IdTeacher) throws SQLException{
    ArrayList<Integer> courses=new ArrayList<>();
    ArrayList<Integer> classes=new ArrayList<>();
    ResultSet result=controller.executeQuery("SELECT * FROM (teaches join course on (teaches.IDCOURSE=course.IDCOURSE)) WHERE teaches.IDPROF="+IdTeacher); 
    while(result.next()){
            courses.add(result.getInt("IDCOURSE"));
    }
    result=controller.executeQuery("SELECT * FROM (assigned join schoolclass on (assigned.IDCLASS=schoolclass.IDCLASS)) WHERE assigned.IDPROF="+IdTeacher); 
    while(result.next()){
            classes.add(result.getInt("IDCLASS"));
    }
    
    result=controller.executeQuery("SELECT * FROM professor WHERE IDPROF=+"+IdTeacher);
    
    Teacher teacher=null;
    if(result.next()){
        teacher=new Teacher(result.getString("FIRSTNAME"), result.getString("SECONDNAME"),result.getInt("IDPROF"), result.getDate("DateOfBirth"), courses, classes,result.getInt("FREEDAY"));
    
    }
    return teacher;
}
public static Course selectCourse(DatabaseController controller,int IdCourse) throws SQLException{
   ResultSet result=controller.executeQuery("SELECT * FROM course WHERE IDCOURSE=+"+IdCourse);
   Course course = new Course(IdCourse,result.getString("COURSENAME"), 0,result.getString("type"));
   return course;
}
public static Faculty selectFaculty(DatabaseController controller, int idFaculty) throws SQLException{ 
    ArrayList<Integer> courses=new ArrayList<>();
    ResultSet result=controller.executeQuery("SELECT * FROM (facultyplan join course on (facultyplan.IDFACULTY=course.IDCOURSE)) where facultyplan.IDFACULTY");
    while(result.next()){
        courses.add(result.getInt("IDCOURSE"));
    }
    result=controller.executeQuery("SELECT * FROM faculty WHERE IDFACULTY="+idFaculty);
    Faculty faculty=new Faculty(idFaculty,result.getString("FACNAME"),result.getInt("NUMHOURS"),courses);
    return faculty;
    
}
public static Hour selectHour(DatabaseController controller,int idHour) throws SQLException{
    ResultSet result=controller.executeQuery("SELECT * FROM timeblock where IDTIME="+idHour);
    Hour hour =new Hour(idHour, result.getInt("H_BEGIN"), result.getInt("H_END"));
    return hour;
}
public static int SelectFacultyFromClass(DatabaseController controller, int IdClass) throws SQLException{
    ResultSet result=controller.executeQuery("SELECT * FROM partof IDFACULTY WHERE IDCLASS="+IdClass);
    while(result.next()){
     return result.getInt("IDFACULTY");
    }
    return 0;
}
public static ArrayList<Teacher> selectTeachers(DatabaseController controller) throws SQLException{
    ArrayList<Teacher> Teachers=new ArrayList<>();
    ResultSet result=controller.executeQuery("SELECT * FROM professor");
    
    
    while(result.next()){     
        Teacher teacher=new Teacher(result.getString("FIRSTNAME"),result.getString("SECONDNAME"),result.getInt("IDPROF"), result.getDate("DateOfBirth"),null,null,result.getInt("FREEDAY"));
        Teachers.add(teacher);
    }
    return Teachers;
}
public static ArrayList<Classroom> selectClassrooms(DatabaseController controller) throws SQLException{
    ArrayList<Classroom> classrooms=new ArrayList<>();
    ResultSet result=controller.executeQuery("SELECT * FROM classroom");
    while(result.next()){
        Classroom classroom=new Classroom(result.getInt("IDROOM"),result.getString("ROOMNAME"),result.getInt("NUMCLASSES"),result.getInt("MAXCAPACITY"),result.getString("ROOMTYPE"));
        classrooms.add(classroom);
    }
    return classrooms;
}
public static ArrayList<SchoolClass> selectSchoolclasses(DatabaseController controller) throws SQLException{
    ArrayList<SchoolClass> classes=new ArrayList<>();
    ResultSet result=controller.executeQuery("SELECT * FROM schoolclass join partof ON (schoolclass.IDCLASS=partof.IDCLASS)");
    while(result.next()){
        SchoolClass schoolclass=new SchoolClass(result.getInt("IDCLASS"),result.getString("CLASSNAME"),result.getInt("IDFACULTY"),null,result.getInt("MAINROOM"),result.getInt("CLASSYEAR"),result.getString("CLASSSECTION").charAt(0),result.getInt("NUMSTUD"));
        classes.add(schoolclass);
    }
    return classes;
}
public static ArrayList<SchoolClass> selectSchoolclassesByTeacher(DatabaseController controller, int idTeacher) throws SQLException{
    ArrayList<SchoolClass> classes=new ArrayList<>();
    ResultSet result=controller.executeQuery("SELECT * FROM schoolclass join assigned on(schoolclass.IDCLASS=assigned.IDCLASS) WHERE assigned.IDPROF="+idTeacher);
    while(result.next()){
        SchoolClass schoolclass=new SchoolClass(result.getInt("IDCLASS"),result.getString("CLASSNAME"),0,null,0,0,' ',0);
        classes.add(schoolclass);
    }
    return classes;
}
public static ArrayList<Integer> selectTeachersByClass(DatabaseController controller, int idClass) throws SQLException{
    ArrayList<Integer> idTeachers=new ArrayList<>();
    ResultSet result=controller.executeQuery("SELECT * FROM assigned where IDCLASS="+idClass);
    while(result.next()){
        idTeachers.add(result.getInt("IDPROF"));
    }
    return idTeachers;
}
public static ArrayList<Integer> selectCoursesIdsFromFaculty(DatabaseController controller, int idFaculty) throws SQLException{
    ArrayList <Integer> courses=new ArrayList<>();
    ResultSet result =controller.executeQuery("SELECT * FROM facultyplan WHERE IDFACULTY="+idFaculty);
    while(result.next()){
        courses.add(result.getInt("IDCOURSE"));
    }
    return courses;
}
public static ArrayList<Integer> selectCoursesFromFaculty(DatabaseController controller, int idFaculty) throws SQLException{
    ArrayList <Integer> courses=new ArrayList<>();
    ResultSet result =controller.executeQuery("SELECT * FROM facultyplan join course on(facultyplan.IDCOURSE=course.IDCOURSE) WHERE IDFACULTY="+idFaculty);
    while(result.next()){
        courses.add(result.getInt("IDCOURSE"));
    }
    return courses;
}
public static ArrayList<Course> selectFacultyPlanFromClass(DatabaseController controller,int idClass) throws SQLException{
        ResultSet result=controller.executeQuery("SELECT f.IDCOURSE,COURSENAME,f.NUMHOURS,TYPE "+
                                                 "FROM (((schoolclass join partof on (schoolclass.IDCLASS=partof.IDCLASS)) JOIN "+
                                                 " facultyplan AS f on (partof.IDFACULTY=f.IDFACULTY))  join course on (f.IDCOURSE=course.IDCOURSE))"+
                                                 " WHERE (schoolclass.IDCLASS="+ idClass+")" +
                                                 " ORDER BY (f.NUMHOURS)");
        ArrayList <Course> courses=new ArrayList<>();
        while(result.next()){
            courses.add(new Course(result.getInt(1),result.getString(2),result.getInt(3),result.getString(4)));
        }
        return courses;
}
public static ArrayList<Integer> selectFacultyPlanIdsFromClass(DatabaseController controller,int idClass) throws SQLException{
        ResultSet result=controller.executeQuery("SELECT f.IDCOURSE "+
                                                 "FROM (((schoolclass join partof on (schoolclass.IDCLASS=partof.IDCLASS)) JOIN "+
                                                 " facultyplan AS f on (partof.IDFACULTY=f.IDFACULTY))  join course on (f.IDCOURSE=course.IDCOURSE))"+
                                                 " WHERE (schoolclass.IDCLASS="+ idClass+")");
        ArrayList <Integer> courses=new ArrayList<>();
        while(result.next()){
            courses.add(result.getInt(1));
        }
        return courses;
}
public static ArrayList<Integer> getClassroomByType(DatabaseController controller, String type) throws SQLException{
    ResultSet result=controller.executeQuery("SELECT * FROM classroom WHERE (ROOMTYPE='"+type+"')");
    ArrayList<Integer> classrooms=new ArrayList <Integer>();
    while(result.next()){
        classrooms.add(result.getInt("IDROOM"));
    }
    return classrooms;
}
public static ArrayList<Integer> selectTeacherOnClassForCourse(DatabaseController controller,int idClass, int idCourse) throws SQLException{
        ResultSet result=controller.executeQuery("SELECT assigned.IDPROF FROM assigned JOIN teaches ON (assigned.IDPROF=teaches.IDPROF)"
                                                 + " WHERE (IDCLASS="+idClass + " AND IDCOURSE="+idCourse+")");
        ArrayList<Integer> teachers=new ArrayList<>();
        while(result.next()){
            teachers.add(result.getInt("IDPROF"));
        }
        return teachers;
}
public static boolean isAssigned(DatabaseController controller, int idTeacher, int idClass) throws SQLException{
    ResultSet result=controller.executeQuery("SELECT * FROM assigned where IDPROF="+idTeacher +" AND IDCLASS="+idClass);
    while(result.next()){
     return true;
    }
    return false;
}
public static int getNumberOfHours(DatabaseController controller, int IdFaculty, int IdCourse) throws SQLException{
    ResultSet result = controller.executeQuery("SELECT * FROM facultyplan WHERE IDFACULTY="+IdFaculty + " AND IDCOURSE="+IdCourse);
    int res=0;
    while(result.next()){
        res=result.getInt("NUMHOURS");
    }
    return res;
}
public static boolean doesTeach(DatabaseController controller,int idTeacher, int idCourse) throws SQLException{
    ResultSet result=controller.executeQuery("SELECT * FROM teaches WHERE IDPROF="+idTeacher +" AND IDCOURSE="+idCourse);
    while(result.next()){
     return true;
    }
    return false;
}
public static int numberOfClassesAssigned(DatabaseController controller, int IdTeacher) throws SQLException{
    ResultSet result =controller.executeQuery("SELECT COUNT(*) AS COUNTER FROM assigned WHERE IDPROF="+IdTeacher+"GROUP BY(IDPROF)");
    while(result.next()){
        return result.getInt("COUNTER");
    }
    return 0;
}
public static Course getCourseFromHour(DatabaseController controller, int idHour) throws SQLException{
    ResultSet result=controller.executeQuery("SELECT IDCOURSE FROM timeblock WHERE (IDTIME="+idHour+")");
    Course course=null;
    if(result.next()){
        result=controller.executeQuery("SELECT * FROM course WHERE IDCOURSE=+"+result.getInt(1));
        if(result.next()){
            course=new Course(result.getInt("IDCOURSE"),result.getString("COURSENAME") , 0, result.getString("TYPE"));
        }
    }
    return course;
}
public static int getLastIdOfHour(DatabaseController controller) throws SQLException{
    ResultSet result=controller.executeQuery("SELECT MAX(IDTIME) AS LAST FROM timeblock");
    int id=0;
    if(result.next()){
        id=result.getInt("LAST");
    }
    return id;
}
public static int getLastIdOfTeacher(DatabaseController controller) throws SQLException{
    ResultSet result=controller.executeQuery("SELECT MAX(IDPROF) AS LAST FROM professor");
    int id=0;
    if(result.next()){
        id=result.getInt("LAST");
    }
    return id;
}
public static int selectIdCourseFromHour(DatabaseController controller,int idHour) throws SQLException{
    ResultSet result=controller.executeQuery("SELECT IDCOURSE FROM timeblock where IDTIME="+idHour);
    if(result.next()){
        return result.getInt("IDCOURSE");
    }
    return -1;
}
public static Classroom selectClassroomFromHour(DatabaseController controller, int idHour) throws SQLException{
    ResultSet result=controller.executeQuery("SELECT IDROOM FROM timeblock WHERE (IDTIME="+idHour+")");
    Classroom classroom=null;
    if(result.next()){
        result=controller.executeQuery("SELECT * FROM classroom WHERE IDROOM=+"+result.getInt(1));
        if(result.next()){
            classroom=new Classroom(result.getInt("IDROOM"),result.getString("ROOMNAME") ,  result.getInt("NUMCLASSES"),result.getInt("MAXCAPACITY"), result.getString("ROOMTYPE"));
        }
    }
    return classroom;
}
public static ArrayList<Integer> selectTeachersByHour(DatabaseController controller, int idHour) throws SQLException {
       ResultSet result=controller.executeQuery("SELECT IDPROF FROM (prof_time )"+
                                              "WHERE IDTIME="+idHour);
    ArrayList<Integer> teachers=new ArrayList<>();
    while(result.next()){
       teachers.add(result.getInt(1));
    }
    return teachers;
}
public static ArrayList<Integer> selectTeachersByCourse(DatabaseController controller, int idCourse) throws SQLException {
       ResultSet result=controller.executeQuery("SELECT professor.IDPROF FROM professor JOIN teaches ON (professor.IDPROF=teaches.IDPROF)"
                                                 + " WHERE IDCOURSE="+idCourse+")");
        ArrayList<Integer> teachers=new ArrayList<>();
        while(result.next()){
            teachers.add(result.getInt("IDPROF"));
        }
        return teachers;
    }
public static ArrayList<Course> selectCoursesFromTeacher(DatabaseController controller,int idTeacher) throws SQLException{
    ResultSet result=controller.executeQuery("SELECT * FROM course JOIN teaches ON (course.IDCOURSE=teaches.IDCOURSE)"
                                                 + " WHERE IDPROF="+idTeacher);
        ArrayList<Course> courses=new ArrayList<>();
        while(result.next()){
            Course course=new Course(result.getInt("IDCOURSE"),result.getString("COURSENAME"), 0, result.getString("TYPE"));
            courses.add(course);
        }
        return courses;

}
public static ArrayList<Course> selectCoursesFromClassroomTable(DatabaseController controller, Week week) throws SQLException{
    ArrayList<Course> courses=new ArrayList<>();
    for(int i=0;i<week.getDays().size();i++){
        for(int x=0;x<week.getDays().get(i).getHours().size();x++){
            Course course=getCourseFromHour(controller, week.getDays().get(i).getHours().get(x).getIdHour());
            boolean exist=false;   
            for(int u=0;u<courses.size();u++){
                if(courses.get(u).getIdCourse()==course.getIdCourse()){
                    exist=true;
                }
            }
            if(!exist){
                    courses.add(course);
            }
        }
    }
    return courses;
}
public static ArrayList<Integer> selectTeachersFromTable(DatabaseController controller, Week week) throws SQLException{
    ArrayList<Integer> teachers=new ArrayList<>();
    for(int i=0;i<week.getDays().size();i++){
        for(int x=0;x<week.getDays().get(i).getHours().size();x++){
            ArrayList<Integer> idTeachers=selectTeachersByHour(controller,week.getDays().get(i).getHours().get(x).getIdHour());
            for(int z=0;z<idTeachers.size();z++){
                if(teachers.isEmpty() || !teachers.contains(idTeachers.get(z))){
                    teachers.add(idTeachers.get(z));
                }
            }
        }
    }
    return teachers;
}
public static AdditionalInfo getInfo(DatabaseController controller, int idTeacher) throws SQLException, IOException{
    String Description="";
    ArrayList <String> links=new ArrayList<>();
    ResultSet result=controller.executeQuery("SELECT * FROM additionalteacherinfo WHERE IDPROF="+idTeacher);
    while(result.next()){
        Description=result.getString("DESCRIPTION");
    }
    return new AdditionalInfo(idTeacher, Description,links);
}
public static ArrayList<String> getLinks(DatabaseController controller,int idTeacher) throws SQLException{
    ArrayList <String> links=new ArrayList<>();
    ResultSet result=controller.executeQuery("SELECT * FROM USEFULLLINKS WHERE IDPROF="+idTeacher);
    while(result.next()){
        links.add(result.getString("LINK"));
    }
    return links;
}
public static ArrayList<Classroom> selectAvailableMainRooms(DatabaseController controller) throws SQLException{
       ResultSet result=controller.executeQuery("SELECT * FROM classroom C"
                                                + " where not exists ("
                                                    + " select * from schoolclass s "
                                                    + " where s.MAINROOM=C.IDROOM )"
                                                + " AND C.ROOMTYPE='normal'");
       ArrayList<Classroom> rooms=new ArrayList<>();
       while(result.next()){
           
           Classroom room=new Classroom(result.getInt(1), result.getString(2), result.getInt(5), result.getInt(4), result.getString(3));
           rooms.add(room);
       }
       return rooms;
}
public static int getLastIdOfFaculty(DatabaseController controller) throws SQLException {
       ResultSet result=controller.executeQuery("SELECT MAX(IDFACULTY) AS LAST FROM faculty");
    int id=0;
    if(result.next()){
        id=result.getInt("LAST");
    }
    return id;
    }
public static int lastIdOfClass(DatabaseController controller) throws SQLException, SQLException {
    ResultSet result=controller.executeQuery("SELECT MAX(IDCLASS) AS LAST FROM schoolclass");
    int id=0;
    if(result.next()){
        id=result.getInt("LAST");
    }
    return id;  
    }
public static ArrayList<Course> selectCourses(DatabaseController controller) throws SQLException {
        ResultSet result=controller.executeQuery("SELECT * FROM course");
        ArrayList<Course> courses=new ArrayList<>();
        while(result.next()){
                Course course = new Course(result.getInt(1),result.getString("COURSENAME"), 0,result.getString("type"));
                courses.add(course);
        }
        return courses;
    }
public static ArrayList<Faculty> selectFaculties(DatabaseController controller) throws SQLException {
        ResultSet result=controller.executeQuery("SELECT * FROM faculty");
        ArrayList<Faculty> faculties=new ArrayList<>();
        while(result.next()){
                Faculty faculty=new Faculty(result.getInt(1),result.getString(2),result.getInt(3),null);
                faculties.add(faculty);
        }
        return faculties;
    }
public static ArrayList<Integer> selectCoursesIdsFromTeacher(DatabaseController controller, int idTeacher) throws SQLException {
        ResultSet result=controller.executeQuery("SELECT IDCOURSE FROM  teaches WHERE IDPROF="+idTeacher);
        ArrayList<Integer> courses=new ArrayList<>();
        while(result.next()){
            courses.add(result.getInt("IDCOURSE"));
        }
        return courses;
    }
public static ArrayList<Integer> selectSchoolclassesIdsByTeacher(DatabaseController controller, int idTeacher) throws SQLException {
    ArrayList<Integer> classes=new ArrayList<>();
    ResultSet result=controller.executeQuery("SELECT IDCLASS FROM  assigned WHERE assigned.IDPROF="+idTeacher);
        while(result.next()){
            classes.add(result.getInt("IDCLASS"));
        }
        return classes;
    }
public static int getClassFromHour(DatabaseController controller, int idHour) throws SQLException {
        ResultSet result=controller.executeQuery("SELECT IDCLASS FROM timeblock where IDTIME="+idHour);
        if(result.next()){
            return result.getInt("IDCLASS");
        }
        return -1;
    }
}