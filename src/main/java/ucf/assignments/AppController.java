package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AppController {

    @FXML
    public void createButtonClicked(ActionEvent actionEvent) {
        createList();
    }

    @FXML
    public void deleteButtonClicked(ActionEvent actionEvent) {
        deleteList();
    }

    @FXML
    public void openButtonClicked(ActionEvent actionEvent) {
        // add error for no to do list selected
        try {
            Parent root = FXMLLoader.load(getClass().getResource("OpenButton.fxml"));

            Scene scene = new Scene(root);

            Stage primaryStage = new Stage();
            primaryStage.setScene(scene);
            primaryStage.setTitle("OpenWindow");
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void importButtonClicked(ActionEvent actionEvent) {
        importList();
    }

    @FXML
    public void importMultipleButtonClicked(ActionEvent actionEvent) {
        importMultipleLists();
    }

    @FXML
    public void exportButtonClicked(ActionEvent actionEvent) {
        exportList();
    }

    @FXML
    public void exportAllButtonClicked(ActionEvent actionEvent) {
        exportAllLists();
    }

    @FXML
    public void renameButtonClicked(ActionEvent actionEvent) {
        renameList();
    }

    public void createList(){
        // create a new row in the "To-Do Lists" column of the tableview
        // append a new to-do list to the ArrayList "ListsOfToDoLists"
        // set the "title" of the to-do list to ""

    }

    public void deleteList(){
        // removes the selected to-do list from the "ListsOfToDoLists" ArrayList
        // removes the row that the to-do list occupied
    }

    public void importList(){
        // *** assuming the imported file is in format of:
        // List title
        // To-DoItemDescription YYYY-MM-DD
        // To-DoItemDescription YYYY-MM-DD
        // To-DoItemDescription YYYY-MM-DD
        // ...
        // open the file
        // read in the title of the list
        // append a new to-do list to the ArrayList "ListsOfToDoLists" with the title
        // while(nextLine != null)
        // append a new to-do item to the ArrayList "ToDoList"
        // assign the description and date to "itemDescription" and "itemDueDate" of the new item
    }

    public void importMultipleLists(){
        // for(number of files)
        // call the importLists method, each time opening the next file
    }

    public void exportList(){
        // open output file with "titleOfToDoList.txt"
        // put the title as the first line
        // for(arraylist.size)
        // put the description and due date
        // close the output file
    }

    public void exportAllLists(){
        // for(ListOfToDoLists.size)
        // call the exportList method to create an output file of the list
    }

    private void renameList(){
        // clear the current title of the selected list
        // ask for a new title
        // set the title of the selected list to what the user inputted
    }
}
