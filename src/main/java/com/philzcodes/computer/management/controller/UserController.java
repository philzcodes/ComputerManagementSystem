package com.philzcodes.computer.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.philzcodes.computer.management.model.User;
import com.philzcodes.computer.management.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String showUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        model.addAttribute("auditLogs", userService.getAuditLogs());  // Add audit logs to the model
        return "user_management";  // Return the Thymeleaf template
    }

    @PostMapping("/users/add")
    public String addUser(@ModelAttribute User user) {
        userService.save(user);  // Save new user
        return "redirect:/users";
    }

    @GetMapping("/users/edit/{id}")
    @ResponseBody
    public User editUser(@PathVariable Long id) {
        return userService.findById(id);  // Return the user data as JSON for editing
    }

    @PostMapping("/users/edit/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute User user) {
        user.setId(id);  // Set the correct ID for updating
        userService.save(user);
        return "redirect:/users";
    }

    @DeleteMapping("/users/delete/{id}")
    @ResponseBody
    public String deleteUser(@PathVariable Long id) {
        userService.delete(id);  // Delete the user
        return "User deleted successfully!";
    }
}
