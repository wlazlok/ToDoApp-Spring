package karol.spring.toDoApp.controllers;

import karol.spring.toDoApp.commands.TaskCommand;
import karol.spring.toDoApp.services.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/**
 * @author Karol Wlazło
 * toDoApp
 */
class TaskControllerTest {

    @Mock
    TaskService taskService;

    TaskController taskController;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        taskController = new TaskController(taskService);
        mockMvc = MockMvcBuilders.standaloneSetup(taskController).build();
    }

    @Test
    void testGetNewTaskForm() throws Exception {
        TaskCommand taskCommand = new TaskCommand();

        mockMvc.perform(get("/add"))
                .andExpect(status().isOk())
                .andExpect(view().name("task/taskform"))
                .andExpect(model().attributeExists("task"));
    }

    @Test
    void deleteById() throws Exception {
        mockMvc.perform(get("/delete/1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/"));

        verify(taskService, times(1)).deleteById(anyLong());
    }

    @Test
    void updateTask() throws Exception {
        TaskCommand taskCommand = new TaskCommand();
        taskCommand.setId(2L);

        when(taskService.findCommandById(anyLong())).thenReturn(taskCommand);

        mockMvc.perform(get("/update/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("task/taskform"))
                .andExpect(model().attributeExists("task"));
    }

    @Test
    void showById() {
    }
}