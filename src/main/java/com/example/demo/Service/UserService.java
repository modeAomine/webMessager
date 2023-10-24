package com.example.demo.Service;

import com.example.demo.Entity.RoleEntity;
import com.example.demo.Entity.UserEntity;
import com.example.demo.Repo.UserRepo;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepo repo;
    public UserEntity data;

    public UserService(UserRepo repo) { this.repo = repo; }

    public void save(UserEntity data) {
        data.setLogin(data.getLogin());
        data.setPassword(data.getPassword());
        data.setAvatar(data.getAvatar());
        // Добавляем роль "USER"
        data.getRoles().add(RoleEntity.USER);

        repo.save(data);
    }

    public Iterable<UserEntity> getAll() { return repo.findAll(); }

    public Iterable<UserEntity> loginUser(String login, String password) {
        return repo.findByLoginAndPassword(login, password);
    }

    public Optional<UserEntity> setUser(Long id) { return repo.findById(id); }
    public Iterable<UserEntity> searchLoginUser(String login) {
        return repo.findByLogin(login);
    }
}
