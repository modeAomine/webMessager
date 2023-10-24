package com.example.demo.Service;

import com.example.demo.Entity.UserEntity;
import com.example.demo.Repo.UserRepo;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.stream.Collectors;

@Service
public class CustomUserService implements UserDetailsService {

    private UserRepo repo;

    public CustomUserService(UserRepo repo) { this.repo = repo; }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserEntity user = (UserEntity) repo.findByLogin(login);
        if (user != null) {
            return new org.springframework.security.core.userdetails.User(user.getLogin(),
                    user.getPassword(),
                    user.getRoles()
                            .stream()
                            .map(role -> new SimpleGrantedAuthority(role.getName()))
                            .collect(Collectors.toList()));
        } else {
            throw new UsernameNotFoundException("Не верный логин или пароль");
        }
    }
}
