package com.app.todo.service;

import com.app.todo.model.Task;
import com.app.todo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public void addTask(String title){
        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepository.save(task);
    }

    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }

    public void toggleTask(Long id){
        // Optional<Task> task = taskRepository.findById(id);
        Task task = taskRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        task.setCompleted(!task.isCompleted());
        taskRepository.save(task);
    }
}