package Lab7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Manager {

    private static BinarySearchTree<DistrictRecord> districts = new BinarySearchTree<>();
    private Scanner scan;
    private PrintWriter print;
    private File file = new File("data.csv");


    public boolean readFile(){
        try {
            scan = new Scanner(file);
        }catch(FileNotFoundException e) {
            e.getMessage();
            return false;
        }

        scan.nextLine();
        while(scan.hasNext()){
            String newMartyr = scan.nextLine();
            Martyr martyrObj = createMartyrObj(newMartyr, true);
            if(martyrObj == null)
                continue;
        }
        return true;
    }


    public Martyr createMartyrObj(String newMartyr, boolean fromFile){
        String[] martyrArray = newMartyr.split(",");
        if(martyrArray.length != 6)
            return null;

        String name = martyrArray[0];

        String date = martyrArray[1];
        String[] martyrDateArray;
        martyrDateArray = date.split("/");
        if(martyrDateArray.length!=3)
            return null;
        int martyrMONTH = Integer.parseInt(martyrDateArray[0]);
        int martyrDAY = Integer.parseInt(martyrDateArray[1]);
        int martyrYEAR = Integer.parseInt(martyrDateArray[2]);

        if      (martyrDAY < 1 || martyrDAY > 31)
            return null;
        else if (martyrMONTH < 1 || martyrMONTH > 12)
            return null;
        else if (martyrYEAR < 1900 || martyrYEAR > 2024)
            return null;
        else if (martyrYEAR == 2024 && martyrMONTH >= 4 && martyrDAY > 9)
            return null;

        int age;
        if (martyrArray[2] == null || martyrArray[2].isBlank() || martyrArray[2].isEmpty() )
            age = -1;
        else{
            try {
                age = parseInt(martyrArray[2]);
                if(age < 0)
                    return null;
            }catch (NumberFormatException e){
                    return null;
            }
        }

        String locationName = martyrArray[3];
        if(locationName == null || locationName.isBlank() || locationName.isEmpty())
            return null;

        String districtName = martyrArray[4];
        if(districtName == null || districtName.isBlank() || districtName.isEmpty())
            return null;

        char gender = martyrArray[5].toUpperCase().charAt(0);
        if(gender != 'M' && gender != 'F' && gender != 'N')
            return null;

        Martyr martyr = null;

        if(fromFile) {
            TNode<DistrictRecord> dsNode = districts.search(new DistrictRecord(districtName));
            DistrictRecord districtMaybeNull = dsNode == null ? null : dsNode.getData();
            LocationRecord locationMaybeNull;

            if (districtMaybeNull == null) {
                districtMaybeNull = new DistrictRecord(districtName);
                districts.insert(districtMaybeNull);
                locationMaybeNull = new LocationRecord(locationName);
                districtMaybeNull.getLocations().insert(locationMaybeNull);

            } else {
                TNode<LocationRecord> lsNode = districtMaybeNull.getLocations().search(new LocationRecord(locationName));
                locationMaybeNull = lsNode == null ? null : lsNode.getData();

                if (locationMaybeNull == null) {
                    locationMaybeNull = new LocationRecord(locationName);
                    districtMaybeNull.getLocations().insert(locationMaybeNull);
                }
            }

            martyr = new Martyr(name, date, age, locationName, districtName, gender);
            districtMaybeNull.getLocations().search(locationMaybeNull).getData().getMartyrs().push(martyr);

        }else {
            TNode<DistrictRecord> dsNode = districts.search(new DistrictRecord(districtName));
            DistrictRecord district = dsNode == null ? null : dsNode.getData();
            LocationRecord location;
            if(district == null) {
                System.out.println("null");
                return null;
            }else {
                TNode<LocationRecord> lsNode = district.getLocations().search(new LocationRecord(locationName));
                location = lsNode == null ? null : lsNode.getData();
                if(location == null) {
                    System.out.println("null");
                    return null;
                }
            }

            martyr = new Martyr(name, date, age, locationName, districtName, gender);
            district.getLocations().search(location).getData().getMartyrs().push(martyr);
        }
        return martyr;
    }


    public static BinarySearchTree<DistrictRecord> getDistricts() {
        return districts;
    }
    public void setFile(File file) { this.file = file; }

}