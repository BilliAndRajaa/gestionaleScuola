
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolManager;

/**
 *The Hour class represents a range of hours in the timetable with a begining and an end as Integers,
 * the object is also identified with an Id.
 */

public class Hour {
    private int idHour;
    private int begin;
    private int end;
    public Hour(int id,int begin,int end) {
       this.idHour=id;
       this.begin=begin;
       this.end=end;
    }

    public int getBegin() {
        return begin;
    }

    public int getEnd() {
        return end;
    }

    public int getIdHour() {
        return idHour;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public void setIdHour(int idHour) {
        this.idHour = idHour;
    }
}
