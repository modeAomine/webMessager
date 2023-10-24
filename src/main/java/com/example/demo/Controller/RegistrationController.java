package com.example.demo.Controller;

import com.example.demo.Entity.RoleEntity;
import com.example.demo.Messages.BaseMessage;
import com.example.demo.Messages.UserMessage;
import com.example.demo.Utils.ValidationUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import com.example.demo.Entity.UserEntity;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@Controller
@RequiredArgsConstructor
@RequestMapping("/mes")
public class RegistrationController {

    @Autowired
    private UserService user_service;

    @GetMapping("/all")
    public String all(Model model) {
        model.addAttribute("users",user_service.getAll());
        model.addAttribute("user",new UserEntity());

        return "registrationPage";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute UserEntity data) {
        if (user_service.searchLoginUser(data.getLogin()) != null) {
            try {
                ValidationUser.validationUser(data);
                user_service.save(data);
                data.setRoles(Collections.singleton(RoleEntity.USER));
       /*     // Передаем имя пользователя в модель
            model.addAttribute("user", data.getLogin());
*/
                // Перенаправляем пользователя на страницу профиля
                return "redirect:/page?id=" + data.getId();
            } catch (Exception e) {
                return "redirect:/mes/all";
            }
        }

        // После успешной регистрации, вы можете перенаправить пользователя на другую страницу.
        return "redirect:/mes/all"; // Пример перенаправления на страницу входа. "redirect:/register?error"
    }
}