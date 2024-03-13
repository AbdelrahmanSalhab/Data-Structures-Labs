package Labs;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import Lab1.*;

import static java.lang.Integer.parseInt;

public class LabTabs extends Application {

    TestNames test =  new TestNames();
    MyList<Name> names;

    @Override
    public void start(Stage stage){
        TabPane tabPane = new TabPane();
        Tab tablab0 = new Tab("Lab 0");
        Tab tablab1 = new Tab("Lab 1");

        tablab0.setContent(lab0());
        tablab1.setContent(lab1());
        tabPane.getTabs().addAll(tablab0,tablab1);
        Scene scene = new Scene(tabPane, 600, 350);
        stage.setScene(scene);
        stage.setTitle("Data Structures' Laboratories");
        stage.setAlwaysOnTop(true);
        stage.show();
    }

    public BorderPane lab0(){
        BorderPane borderPane = new BorderPane();
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        Button btLoad = new Button("Load");
        Button btAdd = new Button("Add");
        Button btDelete = new Button("Delete");
        Button btFind = new Button("Find");
        Button btSave = new Button("Save");

        TextField tfAdd = new TextField();
        tfAdd.setPromptText("name,gender,freq");
        TextField tfDelete = new TextField();
        tfDelete.setPromptText("name");
        TextField tfFind = new TextField();
        tfFind.setPromptText("name");

        Label lbOut = new Label("Hello ! Load file please");

        gridPane.add(btLoad,0,4);
        gridPane.add(btAdd,0,1);
        gridPane.add(btDelete,0,2);
        gridPane.add(btFind,0,3);
        gridPane.add(btSave,1,4);

        gridPane.add(tfAdd,1,1);
        gridPane.add(tfDelete,1,2);
        gridPane.add(tfFind,1,3);

        gridPane.add(lbOut,1,0);

        btLoad.setOnAction(event -> {
            if(test.readFile()) {
                names = test.getNames();
                lbOut.setText("Loaded");
            }else lbOut.setText("Error");
        });

        btAdd.setOnAction(event -> {
            if(tfAdd.getText().isEmpty() || tfAdd.getText().isBlank())
                lbOut.setText("Empty");
                else{
                Name nameToAdd;
                nameToAdd = test.createName(tfAdd.getText());
                if(nameToAdd == null)
                    lbOut.setText("Incorrect Input");
                else {
                    if(names != null) {
                        names.add(nameToAdd);
                        lbOut.setText("Added " + nameToAdd.getName());
                    }else lbOut.setText("File not Loaded");
                }
            }
        });

        btDelete.setOnAction(event -> {
            if(tfDelete.getText().isEmpty() || tfDelete.getText().isBlank())
                lbOut.setText("Empty");
            else{
                Name nameToDelete = new Name(tfDelete.getText());
                if(names != null) {
                    if (names.delete(nameToDelete))
                        lbOut.setText(nameToDelete.getName() + "Deleted");
                    else lbOut.setText("Not Found");
                }else lbOut.setText("File not Loaded");

            }
        });

        btFind.setOnAction(event -> {
            if(tfFind.getText().isEmpty() || tfFind.getText().isBlank())
                lbOut.setText("Empty");
            else{
                Name nameToFind = new Name(tfFind.getText());
                if (names != null ) {
                    int foundIndex = names.find(nameToFind);
                    if (foundIndex != -1)
                        lbOut.setText("Found at " + foundIndex);
                    else lbOut.setText("Not Found");
                }else lbOut.setText("File not Loaded");
            }
        });

        btSave.setOnAction(event -> {
            if(names != null) {
                if (test.saveToFile(names)) {
                    lbOut.setText("Saved");
                } else lbOut.setText("Error");
            }else lbOut.setText("File not Loaded");
        });

        borderPane.setCenter(gridPane);
        return borderPane;
    }

