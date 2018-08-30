/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Network;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The Queries class contains various methods representing different kinds of queries.
 * The functions call the function executeQuery from the DatabaseController class, passing a string
 * formed with the values of the parameters.
 */
public class Queries {

public static boolean controlClassroomAvailability(DatabaseController controller,int idRoom) throws SQLException{
    ResultSet result=controller.executeQuery("SELECT * FROM (schoolclass join classroom ON (schoolclass.MAINROOM=classroom.IDROOM))"
                                            + "WHERE classroom.IDROOM="+idRoom);
    while(result.next()){
        return false;
    }
    return true;
}

public static boolean TimeOverlap(DatabaseController controller, int begin,int end,int idClass, int dayIndex) throws SQLException{
        ResultSet result=controller.executeQuery("SELECT * FROM timeblock "+
                                "WHERE ( IDCLASS="+idClass+" AND DAYIND="+dayIndex + 
                                " AND  ((H_BEGIN>="+begin+" AND H_END>="+end+" AND H_BEGIN<"+end+")"
                              + " OR   (H_BEGIN <="+begin+" AND H_END<="+end+" AND H_END>"+begin+" )"
                              + " OR   (H_BEGIN>="+begin+" AND H_END<="+end+")"
                              + " OR   (H_BEGIN<="+begin+" AND H_END>="+end+")))");
        while(result.next()){
            return true;
        }
        return false;
}
public static boolean TimeReplaceOverlap(DatabaseController controller,int hour,int begin,int end,int idClass, int dayIndex) throws SQLException{
        ResultSet result=controller.executeQuery("SELECT * FROM timeblock "+
                                "WHERE ( IDCLASS="+idClass+" AND DAYIND="+dayIndex + 
                                " AND   IDTIME!="+hour+
                                " AND  ((H_BEGIN>="+begin+" AND H_END>="+end+" AND H_BEGIN<"+end+")"
                              + " OR   (H_BEGIN <="+begin+" AND H_END<="+end+" AND H_END>"+begin+" )"
                              + " OR   (H_BEGIN>="+begin+" AND H_END<="+end+")"
                              + " OR   (H_BEGIN<="+begin+" AND H_END>="+end+")))");
        while(result.next()){
            return true;
        }
        return false;
}

public static boolean TimeOverlapClassroom(DatabaseController controller, int begin, int end,int IdRoom,int numClasses,int dayInd) throws SQLException{
        ResultSet result=controller.executeQuery("SELECT * FROM timeblock WHERE ( IDROOM="+IdRoom+" AND DAYIND="+dayInd
                              +" AND  ((H_BEGIN>="+begin+" AND H_END>="+end+" AND H_BEGIN<"+end+")"
                              + " OR   (H_BEGIN <="+begin+" AND H_END<="+end+" AND H_END>"+begin+" )"
                              + " OR   (H_BEGIN>="+begin+" AND H_END<="+end+")"
                              + " OR   (H_BEGIN<="+begin+" AND H_END>="+end+")))");
        int occorrenze=0;
        while(result.next()){
            occorrenze++;
        }
        if(occorrenze>0){
            if(numClasses==occorrenze){
                    return true;
            }
        }
        return false;
}
public static boolean TimeReplaceOverlapClassroom(DatabaseController controller,int hour, int begin, int end,int IdRoom,int numClasses,int dayInd) throws SQLException{
        ResultSet result=controller.executeQuery("SELECT * FROM timeblock WHERE ( IDROOM="+IdRoom+" AND DAYIND="+dayInd+
                              " AND   IDTIME!="+hour
                              +" AND  ((H_BEGIN>="+begin+" AND H_END>="+end+" AND H_BEGIN<"+end+")"
                              + " OR   (H_BEGIN <="+begin+" AND H_END<="+end+" AND H_END>"+begin+" )"
                              + " OR   (H_BEGIN>="+begin+" AND H_END<="+end+")"
                              + " OR   (H_BEGIN<="+begin+" AND H_END>="+end+")))");
        int occorrenze=0;
        while(result.next()){
            occorrenze++;
        }
        if(occorrenze>0){
            if(numClasses==occorrenze){
                    return true;
            }
        }
        return false;
}
public static boolean TimeOverlapTeacher(DatabaseController controller, int begin, int end,int IdTeacher,int dayInd) throws SQLException{
        ResultSet result=controller.executeQuery("SELECT * FROM (timeblock join prof_time on (timeblock.IDTIME=prof_time.IDTIME) )"+
                                                    " WHERE ( prof_time.IDPROF="+IdTeacher+" AND DAYIND="+dayInd
                                                   +" AND  ((H_BEGIN>="+begin+" AND H_END>="+end+" AND H_BEGIN<"+end+")"
                                                   +" OR   (H_BEGIN <="+begin+" AND H_END<="+end+" AND H_END>"+begin+" )"
                                                   +" OR   (H_BEGIN>="+begin+" AND H_END<="+end+")"
                                                   +" OR   (H_BEGIN<="+begin+" AND H_END>="+end+")))");
        while(result.next()){
            return true;
        }
        return false;
}
public static boolean TimeReplaceOverlapTeacher(DatabaseController controller,int hour,int begin, int end,int IdTeacher,int dayInd) throws SQLException{
        ResultSet result=controller.executeQuery("SELECT * FROM (timeblock join prof_time on (timeblock.IDTIME=prof_time.IDTIME) )"+
                                                    " WHERE ( prof_time.IDPROF="+IdTeacher+" AND DAYIND="+dayInd+
                                                    " AND   IDTIME!="+hour
                                                   +" AND  ((H_BEGIN>="+begin+" AND H_END>="+end+" AND H_BEGIN<"+end+")"
                                                   +" OR   (H_BEGIN <="+begin+" AND H_END<="+end+" AND H_END>"+begin+" )"
                                                   +" OR   (H_BEGIN>="+begin+" AND H_END<="+end+")"
                                                   +" OR   (H_BEGIN<="+begin+" AND H_END>="+end+")))");
        while(result.next()){
            return true;
        }
        return false;
}









}