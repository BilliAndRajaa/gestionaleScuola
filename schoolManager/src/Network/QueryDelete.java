/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Network;

import java.sql.SQLException;
import java.util.ArrayList;
/**
 * The QueryDelete class contains all methods necessary to delete selected objects data saved in the database.
 * The functions call the function executeUpdate from the DatabaseController class, passing a string
 * formed with the values of the parameters.
 */
public class QueryDelete {
public static void deleteClassroom(DatabaseController controller,int IdRoom) throws SQLException{
    controller.executeUpdate("DELETE FROM classroom where IDROOM="+IdRoom);
}
public static void deleteSchoolClass(DatabaseController controller,int IdClass) throws SQLException{
    controller.executeUpdate("DELETE FROM schoolclass where IDCLASS="+IdClass);
}
public static void deleteTeacher(DatabaseController controller,int IdProf) throws SQLException{
        controller.executeUpdate("DELETE FROM professor where IDPROF="+IdProf);
}
public static void deleteCourse(DatabaseController controller,int IdCourse) throws SQLException{
    controller.executeUpdate("DELETE FROM course where IDCOURSE="+IdCourse);
}
public static void deleteHour(DatabaseController controller,int IdHour) throws SQLException{
  controller.executeUpdate("DELETE * FROM timeblock where IDTIME="+IdHour);
}
public static void deleteHours(DatabaseController controller,ArrayList<Integer> idHours) throws SQLException{
  String query="DELETE * FROM timeblock where ( IDTIME="+idHours.get(0);
  for(int i=1;i<idHours.size();i++){
      query+="OR IDTIME="+idHours.get(i);
  }
  query+=")";
  controller.executeUpdate(query);
}
public static void deleteFaculty(DatabaseController controller,int IdFaculty) throws SQLException{
  controller.executeUpdate("DELETE  FROM faculty where IDFACULTY="+IdFaculty);
}

public static void deleteInfo(DatabaseController controller, int id) throws SQLException {
        controller.executeUpdate("DELETE FROM `additionalteacherinfo` where IDPROF="+id);
}

public static void deleteLinks(DatabaseController controller, int id) throws SQLException {
        controller.executeUpdate("DELETE  FROM usefulllinks where IDPROF="+id);
}
public static void deleteTeachings(DatabaseController controller, int id) throws SQLException {
    controller.executeUpdate("DELETE  FROM assigned where IDPROF="+id);
}

public static void deleteCompetence(DatabaseController controller, int id) throws SQLException {
controller.executeUpdate("DELETE  FROM teaches where IDPROF="+id);
}

public static void deleteFacultyplan(DatabaseController controller, int idFaculty) throws SQLException {
         controller.executeUpdate("DELETE FROM facultyplan where IDFACULTY="+idFaculty);
}

    public static void deleteTimetableByClass(DatabaseController controller, int id) throws SQLException {
       controller.executeUpdate("DELETE FROM timeblock where IDCLASS="+id);
    }

    public static void deleteTimetableByRoom(DatabaseController controller, int id) throws SQLException {
       controller.executeUpdate("DELETE FROM timeblock where IDROOM="+id);
    }

    public static void deleteTimetableByTeacher(DatabaseController controller, int id) throws SQLException {
               controller.executeUpdate("DELETE timeblock FROM timeblock JOIN prof_time ON (timeblock.IDTIME=prof_time.IDTIME) WHERE prof_time.IDTIME="+id);
    }

}