package com.example.demo.Controller;

import com.example.demo.Entity.UserEntity;
import com.example.demo.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestPart;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class PageController {

    @Autowired
    private UserService service;

    @GetMapping("/page")
    public String pageUser(@RequestParam(defaultValue = "") Long id, Model model) {
        model.addAttribute("user", service.setUser(id));
        model.addAttribute("users", new UserEntity());

        return "profilePage";
    }

    @PostMapping("/uploadAvatar")
    public String uploadAvatar(@ModelAttribute UserEntity user, @RequestPart("avatarFile") MultipartFile avatarFile) {
        // Обработка загруженной аватарки
        if (!avatarFile.isEmpty()) {
            try {
                // Получите байты изображения из MultipartFile
                byte[] avatarBytes = avatarFile.getBytes();
                // Сохраните байты изображения в поле 'avatar' сущности 'UserEntity'
                user.setAvatar(avatarBytes);

                // Далее сохраните обновленную сущность 'UserEntity' в базе данных
                service.save(user);

                // Оповестите пользователя об успешной загрузке
                // Можете также добавить другую обработку и проверки
            } catch (IOException e) {
                // Обработка ошибки загрузки файла
            }
        }

        // Перенаправьте пользователя на страницу профиля
        return "redirect:/page?id=" + user.getId();
    }
}
