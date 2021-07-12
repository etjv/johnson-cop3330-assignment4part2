package ucf.assignments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppControllerTest {
    @Test
    void addItem() {
        AppController a = new AppController();
        ToDoList expectedList = new ToDoList();
        ToDoList actualList = new ToDoList();
        ToDoList temp = new ToDoList();
        // create a new item in the expected list
        expectedList.list.add(new ToDoItem(false, "Description"));
        // create a new item in the actual list using the addItem method
        a.addItem(temp, actualList, false, "Description");
        // assert that the values of items are the same
        assertEquals(expectedList.list.get(0).getBoolComplete(), actualList.list.get(0).getBoolComplete());
        assertEquals(expectedList.list.get(0).getStringDesc(), actualList.list.get(0).getStringDesc());
        assertEquals(expectedList.list.get(0).getStringDueDate(), actualList.list.get(0).getStringDueDate());
    }

    @Test
    void removeItem() {
        AppController a = new AppController();
        ToDoList expectedList = new ToDoList();
        ToDoList actualList = new ToDoList();
        // add an item to the actual list
        actualList.list.add(new ToDoItem(false, "Description"));
        // remove the item with the removeItem method
        a.removeItem(actualList, 0);
        // assert that both lists are empty
        assertEquals(expectedList.list.size(), actualList.list.size());
    }

    @Test
    void removeALlItems() {
        AppController a = new AppController();
        ToDoList expectedList = new ToDoList();
        ToDoList actualList = new ToDoList();
        // add multiple items to the actual list
        actualList.list.add(new ToDoItem(false, "Description"));
        actualList.list.add(new ToDoItem(false, "Description"));
        actualList.list.add(new ToDoItem(false, "Description"));
        // remove the items with the removeAllItem method
        a.removeItem(actualList, 0);
        // assert that both lists are empty
        assertEquals(expectedList.list.size(), actualList.list.size());
    }

}