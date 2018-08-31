/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolManager;

import java.util.*;

/**
 *The Teacher class represents a teacher, having name, surname and a date of birth; it's also characterized by an Id, a freeday,
 * and 2 ArrayList of Integers called subjects and classes.  
 */
public class Teacher {
    private String name;
    private String surname;
    private int id;
    private Date dateOfBirth;
    private ArrayList <Integer> subjects;
    private ArrayList <Integer> classes;
    private int freeDay;

    public Teacher(String name, String surname, int id, Date dateOfBirth, ArrayList<Integer> subjects, ArrayList<Integer> classes, int freeDay) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.dateOfBirth = dateOfBirth;
        this.subjects = subjects;
        this.classes = classes;
        this.freeDay = freeDay;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getId() {
        return id;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public ArrayList<Integer> getSubjects() {
        return subjects;
    }

    public ArrayList<Integer> getClasses() {
        return classes;
    }

    public int getFreeDay() {
        return freeDay;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setSubjects(ArrayList<Integer> subjects) {
        this.subjects = subjects;
    }

    public void setClasses(ArrayList<Integer> classes) {
        this.classes = classes;
    }

    public void setFreeDay(int freeDay) {
        this.freeDay = freeDay;
    }
    
}
