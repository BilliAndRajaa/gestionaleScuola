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
public class Institute {
    private String name;
    private String locality;
    private String description;

    public Institute(String name, String locality, String description) {
        this.name = name;
        this.locality = locality;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getLocality() {
        return locality;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
