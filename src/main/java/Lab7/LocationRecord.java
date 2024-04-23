package Lab7;

import java.util.Stack;

public class LocationRecord implements Comparable<LocationRecord>{

    private String locationName;
    private Stack<Martyr> martyrs;

    public LocationRecord(String location) {
        this.locationName = location;
        martyrs = new Stack<>();
    }

    public Stack<Martyr> getMartyrs() {
        return martyrs;
    }

    public void setMartyrs(Stack<Martyr> martyrs) {
        this.martyrs = martyrs;
    }

    @Override
    public int compareTo(LocationRecord locationRecord) {
        return getLocationName().compareTo(locationRecord.locationName);
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public int totalMartyrs() {
        return martyrs.size();
    }

    @Override
    public String toString() {
        return locationName ;
    }

}
