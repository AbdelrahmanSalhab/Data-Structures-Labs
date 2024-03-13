package Lab0;

public class Name implements Comparable<Name> {
    private String name;
    private char gender;
    private int frequency;

    public Name (){
    }

    public Name(String name) {
        this.name = name;
    }

    public Name(String name, char gender, int frequency) {
        this.name = name;
        this.gender = gender;
        this.frequency = frequency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", gender=" + gender +
                ", frequency=" + frequency;
    }

    @Override
    public int compareTo(Name name) {
        return this.name.toLowerCase().compareTo(name.getName().toLowerCase());
    }
}
