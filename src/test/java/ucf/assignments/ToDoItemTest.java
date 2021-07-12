package ucf.assignments;

import javafx.scene.control.DatePicker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToDoItemTest {
    @Test
    void getItemDueDate() {
        // expected due date
        String expected = "2021-07-11";
        // create toDoItem
        ToDoItem actual = new ToDoItem(false, "");
        // set the due date using setStringDueDate
        actual.setItemDueDate("2021-07-11");
        // assert that getItemDueDate returns properly
        assertEquals(expected, actual.getStringDueDate());
    }

    @Test
    void setStringDueDate() {
        // expected due date
        String expected = "2021-07-11";
        // create toDoItem
        ToDoItem actual = new ToDoItem(false, "");
        // set the due date using setItemDueDate
        actual.setItemDueDate("2021-07-11");
        // assert that setItemDueDate set the date correctly
        assertEquals(expected, actual.getStringDueDate());
    }

    @Test
    void getStringDesc() {
        // expected description
        String expected = "this is the description";
        // create toDoItem with description
        ToDoItem actual = new ToDoItem(false, "this is the description");
        // assert that getStringDesc returns properly
        assertEquals(expected, actual.getStringDesc());
    }

    @Test
    void setStringDesc() {
        // expected description
        String expected = "this is the description";
        // create toDoItem
        ToDoItem actual = new ToDoItem(false, "");
        // change the description with setStringDesc
        actual.setStringDesc("this is the description");
        // assert that the descriptions are equal
        assertEquals(expected, actual.getStringDesc());
    }

    @Test
    void getBoolComplete() {
        // create toDoItem with description
        ToDoItem actual = new ToDoItem(false, "");
        // assert that getBoolComplete returns properly
        assertFalse(actual.getBoolComplete());
    }

    @Test
    void setBoolComplete() {
        // create toDoItem with description
        ToDoItem actual = new ToDoItem(false, "");
        // change the complete boolean with setBoolComplete
        actual.setBoolComplete(true);
        // assert that the bool is true
        assertTrue(actual.getBoolComplete());
    }
}