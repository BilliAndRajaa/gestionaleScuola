/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolManager;
import java.util.*;
/**
 *The Week class represents the timetable, it'ss characterized with an ArrayList of Day objects.
 */
public class Week {
    private ArrayList<Day> days;

    public Week() {
        days=new ArrayList<>();
    }

    public ArrayList<Day> getDays() {
        return days;
    }

    public void setDays(ArrayList<Day> days) {
        this.days = days;
    }

    
    
    
}
