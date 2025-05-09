package br.com.rocket.testefreshdesk.modules.user.controllers;


import br.com.rocket.testefreshdesk.modules.user.UserEntity;
import br.com.rocket.testefreshdesk.modules.user.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.stream.Collectors;

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
        return "redirect:/cronosdesk/cadastro";
    }

}
