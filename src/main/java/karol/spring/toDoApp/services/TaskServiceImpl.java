package karol.spring.toDoApp.services;

import karol.spring.toDoApp.models.Task;
import karol.spring.toDoApp.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Karol Wlazło
 * toDoApp
 */

@Service
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getTasks() {

        List<Task> tasks = new ArrayList<>();

        taskRepository.findAll().forEach(tasks::add);

        return tasks;
    }
}
