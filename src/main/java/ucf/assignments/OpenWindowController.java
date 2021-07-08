/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Edmund Johnson V
 */

package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class OpenWindowController {
    @FXML
    public void addItemButtonPressed(ActionEvent actionEvent) {
        addItem();
    }

    @FXML
    public void removeItemButtonPressed(ActionEvent actionEvent) {
        removeItem();
    }

    @FXML
    public void editDescriptionButtonPressed(ActionEvent actionEvent) {
        editItemDescription();
    }

    @FXML
    public void editDueDateButtonPressed(ActionEvent actionEvent) {
        editItemDueDate();
    }

    @FXML
    public void markCompleteButtonPressed(ActionEvent actionEvent) {
        markItemAsComplete();
    }

    @FXML
    public void showAllButtonPressed(ActionEvent actionEvent) {
        showAll();
    }

    @FXML
    public void showOnlyCompleteButtonPressed(ActionEvent actionEvent) {
        showOnlyComplete();
    }

    @FXML
    public void showOnlyIncompleteButtonPressed(ActionEvent actionEvent) {
        showOnlyIncomplete();
    }

    public void addItem(){
        // create a new row within the tableview
        // append a new to-do item to the current to-do list ArrayList
        // set the "itemDueDate" and "itemDescription" to "" using setItemDueDate() and setItemDescription() methods in ToDoItemClass
        // set the boolean value of "isItemComplete" to "false" by calling setItemIncomplete() method in ToDoItem class
    }

    public void removeItem(){
        // remove the to-do item from the current to-do list ArrayList
        // remove the row that the to-do item occupied
    }

    public void editItemDescription(){
        // clear current description
        // ask for description of new item
        // set the description of the selected item to what the user inputted by calling the setItemDescription() method in ToDoItem class
    }

    public void editItemDueDate(){
        // clear the current due date of the selected item
        // ask for description of new item
        // set the due date of the selected item to what the user inputted by calling setItemDueDate() method in ToDoItem class
    }

    public void markItemAsComplete(){
        // set boolean value of "isItemComplete" of the current to-do item to "true" by calling setItemComplete() method in ToDoItem class
    }

    public void showAll(){
        displayItemsByFilter("all");
    }

    public void showOnlyComplete(){
        displayItemsByFilter("complete");
    }

    public void showOnlyIncomplete(){
        displayItemsByFilter("incomplete");
    }

    public void displayItemsByFilter(String s){
        // if s = "complete", show all of the to-do items with the "isItemComplete" boolean value of "true"
        // else if s = "incomplete", show all of the to-do items with the "isItemComplete" boolean value of "false"
        // else = show all of the items
    }

}
