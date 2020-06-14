package karol.spring.toDoApp.services;

import karol.spring.toDoApp.commands.TaskCommand;
import karol.spring.toDoApp.models.Task;

import java.util.List;

/**
 * @author Karol Wlazło
 * toDoApp
 */

public interface TaskService {

    List<Task> getTasks();

    TaskCommand saveTaskCommand(TaskCommand command);

    void deleteById(Long id);

    TaskCommand findCommandById(Long id);

    Task findById(Long id);
}
