package karol.spring.toDoApp.commands;

/**
 * @author Karol Wlazło
 * toDoApp
 */
public class TaskCommand {

    private Long id;
    private String description;

    public TaskCommand() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
