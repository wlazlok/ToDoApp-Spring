package karol.spring.toDoApp.boostrap;

import karol.spring.toDoApp.models.Task;
import karol.spring.toDoApp.repositories.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Karol Wlazło
 * toDoApp
 */
@Component
public class LoadData implements CommandLineRunner {

    private final TaskRepository taskRepository;


    public LoadData(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        taskRepository.saveAll(getTasks());
    }

    private List<Task> getTasks(){
        List<Task> tasks = new ArrayList<>();

        Task task = new Task();
        task.setDescription("Test task added");
        tasks.add(task);

        Task task2 = new Task();
        task2.setDescription("Clean up room");
        tasks.add(task2);

        return tasks;
    }
}