    public BorderPane lab1(){
        BorderPane borderPane = new BorderPane();

        Label lbReverse = new Label("Reverse chars in a sentence");
        Label lbSumOfDigits = new Label("Calculate Sum of digits");
        Label lbArray = new Label("Enter array of integers");
        Label lbTarget = new Label("Enter target number");

        TextField tfReverse = new TextField();
        TextField tfSumOfDigits = new TextField();
        TextField tfArray = new TextField();
        tfArray.setPromptText("Input : 1,2,3 ...");
        TextField tfTarget = new TextField();

        Button btReverse = new Button("Reverse");
        Button btSumOfDigits = new Button("Sum of Digits");
        Button btBinarySearch = new Button("Binary Search");
        btReverse.setMinWidth(90);
        btSumOfDigits.setMinWidth(90);
        btBinarySearch.setMinWidth(90);

        Label lbOut = new Label();

        VBox vBox = new VBox(10);
        Label lbTitle =  new Label("Lab1 : Recursion");
        lbTitle.setFont(Font.font(20));
        vBox.setAlignment(Pos.CENTER);

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        gridPane.add(lbReverse,0,0);
        gridPane.add(tfReverse,1,0);
        gridPane.add(btReverse,2,0);

        gridPane.add(lbSumOfDigits,0,1);
        gridPane.add(tfSumOfDigits,1,1);
        gridPane.add(btSumOfDigits,2,1);

        gridPane.add(lbArray,0,2);
        gridPane.add(tfArray,1,2);
        gridPane.add(lbTarget,0,3);
        gridPane.add(tfTarget,1,3);
        gridPane.add(btBinarySearch,2,3);

        gridPane.add(lbOut,1,4);
        vBox.getChildren().addAll(lbTitle,gridPane);
        borderPane.setCenter(vBox);

        btReverse.setOnAction(event -> {
        if(tfReverse.getText().isEmpty() || tfReverse.getText().isBlank()) {
            lbOut.setText("Empty");
            btReverse.setStyle("-fx-background-color: lightpink");
        }else{
            lbOut.setText(Lab1.inverseReturn(tfReverse.getText()));
            btReverse.setStyle("-fx-background-color: lightgreen");
        }
        });

        btSumOfDigits.setOnAction(event -> {
            if(tfSumOfDigits.getText().isEmpty() || tfSumOfDigits.getText().isBlank()) {
                lbOut.setText("Empty");
                btSumOfDigits.setStyle("-fx-background-color: lightpink");

            }else{
                try {
                    int num = parseInt(Lab1.inverseReturn(tfSumOfDigits.getText()));
                    lbOut.setText(String.valueOf(Lab1.sumOfDigits(num)));
                    btSumOfDigits.setStyle("-fx-background-color: lightgreen");
                }catch (NumberFormatException e){
                    lbOut.setText("incorrect input");
                    btBinarySearch.setStyle("-fx-background-color: lightpink");
                }
            }
        });

        btBinarySearch.setOnAction(event -> {
            if (tfArray.getText().isEmpty() || tfArray.getText().isBlank()) {
                lbOut.setText("Empty");
                btBinarySearch.setStyle("-fx-background-color: lightpink");

            }else if (tfTarget.getText().isEmpty() || tfTarget.getText().isBlank()){
                lbOut.setText("Target unspecified");
                btBinarySearch.setStyle("-fx-background-color: lightpink");

            }else{
                try {
                    String[] arrStr = tfArray.getText().split(",");
                    int[] arr = new int[arrStr.length];

                    for (int i = 0; i < arrStr.length; i++)
                        arr[i] = parseInt(arrStr[i]);

                    int target = parseInt(tfTarget.getText());
                    int index = Lab1.binarySearch(arr,target);
                    if(index == -1) {
                        lbOut.setText("Not Found");
                        btBinarySearch.setStyle("-fx-background-color: lightpink");
                        return;
                    }
                    lbOut.setText("Found at " + index);
                    btBinarySearch.setStyle("-fx-background-color: lightgreen");
                }catch (NumberFormatException e){
                    lbOut.setText("incorrect input");
                    btBinarySearch.setStyle("-fx-background-color: lightpink");
                }
            }
        });

        return borderPane;
    }

    public static void main(String[] args){ launch(args); }
}