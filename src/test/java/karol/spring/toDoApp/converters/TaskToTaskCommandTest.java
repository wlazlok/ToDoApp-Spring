package karol.spring.toDoApp.converters;

import karol.spring.toDoApp.commands.TaskCommand;
import karol.spring.toDoApp.models.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Karol Wlazło
 * toDoApp
 */
class TaskToTaskCommandTest {

    TaskToTaskCommand converter;

    @BeforeEach
    void setUp() {
        converter = new TaskToTaskCommand();
    }

    @Test
    void testNull() {
        assertNull(converter.convert(null));
    }

    @Test
    void testEmptyObject() {
        assertNotNull(converter.convert(new Task()));
    }

    @Test
    void convert() {
        Task task = new Task();
        task.setId(2L);
        task.setDescription("TEST");

        TaskCommand taskCommand = converter.convert(task);

        assertEquals(2L, taskCommand.getId());
        assertEquals("TEST", taskCommand.getDescription());
    }
}