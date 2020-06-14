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
public class TaskToTaskCommand implements Converter<Task, TaskCommand> {

    @Override
    public TaskCommand convert(Task source) {
        if(source == null)
            return null;

        final TaskCommand taskCommand = new TaskCommand();
        taskCommand.setId(source.getId());
        taskCommand.setDescription(source.getDescription());

        return taskCommand;
    }
}
