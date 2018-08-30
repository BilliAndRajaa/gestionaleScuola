/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolManager;

import java.util.ArrayList;

/**
 * The AdditionalInfo class represents the facultative informations of a specific teacher.
 */
public class AdditionalInfo {
    private int idTeacher;
    private String Description;
    private ArrayList <String> Links=new ArrayList<>();

    public AdditionalInfo(int idTeacher, String Description,ArrayList <String> links) {
        this.idTeacher = idTeacher;
        this.Description = Description;
        this.Links=links;
    }

    public int getIdTeacher() {
        return idTeacher;
    }

    public String getDescription() {
        return Description;
    }

    public ArrayList<String> getLinks() {
        return Links;
    }
    
    public void setIdTeacher(int idTeacher) {
        this.idTeacher = idTeacher;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setLinks(ArrayList<String> Links) {
        this.Links = Links;
    }

    
}
