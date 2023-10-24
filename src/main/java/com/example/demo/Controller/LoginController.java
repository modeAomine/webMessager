package com.example.demo.Controller;

import com.example.demo.Entity.UserEntity;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private UserService service;

    @PostMapping("/login")
    public String loginUser(@ModelAttribute Model model, UserEntity data) {
        model.addAttribute("users", new UserEntity());
        model.addAttribute("user", service.loginUser(data.getLogin(), data.getPassword()));


        return "loginPage";

        }

        @GetMapping("/login/page")
        public String loginUser(UserEntity data) {
        if (service.searchLoginUser(data.getLogin()) != null) {

            return "redirect:/mes/page?id=" + data.getId();
            /*return "redirect:/mes/page?id=" + data.getId();*/
        }

        return "redirect:/mes?error";
    }
}
