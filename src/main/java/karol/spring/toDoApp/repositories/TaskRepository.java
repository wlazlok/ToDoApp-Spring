package karol.spring.toDoApp.repositories;

import karol.spring.toDoApp.models.Task;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Karol Wlazło
 * toDoApp
 */
public interface TaskRepository extends CrudRepository<Task, Long> {
}
