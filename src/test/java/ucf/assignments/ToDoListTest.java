package ucf.assignments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToDoListTest {
    @Test
    void setListTitle() {
        ToDoList list = new ToDoList();
        // expected title
        String expected = "title";
        // setting title with setListTitle method
        list.setListTitle("title");
        // assert they are equal
        assertEquals(list.getListTitle(), expected);
    }

    @Test
    void getListTitle() {
        ToDoList list = new ToDoList();
        // expected title
        String expected = "title";
        // setting title with setListTitle method
        list.setListTitle("title");
        // asserting that getListTitle method returns properly
        assertEquals(list.getListTitle(), expected);
    }
}