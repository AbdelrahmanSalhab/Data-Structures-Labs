package Lab7;

public class Martyr implements Comparable<Martyr> {

    private String name;
    private int age;
    private String location;
    private String district;
    private String dateOfMartyrdom;
    private char gender;

    public Martyr(){}

    public Martyr(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Martyr{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", location='" + location + '\'' +
                ", district='" + district + '\'' +
                ", dateOfMartyrdom='" + dateOfMartyrdom + '\'' +
                ", gender=" + gender +
                '}';
    }

    public Martyr(String name, String dateOfMartydom, int age, String location, String district, char gender) {
        this.name = name;
        this.age = age;
        this.location = location;
        this.dateOfMartyrdom = dateOfMartydom;
        this.district = district;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    public String getLocation() { return location; }

    public void setLocation(String location) { this.location = location; }

    public String getDateOfMartyrdom() { return dateOfMartyrdom; }

    public void setDateOfMartyrdom(String dateOfMartyrdom) { this.dateOfMartyrdom = dateOfMartyrdom;}

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getDistrict() {return district;}

    public void setDistrict(String district) { this.district = district; }

    @Override
    public int compareTo(Martyr martyr) {
        return age - martyr.getAge();
    }

}
