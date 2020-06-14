package karol.spring.toDoApp.converters;

import karol.spring.toDoApp.commands.TaskCommand;
import karol.spring.toDoApp.models.Task;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author Karol Wlazło
 * toDoApp
 */
@Component
public class TaskCommandToTask implements Converter<TaskCommand, Task> {

    @Override
    public Task convert(TaskCommand source) {
        if(source == null)
            return null;
        final Task task = new Task();
        task.setId(source.getId());
        task.setDescription(source.getDescription());

        return task;
    }
}
