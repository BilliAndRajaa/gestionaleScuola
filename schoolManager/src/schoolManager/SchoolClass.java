/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolManager;
import java.util.*;
/**
 *The SchoolClass class reprents a schoolclass, with an id, name, faculty, and ArrayList of Integers called teachers with id of the 
 * teachers associated, a char representing the section and 3 Integers for year, number of studets and id of the main classroom.
 */
public class SchoolClass {
    private int id;
    private String name;
    private int faculty;
    private ArrayList <Integer> teachers;
    private int mainClassroom;
    private int year;
    private char section;
    private int numberOfStudents;

    public SchoolClass(int id, String name, int faculty, ArrayList<Integer> teachers, int mainClassroom, int year, char section, int numberOfStudents) {
        this.id = id;
        this.name = name;
        this.faculty = faculty;
        this.teachers = teachers;
        this.mainClassroom = mainClassroom;
        this.year = year;
        this.section = section;
        this.numberOfStudents = numberOfStudents;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getFaculty() {
        return faculty;
    }

    public ArrayList<Integer> getTeachers() {
        return teachers;
    }

    public int getMainClassroom() {
        return mainClassroom;
    }

    public int getYear() {
        return year;
    }

    public char getSection() {
        return section;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFaculty(int faculty) {
        this.faculty = faculty;
    }

    public void setTeachers(ArrayList<Integer> teachers) {
        this.teachers = teachers;
    }

    public void setMainClassroom(int mainClassroom) {
        this.mainClassroom = mainClassroom;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setSection(char section) {
        this.section = section;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

}
