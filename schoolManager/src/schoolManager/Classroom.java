package schoolManager;
/**
 * The Classroom class represents a room of the institute, characterized with an identifier, name , type, number of classes it 
 * can contain at the same time, and the max number of students it can contain.
 */
public class Classroom {
    private int id;
    private String name;
    private int numberOfSchoolClass;
    private int maxCapacity;
    private String type;

    public Classroom(int id,String name, int numberOfSchoolClass, int maxCapacity, String type) {
        this.id=id;
        this.name = name;
        this.numberOfSchoolClass = numberOfSchoolClass;
        this.maxCapacity = maxCapacity;
        this.type = type;
    }

    public int getId() {
        return id;
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

    public void setId(int id) {
        this.id = id;
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
