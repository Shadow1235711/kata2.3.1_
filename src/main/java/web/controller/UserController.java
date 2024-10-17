package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping()
    public String AllUsers(Model model) {
        model.addAttribute("users",userService.getUsers() );
        return "allUsers";
    }

    @GetMapping("/ID")
    public String UserDetails(@RequestParam("id") int id, Model model) {
        model.addAttribute("user",userService.showUser(id));
        System.out.println("ID"+id);
        return "userDetails";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user",new User());
        return "newUser";
    }
    @PostMapping()
    public String creatUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }
}
