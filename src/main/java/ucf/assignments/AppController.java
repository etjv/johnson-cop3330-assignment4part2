package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;


public class AppController implements Initializable{
    @FXML
    private TableView<ToDoItem> myTable;
    @FXML
    private TextField myTitle;

    private ToDoList TDList = new ToDoList();
    private ToDoList TDListPermanent = new ToDoList();

    TableColumn complete = new TableColumn("Complete");
    TableColumn description = new TableColumn("Description");
    TableColumn date = new TableColumn("Due Date");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // initialize a new to do list class
        TDList.list = FXCollections.observableArrayList(new ToDoItem(false, ""));
        TDListPermanent.list = FXCollections.observableArrayList(new ToDoItem(false, ""));
        // create the 3 columns of our tables
        // make them correlate with their ToDoItem class variables
        complete.setCellValueFactory(new PropertyValueFactory<ToDoItem, String>("isItemComplete"));
        description.setCellValueFactory(new PropertyValueFactory<ToDoItem, String>("descriptionBox"));
        description.prefWidthProperty().bind(myTable.widthProperty().multiply(0.68));
        date.setCellValueFactory(new PropertyValueFactory<ToDoItem, String>("itemDueDate"));
        date.prefWidthProperty().bind(myTable.widthProperty().multiply(0.19055944055));

        // set the starting item to the columns and add the columns to the table
        myTable.setItems(TDList.list);
        myTable.getColumns().addAll(complete, description, date);
    }

    @FXML
    public void openListButtonClicked(ActionEvent actionEvent) {
        openList();
    }

    @FXML
    public void saveListButtonClicked(ActionEvent actionEvent) {
        saveList();
    }

    @FXML
    public void showAllItemsButtonClicked(ActionEvent actionEvent) {
        showALlItems();
    }

    @FXML
    public void showCompleteItemsButtonClicked(ActionEvent actionEvent) {
        showCompleteItems();
    }

    @FXML
    public void showIncompleteItemsButtonClicked(ActionEvent actionEvent) {
        showIncompleteItems();
    }

    @FXML
    public void addItemButtonClicked(ActionEvent actionEvent) {
        addItem(TDList, TDListPermanent, false, "");
    }

    @FXML
    public void removeItemButtonClicked(ActionEvent actionEvent) {
        removeItem(TDList, myTable.getSelectionModel().getSelectedIndex());
    }

    @FXML
    public void removeAllItemsButtonClicked(ActionEvent actionEvent) {
        removeALlItems(TDList);
    }

    public void openList(){
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

    public void saveList(){
        // open output file with "titleOfToDoList.txt"



        // put the title as the first line
        // for(arraylist.size)
        // put the description and due date
        // close the output file
    }

    public void showALlItems(){
        // update all of the items in the list
        updateData();
        for(int i = TDList.list.size()-1; i >= 0; i--){
            // delete all of the items from the table/temporary list
            TDList.list.remove(i);
        }
        // copy the items from the permanent list to the temporary one
        copyData();
        for(int i = 0; i < TDList.list.size(); i++){
            // add all of the items from the temp list to the table
            addItem(TDList, TDListPermanent, TDList.list.get(i).getBoolComplete(), TDList.list.get(i).getStringDesc());
        }
    }

    public void showCompleteItems(){
        // update all of the items in the list
        updateData();
        for(int i = TDList.list.size()-1; i >= 0; i--){
            // delete all of the items from the table/temporary list
            myTable.getItems().remove(i);
        }
        // copy the items from the permanent list to the temporary one
        copyData();
        for(int i = 0; i < TDList.list.size(); i++){
            if(TDList.list.get(i).getIsItemComplete().isSelected()){
                // add only the items that are marked complete to the table
                myTable.getItems().add(TDList.list.get(i));
            }
        }
    }

    public void showIncompleteItems(){
        // update all of the items in the list
        updateData();
        for(int i = TDList.list.size()-1; i >= 0; i--){
            // delete all of the items from the table/temporary list
            myTable.getItems().remove(i);
        }
        // copy the items from the permanent list to the temporary one
        copyData();
        for(int i = 0; i < TDList.list.size(); i++){
            if(!TDList.list.get(i).getIsItemComplete().isSelected()){
                // add only the items that are not marked complete to the table
                myTable.getItems().add(TDList.list.get(i));
            }
        }
    }

    public void addItem(ToDoList temp, ToDoList perm, Boolean chkBox, String desc){
        // create a new row within the tableview
        // append a new to-do item to the current to-do list ArrayList
        // set the "itemDueDate" and "itemDescription" to "" using setItemDueDate() and setItemDescription() methods in ToDoItemClass
        // set the boolean value of "isItemComplete" to "false" by calling setItemIncomplete()
        temp.list.add(new ToDoItem(chkBox, desc));
        perm.list.add(new ToDoItem(chkBox, desc));
        complete.setCellValueFactory(new PropertyValueFactory<ToDoItem, String>("isItemComplete"));
        description.setCellValueFactory(new PropertyValueFactory<ToDoItem, String>("descriptionBox"));
        date.setCellValueFactory(new PropertyValueFactory<ToDoItem, String>("itemDueDate"));
    }

    public void removeItem(ToDoList list, int i){
        // remove the to-do item from the current to-do list ArrayList
        list.list.remove(i);
        TDListPermanent.list.remove(i);
        // this automatically removes the row from the columns

    }

    public void removeALlItems(ToDoList list){
        // call removeItem for TDList.size()
        for(int i = list.list.size()-1; i >= 0; i--){
            list.list.remove(i);
            TDListPermanent.list.remove(i);
        }
    }

    public void updateData(){
        // variable to track copies of items
        int k;
        // update the title of both the temporary and permanent lists
        TDList.setListTitle(myTitle.getPromptText());
        TDListPermanent.setListTitle(myTitle.getPromptText());
        for(int i = 0; i < myTable.getItems().size(); i++){
            k = 0;
            // if the item is empty, don't update the information in either of the lists, since they are already initialized to be empty
            if(myTable.getItems().get(i).getBoolComplete() == false && myTable.getItems().get(i).getDescriptionBox().equals("") && myTable.getItems().get(i).getStringDueDate().equals(LocalDateTime.now().toLocalDate().toString())){
                continue;
            }
            // check through the permanent list to see if it is a copy
            else{
                for(int j = 0; j < TDListPermanent.list.size(); j++){
                    if(TDListPermanent.list.get(j).getStringDesc() != null){
                        if(TDListPermanent.list.get(j).getBoolComplete() == myTable.getItems().get(i).getBoolComplete() && TDListPermanent.list.get(j).getStringDesc().equals(myTable.getItems().get(i).getStringDesc()) && TDListPermanent.list.get(j).getStringDueDate().equals(myTable.getItems().get(i).getStringDueDate())){
                            k = 1;
                        }
                    }
                }
            }
            // if the item isn't a copy of another item and isn't blank, add it to the permanent list of items
            if(k != 1){
                TDListPermanent.list.get(i).setBoolComplete(TDList.list.get(i).getIsItemComplete().isSelected());
                TDListPermanent.list.get(i).setStringDesc(TDList.list.get(i).getDescriptionBox().getPromptText());
                TDListPermanent.list.get(i).setStringDueDate(TDList.list.get(i).getItemDueDate());
            }
        }
    }
    public void copyData(){
        // transfer all data from the permanent list to the temporary list
        for(int i = 0; i < TDListPermanent.list.size(); i++){
            TDList.list.add(new ToDoItem(TDListPermanent.list.get(i).getBoolComplete(), TDListPermanent.list.get(i).getStringDesc()));
        }
    }
}
