package br.com.rocket.testefreshdesk.controllers;

import br.com.rocket.testefreshdesk.modules.user.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cronosdesk")
public class RouteController {

    @GetMapping("/cadastro")
    public String showForm(Model model) {
        model.addAttribute("user", new UserEntity());
        return "create-user";
    }
}
