package com.vishnu.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vishnu.entity.EmployeeTask;
import com.vishnu.service.TaskService;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public String listTasks(Model model) {
        List<EmployeeTask> employeeTasks = taskService.findAll();
        model.addAttribute("tasks", employeeTasks);
        return "tasks/list";
    }

    @GetMapping("/create")
    public String createTaskForm(Model model) {
        model.addAttribute("task", new EmployeeTask());
        return "tasks/create";
    }

    @PostMapping("/save")
    public String saveTask(@ModelAttribute EmployeeTask employeeTask) {
        taskService.save(employeeTask);
        return "redirect:/tasks";
    }

    @GetMapping("/edit/{id}")
    public String editTaskForm(@PathVariable Long id, Model model) {
        EmployeeTask employeeTask = taskService.findById(id);
        model.addAttribute("task", employeeTask);
        return "tasks/edit";
    }

    @PostMapping("/update/{id}")
    public String updateTask(@PathVariable Long id, @ModelAttribute EmployeeTask employeeTask) {
        employeeTask.setId(id);
        taskService.save(employeeTask);
        return "redirect:/tasks";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.delete(id);
        return "redirect:/tasks";
    }
}
