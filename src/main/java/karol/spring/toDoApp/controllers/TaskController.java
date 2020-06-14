package karol.spring.toDoApp.controllers;

import karol.spring.toDoApp.commands.TaskCommand;
import karol.spring.toDoApp.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Struct;

/**
 * @author Karol Wlazło
 * toDoApp
 */

@Controller
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping("/add")
    public String addNewTask(Model model){

        model.addAttribute("task", new TaskCommand());

        return "task/taskform";
    }

    @PostMapping("task")
    public String saveOrUpdate(@ModelAttribute TaskCommand command){

        TaskCommand savedCommand = taskService.saveTaskCommand(command);

        return "redirect:/";
    }

    @GetMapping
    @RequestMapping("/delete/{id}")
    public String deleteById(@PathVariable String id){
        taskService.deleteById(Long.valueOf(id));

        return "redirect:/";
    }

    @RequestMapping("update/{id}")
    public String updateTask(@PathVariable String id, Model model){

        model.addAttribute("task", taskService.findCommandById(Long.valueOf(id)));

        return "task/taskform";
    }

    @RequestMapping("/task/show/{id}")
    public String showById(@PathVariable String id, Model model){

        model.addAttribute("task", taskService.findById(Long.valueOf(id)));

        return "task/show";
    }
}
