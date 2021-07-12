/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Edmund Johnson V
 */

package ucf.assignments;

import javafx.collections.ObservableList;

public class ToDoList {
    private String title;
    ObservableList<ToDoItem> list;

    public String getListTitle(){
        return title;
    }
    public void setListTitle(String s){
        // set the ToDoList's title to String S
        title = s;
    }
}
