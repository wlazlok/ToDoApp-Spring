package karol.spring.toDoApp.converters;

import karol.spring.toDoApp.commands.TaskCommand;
import karol.spring.toDoApp.models.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Karol Wlazło
 * toDoApp
 */
class TaskCommandToTaskTest {

    TaskCommandToTask converter;

    @BeforeEach
    void setUp() {
        converter = new TaskCommandToTask();
    }

    @Test
    void testNull() {
        assertNull(converter.convert(null));
    }

    @Test
    void testEmptyObject() {
        assertNotNull(converter.convert(new TaskCommand()));
    }

    @Test
    void convert() {
        TaskCommand taskCommand = new TaskCommand();
        taskCommand.setId(1L);
        taskCommand.setDescription("TEST");

        Task task = converter.convert(taskCommand);

        assertEquals(1L, task.getId());
        assertEquals("TEST", task.getDescription());
    }
}