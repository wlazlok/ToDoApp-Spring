package karol.spring.toDoApp.services;

import karol.spring.toDoApp.models.Task;

import java.util.List;

/**
 * @author Karol Wlazło
 * toDoApp
 */

public interface TaskService {

    List<Task> getTasks();
}
