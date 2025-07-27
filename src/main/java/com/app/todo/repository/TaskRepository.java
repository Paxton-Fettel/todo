package com.app.todo.repository;

import com.app.todo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
    // Enables Crud Operations
    // save(), findAll(), findById(), deleteById(), .. are provided
}
