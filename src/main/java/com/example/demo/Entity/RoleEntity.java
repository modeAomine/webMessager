package com.example.demo.Entity;


public enum RoleEntity {

    USER("Пользователь"),

    ADMIN("Администратор");

    private final String name;

    RoleEntity(String name) { this.name = name; }

    public String getName() { return name; }
}
