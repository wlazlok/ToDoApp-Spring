package karol.spring.toDoApp.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Karol Wlazło
 * toDoApp
 */
class TaskTest {

    Task task;

    @BeforeEach
    void setUp() {
        task = new Task();
    }

    @Test
    void getId() {
        Long id = 4L;
        task.setId(id);

        assertEquals(id, task.getId());
    }


    @Test
    void getDescription() {
        String desc = "test description";
        task.setDescription(desc);
        assertEquals(desc, task.getDescription());
    }


}