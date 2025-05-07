package br.com.rocket.testefreshdesk.modules.user.controllers;


import br.com.rocket.testefreshdesk.modules.user.UserEntity;
import br.com.rocket.testefreshdesk.modules.user.db.UserDatabase;
import br.com.rocket.testefreshdesk.modules.user.services.UserService;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/new")
    public String criar(Model model) {
        model.addAttribute("user", new UserEntity());
        return "user-form";
    }

    @PostMapping("/save")
    public String salvar(@ModelAttribute("user") UserEntity user) {
        userService.createUser(user);
        return "redirect:new";
    }

}
