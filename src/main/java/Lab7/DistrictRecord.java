package Lab7;

public class DistrictRecord implements Comparable<DistrictRecord>{

    private String districtName;
    private BinarySearchTree<LocationRecord> locations;

    public DistrictRecord(String district) {
        this.districtName = district;
        locations = new BinarySearchTree<>();
    }

    public BinarySearchTree<LocationRecord> getLocations() {
        return locations;
    }

    public void setLocations(BinarySearchTree<LocationRecord> locations) {
        this.locations = locations;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    @Override
    public int compareTo(DistrictRecord districtRecord) {
        return this.districtName.toLowerCase().compareTo(districtRecord.getDistrictName().toLowerCase());
    }

    @Override
    public String toString() {
        return districtName ;
    }
}
