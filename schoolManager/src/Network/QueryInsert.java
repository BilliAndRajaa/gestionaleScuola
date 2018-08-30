package Network;
//prova commit

import java.io.IOException;
import java.sql.SQLException;
import schoolManager.Classroom;
import schoolManager.Faculty;

/**
 * The QueryInsert class contains all methods necessary to insert new objects data to the database.
 * The functions call the function executeUpdate from the DatabaseController class, passing a string
 * formed with the values of the parameters.
 */
public class QueryInsert {   
public static void addSchoolClass(DatabaseController controller, String name, int mainClassroom, char section,int year, int numberOfStudents) throws SQLException{
    controller.executeUpdate("INSERT INTO schoolclass (CLASSNAME, CLASSYEAR, CLASSSECTION, MAINROOM, NUMSTUD) VALUES " +
            "('"+name+"',"+year+",'"+
             section+"',"+mainClassroom+
            ","+numberOfStudents+")");

}
public static void addTeacher(DatabaseController controller, String name,String surname,String dateOfBirth, int freeDay) throws SQLException{
     controller.executeUpdate("INSERT INTO `professor` (`FIRSTNAME`, `SECONDNAME`, `DateOfBirth`, `FREEDAY`) VALUES "+
                "('"+name+"','"+surname
                +"','"+dateOfBirth+"','"+freeDay+"')");

}
public static void addCourse(DatabaseController controller,String courseName,String type) throws SQLException{
    controller.executeUpdate("INSERT INTO `course` (`COURSENAME`,`TYPE`) VALUES ('"+courseName+"','"+type+ "')");
}
public static void addHour(DatabaseController controller,Classroom  classroom,int begin,int end,int day,int idRoom,int idClass,int idCourse,String description) throws SQLException{
        controller.executeUpdate(" INSERT INTO `timeblock` (`H_BEGIN`, `H_END`, `DAYIND`, `IDROOM`, `IDCLASS`, `IDCOURSE`, `DESCRIP`)"+
                " VALUES ('"+begin+"', '"+end+"', '"+day+"', '"+idRoom+"', '"+idClass+"', '"+idCourse+"', '"+description+"') ");
}
public static void addFaculty(DatabaseController controller,String facultyName,int numberOfHours) throws SQLException{
      controller.executeUpdate("INSERT INTO `faculty` (`FACNAME`, `NUMHOURS`) VALUES ('"+facultyName+"', '"
                                +numberOfHours+"') ");
}   
public static void assignCourseToFaculty(DatabaseController controller,int IdFaculty,int IdCourse,int numhours) throws SQLException{
       controller.executeUpdate("INSERT INTO `facultyplan` (`IDFACULTY`,`IDCOURSE` ,`NUMHOURS`) VALUES ('"+IdFaculty+"','"+IdCourse+"','"+numhours+"') ");
}
public static void assignCourseToTeacher(DatabaseController controller,int IdTeacher,int IdCourse) throws SQLException{
    controller.executeUpdate("INSERT INTO `teaches` (`IDCOURSE`, `IDPROF`) VALUES ("+IdCourse+", "+IdTeacher+") ");
}
public static void assignTeacherToClass(DatabaseController controller,int IdTeacher,int IdClass) throws SQLException{
    controller.executeUpdate("INSERT INTO `assigned` (`IDCLASS`, `IDPROF`) VALUES ("+IdClass+", "+IdTeacher+") ");
}
public static void assignTeacherToHour(DatabaseController controller,int IdTeacher,int IdHour) throws SQLException{
    controller.executeUpdate("INSERT INTO `prof_time` (`IDPROF`, `IDTIME`) VALUES ("+IdTeacher+", "+IdHour+") ");
}
public static void addClassroom(DatabaseController controller, String name,String type,int maxCapacity,int numberOfSchoolClasses) throws SQLException{
    controller.executeUpdate("INSERT INTO `classroom` (`ROOMNAME`, `ROOMTYPE`, `MAXCAPACITY`,`NUMCLASSES`) "
                                    +"VALUES ('"+name+"', '"+type+"', '"+maxCapacity+"','"
                                    +numberOfSchoolClasses+"')");
}
public static void insertInfo(DatabaseController controller, int idTeacher, String Description) throws SQLException, IOException{
     controller.executeUpdate("INSERT INTO `additionalteacherinfo` (`IDPROF`, `DESCRIPTION`) VALUES ('"+idTeacher+"', '"+Description+"')");
 }
public static void insertLink(DatabaseController controller,int idTeacher,String link) throws SQLException{
    controller.executeUpdate("insert into USEFULLLINKS (IDPROF,LINK) VALUES ('"+idTeacher+"','"+link+"')");
}
public static void assignFacultyToCourse(DatabaseController controller, int id, Faculty faculty) throws SQLException {
            controller.executeUpdate("insert into partof (IDCLASS,IDFACULTY) VALUES ("+id+","+faculty.getId()+")");
}

}
