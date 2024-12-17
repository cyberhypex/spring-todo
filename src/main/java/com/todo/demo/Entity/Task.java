package com.todo.demo.Entity;


import jakarta.persistence.*;

@Entity
@lombok.Data
@Table(name="Task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String task;
    private boolean hasCompleted;


}
