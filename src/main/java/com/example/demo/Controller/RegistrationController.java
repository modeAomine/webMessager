package com.example.demo.Controller;

import com.example.demo.Impl.UserImpl;
import com.example.demo.Model.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping
@AllArgsConstructor
public class AuthController {
    private final UserImpl userImpl;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("user", new User());
        return "html/registration";
    }

    @PostMapping("/registration/save")
    public String registration(@ModelAttribute("user") User user, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        try {
            System.out.println("Проверка вывода!" + user.getLogin());
            userImpl.registerAuthUser(user, redirectAttributes);
            return "redirect:/login";
        } catch (IllegalArgumentException e) {
            result.rejectValue("username", "", e.getMessage());
            model.addAttribute("user", user);
            return "html/registration";
        }
    }

    @PostMapping("/auth")
    public String auth(@ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
        try {
            User userLogin = userImpl.findByLogin(user.getLogin());
            if (userLogin != null) {
                session.setAttribute("userId", userLogin);
                return "redirect:/profile";
            }
        } catch (IllegalArgumentException e) {
            result.rejectValue("error", "400", e.getMessage());
            model.addAttribute("user", user);
        }
        return "html/authorization";
    }

    @GetMapping("/login")
    public String login() {
        return "html/authorization";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        userImpl.logout(request, response);
        return "redirect:/login?logout";
    }
}
