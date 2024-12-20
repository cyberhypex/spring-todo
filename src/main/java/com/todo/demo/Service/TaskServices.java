package com.todo.demo.Service;


import com.todo.demo.Entity.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServices {

    private final TaskRepository taskRepository;

    public TaskServices(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public void createTask(String title){
        Task task=new Task();
        task.setTitle(title);
        task.setHasCompleted(false);
        taskRepository.save(task);
    }
}
