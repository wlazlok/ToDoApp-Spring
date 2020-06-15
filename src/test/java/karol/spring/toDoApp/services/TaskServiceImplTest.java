package karol.spring.toDoApp.services;

import karol.spring.toDoApp.commands.TaskCommand;
import karol.spring.toDoApp.converters.TaskCommandToTask;
import karol.spring.toDoApp.converters.TaskToTaskCommand;
import karol.spring.toDoApp.models.Task;
import karol.spring.toDoApp.repositories.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * @author Karol Wlazło
 * toDoApp
 */

class TaskServiceImplTest {

    TaskServiceImpl taskService;

    @Mock
    TaskRepository taskRepository;

    @Mock
    TaskCommandToTask taskCommandToTask;

    @Mock
    TaskToTaskCommand taskToTaskCommand;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        taskService = new TaskServiceImpl(taskRepository,
                taskCommandToTask, taskToTaskCommand);
    }

    @Test
    void getTasks() {
        Task task = new Task();
        List tasks = new ArrayList();
        tasks.add(task);

        when(taskRepository.findAll()).thenReturn(tasks);

        List<Task> taskData = taskService.getTasks();

        assertEquals(taskData.size(), 1);
        verify(taskRepository, times(1)).findAll();
    }

    @Test
    void saveTaskCommand() {
    }

    @Test
    void deleteById() {
        Long idToDelete = Long.valueOf(2L);

        taskService.deleteById(idToDelete);

        verify(taskRepository, times(1)).deleteById(anyLong());
    }

    @Test
    void deleteByIdWithObject() {
        Task task = new Task();
        task.setId(2L);
        taskRepository.save(task);

        taskService.deleteById(2L);

        List<Task> tasks = (List<Task>) taskRepository.findAll();

        assertEquals(0, tasks.size());

        verify(taskRepository, times(1)).save(anyObject());
        verify(taskRepository, times(1)).findAll();
    }

    @Test
    void findById() {
        Task task = new Task();
        task.setId(1L);

        Optional<Task> taskOptional = Optional.of(task);

        when(taskRepository.findById(anyLong())).thenReturn(taskOptional);

        Task taskReturned = taskService.findById(1L);

        verify(taskRepository, times(1)).findById(anyLong());
        verify(taskRepository, never()).findAll();
    }

    @Test
    void findCommandById() {
        Task task = new Task();
        task.setId(1L);

        Optional<Task> recipeOptional = Optional.of(task);

        when(taskRepository.findById(anyLong())).thenReturn(recipeOptional);

        TaskCommand taskCommand = new TaskCommand();
        taskCommand.setId(1L);

        when(taskToTaskCommand.convert(any())).thenReturn(taskCommand);

        TaskCommand taskById = taskService.findCommandById(1L);

        verify(taskRepository, times(1)).findById(anyLong());
        verify(taskRepository, never()).findAll();
    }
}