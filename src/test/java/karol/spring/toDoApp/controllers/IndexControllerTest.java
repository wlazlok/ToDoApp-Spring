package karol.spring.toDoApp.controllers;

import karol.spring.toDoApp.models.Task;
import karol.spring.toDoApp.services.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


/**
 * @author Karol Wlazło
 * toDoApp
 */

class IndexControllerTest {

    @Mock
    TaskService taskService;

    @Mock
    Model model;

    IndexController indexController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        indexController = new IndexController(taskService);
    }

    @Test
    void getIndexPage() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task());

        Task task = new Task();
        task.setId(1L);

        tasks.add(task);

        when(taskService.getTasks()).thenReturn(tasks);


        String viewName = indexController.getIndexPage(model);

        assertEquals("index", viewName);
        verify(taskService, times(1)).getTasks();
        assertEquals(2, taskService.getTasks().size());
        verify(taskService, times(2)).getTasks();
    }

    @Test
    void testMockMVC() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }
}