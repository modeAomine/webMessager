package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "users_id")
    private Long id;
    private String login;
    private String password;
    private String confirm_password;
    @Lob
    private byte[] avatar;
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @ElementCollection(targetClass = RoleEntity.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<RoleEntity> roles = new HashSet<>();
}
