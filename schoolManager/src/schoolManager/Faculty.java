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
public class Faculty {
    private String name;
    private int numberOfHoursForWeek;
    private ArrayList <Course> courses;

    public Faculty(String name, int numberOfHoursForWeek, ArrayList<Course> courses) {
        this.name = name;
        this.numberOfHoursForWeek = numberOfHoursForWeek;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfHoursForWeek() {
        return numberOfHoursForWeek;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfHoursForWeek(int numberOfHoursForWeek) {
        this.numberOfHoursForWeek = numberOfHoursForWeek;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

   

   
}
