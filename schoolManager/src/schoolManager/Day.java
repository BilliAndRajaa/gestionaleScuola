/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolManager;
import java.util.*;
/**
 *The Day class represents the a day in the timetable, it'ss characterized with an ArrayList of Hours objects, and an index
 * indicating the day of the week.
 */
public class Day {
   
   private int day;
   private ArrayList <Hour> hours;

    public Day(int day) {
        this.day = day;
        hours=new ArrayList<>();
    }

    public int getDay() {
        return day;
    }
    
    public ArrayList<Hour> getHours() {
        return hours;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setHours(ArrayList<Hour> hours) {
        this.hours = hours;
    }
   
    
}
