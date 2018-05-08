/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolManager;
import java.util.*;
/**
 *
 * @author Bilel
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
