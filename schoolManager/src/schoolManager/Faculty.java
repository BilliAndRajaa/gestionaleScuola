/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolManager;
import java.util.*;
/**
 * The Faculty class represents a faculty with courses assigned and a number of total hours in the week. 
 */
public class Faculty {
    private int id;
    private String name;
    private int numberOfHoursForWeek;
    private ArrayList <Integer> courses;

    public Faculty(int id,String name, int numberOfHoursForWeek, ArrayList<Integer> courses) {
        this.id=id;
        this.name = name;
        this.numberOfHoursForWeek = numberOfHoursForWeek;
        this.courses = courses;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfHoursForWeek() {
        return numberOfHoursForWeek;
    }

    public ArrayList<Integer> getCourses() {
        return courses;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfHoursForWeek(int numberOfHoursForWeek) {
        this.numberOfHoursForWeek = numberOfHoursForWeek;
    }

    public void setCourses(ArrayList<Integer> courses) {
        this.courses = courses;
    }

   

   
}
