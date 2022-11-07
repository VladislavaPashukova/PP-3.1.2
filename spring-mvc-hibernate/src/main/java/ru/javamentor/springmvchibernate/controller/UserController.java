package ru.javamentor.springmvchibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.javamentor.springmvchibernate.model.User;
import ru.javamentor.springmvchibernate.service.UserServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {
    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getAllUsers(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "index";
    }

    @GetMapping("/new")
    public String getUserFormForCreate(Model model){
        model.addAttribute("user", new User());
        return "new";
    }
    @PostMapping()
    public String saveNewUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String getFormForEditUser(Model model, @PathVariable("id") Long id){
        User user = userService.findById(id);
        model.addAttribute("user", user);
        model.addAttribute("user", userService.findById(id));
        return "edit";
    }

    @PostMapping("/{id}")
    public String updateEditUser(@ModelAttribute("user") User user){
        userService.updateUser(user);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteUserById(id);
        return "redirect:/";
    }
}
