package karol.spring.toDoApp.services;

import karol.spring.toDoApp.commands.TaskCommand;
import karol.spring.toDoApp.converters.TaskCommandToTask;
import karol.spring.toDoApp.converters.TaskToTaskCommand;
import karol.spring.toDoApp.models.Task;
import karol.spring.toDoApp.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Karol Wlazło
 * toDoApp
 */

@Service
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;
    public final TaskCommandToTask taskCommandToTask;
    public final TaskToTaskCommand taskToTaskCommand;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, TaskCommandToTask taskCommandToTask, TaskToTaskCommand taskToTaskCommand) {
        this.taskRepository = taskRepository;
        this.taskCommandToTask = taskCommandToTask;
        this.taskToTaskCommand = taskToTaskCommand;
    }

    @Override
    public List<Task> getTasks() {

        List<Task> tasks = new ArrayList<>();

        taskRepository.findAll().forEach(tasks::add);

        return tasks;
    }

    @Override
    @Transactional
    public TaskCommand saveTaskCommand(TaskCommand command) {
        Task detachedTask = taskCommandToTask.convert(command);
        Task savedTask = taskRepository.save(detachedTask);

        return taskToTaskCommand.convert(savedTask);
    }

    @Override
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Task findById(Long id) {
        Optional<Task> result = taskRepository.findById(id);
        return result.get();
    }

    @Override
    @Transactional
    public TaskCommand findCommandById(Long id) {
        return taskToTaskCommand.convert(findById(id));
    }

}
