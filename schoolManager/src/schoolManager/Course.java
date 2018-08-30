/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolManager;

/**
 *The Course class represents a course, it's characterized with Strings name, type, and an Integer called id.
 */
public class Course {
    private int idCourse;
    private String name;
    private int numHours;
    private String type;

    public Course(int idCourse, String name, int numHours, String type) {
        this.idCourse = idCourse;
        this.name = name;
        this.numHours = numHours;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public int getNumHours() {
        return numHours;
    }
    
    public int getIdCourse() {
        return idCourse;
    }

    public String getName() {
        return name;
    }

    public void setType(String type) {
        this.type = type;
    }
     
    public void setNumHours(int numHours) {
        this.numHours = numHours;
    }
    
    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    public void setName(String name) {
        this.name = name;
    }
    

}