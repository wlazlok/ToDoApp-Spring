package karol.spring.toDoApp.controllers;


import karol.spring.toDoApp.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Karol Wlazło
 * toDoApp
 */

@Controller
public class IndexController {

    private final TaskService taskService;

    @Autowired
    public IndexController(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping("/")
    public String getIndexPage(Model model){

        model.addAttribute("tasks", taskService.getTasks());

        return "index";
    }
}
