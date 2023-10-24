package com.example.demo.Utils;

import com.example.demo.Entity.UserEntity;
import com.example.demo.Exception.UserException;
import com.example.demo.Service.UserService;
import jakarta.validation.ValidationException;
import javafx.scene.control.Alert;

public class ValidationUser {

    public static UserService service;

    public ValidationUser(UserService service) {
        this.service = service;
    }

    public static void validationUser(UserEntity data) throws UserException {

        String password = data.getPassword();
        String confirm_password = data.getConfirm_password();
        if (password == null || password.length() == 0);


        if (password.matches("[a-zA-Z]+") && password.length() >= 6 && password.length() <= 32);


        if (password != confirm_password);


        String user = data.getLogin();
    }
}
