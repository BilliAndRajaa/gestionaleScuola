package schoolManager;
import java.util.*;

public class Classroom {
    private String name;
    private int numberOfSchoolClass;
    private int maxCapacity;
    private String type;

    public Classroom(String name, int numberOfSchoolClass, int maxCapacity, String type) {
        this.name = name;
        this.numberOfSchoolClass = numberOfSchoolClass;
        this.maxCapacity = maxCapacity;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfSchoolClass() {
        return numberOfSchoolClass;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfSchoolClass(int numberOfSchoolClass) {
        this.numberOfSchoolClass = numberOfSchoolClass;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public void setType(String type) {
        this.type = type;
    }

}
