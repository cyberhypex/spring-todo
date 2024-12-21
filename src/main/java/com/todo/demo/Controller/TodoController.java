package com.todo.demo.Controller;



import com.todo.demo.Entity.Task;
import com.todo.demo.Service.TaskServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@Controller
@RequestMapping("/")
public class TodoController {

    private final TaskServices taskServices;

    public TodoController(TaskServices taskServices) {
        this.taskServices = taskServices;
    }
    @GetMapping
    public String getTasks(Model model){
        List<Task> tasks=taskServices.getAllTasks();
        model.addAttribute("tasks",tasks);
        return "tasks";
    }

    @PostMapping
    public String addTasks(@RequestParam String title){
        taskServices.createTask(title);
        return "redirect:/";
    }

    @GetMapping("/{ID}/delete")
    public String deleteTask(@PathVariable Long ID){
        taskServices.deleteTask(ID);
        return "redirect:/";
    }

    @GetMapping("/{ID}/toggle")
    public String markTask(@PathVariable Long ID){
        taskServices.markTask(ID);
        return "redirect:/";
    }

}
