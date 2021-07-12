/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Edmund Johnson V
 */

package ucf.assignments;

import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.format.DateTimeFormatter;

public class ToDoItem {
    private DatePicker itemDueDate;
    private CheckBox isItemComplete;
    private TextField descriptionBox;

    private String stringDueDate;
    private boolean boolComplete;
    private String stringDesc;

    public ToDoItem(Boolean chkBox, String desc){
        this.itemDueDate = new DatePicker();
        this.isItemComplete = new CheckBox();
        this.isItemComplete.setSelected(chkBox);
        this.descriptionBox = new TextField(desc);
        this.descriptionBox.setPromptText("Enter description...");
    }

    public TextField getDescriptionBox(){
        // return the description box text field
        return descriptionBox;
    }

    public DatePicker getItemDueDate(){
        // return the item due date date picker
        return itemDueDate;
    }

    public void setItemDueDate(String s){
        // set the due date to the string passed through the method
        stringDueDate = s;
    }

    public CheckBox getIsItemComplete(){
        // return the isItemComplete checkbox
        return isItemComplete;
    }

    public void setIsItemComplete(boolean bool){
        // sets isItemComplete check box to true/false
        this.isItemComplete.setSelected(bool);
    }

    public String getStringDueDate(){
        // returns stringDueDate string
        return stringDueDate;
    }

    public void setStringDueDate(DatePicker d){
        // sets the stringDueDate to the value passed through the method
        stringDueDate = d.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public String getStringDesc(){
        // returns the stringDesc string
        return stringDesc;
    }

    public void setStringDesc(String s){
        // sets stringDesc to the string passed through the method
        stringDesc = s;
    }

    public boolean getBoolComplete(){
        // returns the boolean getBoolComplete
        return boolComplete;
    }

    public void setBoolComplete(boolean b){
        // sets boolComplete to the boolean passed through the method
        boolComplete = b;
    }
}
