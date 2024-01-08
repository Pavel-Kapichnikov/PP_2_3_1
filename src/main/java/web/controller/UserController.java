package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.User;
import web.service.UserService;

@Controller
public class UserController {
    private static final String REDIRECT_USERS = "redirect:/users";
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }
    @GetMapping("/create")
    public String creator(Model model) {
        model.addAttribute("user", new User());
        return "creator";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return REDIRECT_USERS;
    }

    @GetMapping("/edit")
    public String editor(@RequestParam(value = "id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "editor";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("user") User user, @RequestParam(value = "id") long id) {
        userService.editUser(id, user);
        return REDIRECT_USERS;
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam(value = "id") long id) {
        userService.deleteUser(id);
        return REDIRECT_USERS;
    }
}
