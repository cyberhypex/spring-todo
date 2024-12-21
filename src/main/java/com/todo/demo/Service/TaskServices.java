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

    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }

    public void markTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Task not found"));
        System.out.println("Current hasCompleted: " + task.isHasCompleted());
        task.setHasCompleted(!task.isHasCompleted());
        taskRepository.save(task);
        System.out.println("Updated hasCompleted: " + task.isHasCompleted());
    }

}
