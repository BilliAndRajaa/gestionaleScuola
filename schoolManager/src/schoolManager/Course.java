/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolManager;

/**
 *
 * @author Bilel
 */
public class Course {
    private int idCourse;
    private String name;
    public Course(String name, int id) {
        this.name = name;
        this.idCourse=id;
    }

    public int getIdCourse() {
        return idCourse;
    }

    public String getName() {
        return name;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    public void setName(String name) {
        this.name = name;
    }
    

}