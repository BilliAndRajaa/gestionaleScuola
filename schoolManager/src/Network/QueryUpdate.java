/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Network;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import schoolManager.Classroom;
import schoolManager.Course;
import schoolManager.Faculty;
import schoolManager.SchoolClass;
import schoolManager.Teacher;

/**
 * The QueryUpdate class contains all methods necessary to update the objects data saved in the database.
 * The functions call the function executeUpdate from the DatabaseController class, passing a string
 * formed with the values of the parameters.
 */
public class QueryUpdate {

public static void updateClassroom(DatabaseController controller, Classroom classroom) throws SQLException{
    controller.executeUpdate("UPDATE `classroom` SET `ROOMNAME`='"+classroom.getName()+"',"+
                                "`ROOMTYPE`='"+classroom.getType()+"',`MAXCAPACITY`='"+classroom.getMaxCapacity()+
                                "',`NUMCLASSES`='"+classroom.getNumberOfSchoolClass()+"' WHERE IDROOM="+ classroom.getId());
}

public static  void updateSchoolClass(DatabaseController controller, SchoolClass schoolclass) throws SQLException{
    controller.executeUpdate("UPDATE `schoolclass` SET `CLASSNAME`='"+schoolclass.getName()+"',`CLASSYEAR`='"+schoolclass.getYear()+"',"+
                             "`CLASSSECTION`='"+schoolclass.getSection()+"',`MAINROOM`='"+schoolclass.getMainClassroom()+
                             "',`NUMSTUD`='"+schoolclass.getNumberOfStudents()+"' WHERE IDCLASS="+schoolclass.getId());
    
}

public static void updateTeacher(DatabaseController controller, Teacher teacher) throws SQLException{
    DateFormat df = new SimpleDateFormat("yyyy/MM/dd"); 
    String DateString = df.format(teacher.getDateOfBirth());
    controller.executeUpdate("UPDATE `professor` SET`FIRSTNAME`='"+teacher.getName()+"',`SECONDNAME`='"+teacher.getSurname()+"',"+
                             "`DateOfBirth`='"+DateString+"',`FREEDAY`='"+teacher.getFreeDay()+"' WHERE IDPROF='"+teacher.getId()+"'");
}

public static void updateCourse(DatabaseController controller,Course course) throws SQLException{
    controller.executeUpdate("UPDATE `course` SET `COURSENAME`="+course.getName()+" WHERE IDCOURSE="+course.getIdCourse());
}

public static void updateFaculty(DatabaseController controller, Faculty faculty) throws SQLException{
    controller.executeUpdate("UPDATE `faculty` SET `FACNAME`="+faculty.getName()+",`NUMHOURS`="+faculty.getNumberOfHoursForWeek()+
                             " WHERE IDFACULTY="+faculty.getId());
}

public static void updatePartOf(DatabaseController controller,int idc, int idf) throws SQLException {
       controller.executeUpdate("UPDATE `partof` SET IDFACULTY="+idf+" WHERE IDCLASS="+idc);
}

}
