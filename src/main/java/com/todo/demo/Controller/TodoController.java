package com.todo.demo.Controller;



import com.todo.demo.Entity.Task;
import com.todo.demo.Service.TaskServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;




@Controller
@RequestMapping("/todo")
public class TodoController {

    private final TaskServices taskServices;

    public TodoController(TaskServices taskServices) {
        this.taskServices = taskServices;
    }
    @GetMapping("/getTasks")
    public String getTasks(Model model){
        List<Task> tasks=taskServices.getAllTasks();
        model.addAttribute("tasks",tasks);
        return "tasks";
    }
}
