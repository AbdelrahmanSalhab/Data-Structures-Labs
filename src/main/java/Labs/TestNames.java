package Labs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class TestNames {

    static MyList<Name> names = new MyList<>(32471);
    Scanner scan;
    PrintWriter print;

    public boolean readFile(){
        try {
            File file = new File("names.txt");
            scan = new Scanner(file);
        }catch(FileNotFoundException e) {
            e.getMessage();
            return false;
        }
        while(scan.hasNext()){
            String newName = scan.nextLine();
            Name nameToAdd = createName(newName);
            if(nameToAdd != null)
                names.add(nameToAdd);
        }
        System.out.println(names.count + " loaded");
        return true;
    }

    public Name createName(String newName){
        String[] currentname =newName.split(",");
        if(currentname.length != 3)
            return null;
        String name = currentname[0];
        char gender = currentname[1].toUpperCase().charAt(0);
        int freq = parseInt(currentname[2]);
        return new Name(name,gender,freq);
    }

    public boolean saveToFile(MyList<Name> namesFinal){
        try {
            File file = new File("names.txt");
            print = new PrintWriter(file);
        }catch(FileNotFoundException e) {
            e.getMessage();
            return false;
        }
        int i;
        for (i = 0; i < namesFinal.count; i++) {
            print.println(namesFinal.get(i).getName() + "," + namesFinal.get(i).getGender() + "," + namesFinal.get(i).getFrequency());
        }
        System.out.println(i + " saved");
        print.close();
        return true;
    }

    public MyList<Name> getNames() {
        return names;
    }
}