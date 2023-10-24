package com.example.demo.Repo;

import com.example.demo.Entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepo extends CrudRepository<UserEntity, Long> {
    Iterable<UserEntity> findByLogin (String login);

    Optional<UserEntity> findById (Long id);

    Iterable<UserEntity> findByLoginAndPassword(String login, String password);
}
