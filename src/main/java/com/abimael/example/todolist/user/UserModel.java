package com.abimael.example.todolist.user;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data // este cara provê os setters e getters como no código comentado à baixo
@Entity(name = "tb_users")
public class UserModel {

    @Id
    @GeneratedValue(generator ="UUID")
    private UUID id;

    private String name;

    @Column(unique = true)
    private String userName;

    private String password;

    @CreationTimestamp
    private LocalDateTime createdAt;

    // public UserModel(String name, String userName, String password) {
    //     this.name = name;
    //     this.userName = userName;
    //     this.password = password;
    // }

    // public void setUserName(String userName) {
    //     this.userName = userName;
    // }

    // public String getUserName() {
    //     return userName;
    // }

    // public void setPassword(String email) {
    //     this.password = email;
    // }

    // public String getPassword() {
    //     return password;
    // }

    // public void setName(String name) {
    //     this.name = name;
    // }

    // public String getName() {
    //     return name;
    // }

    // public Map<String, String> toMap() {
    //     HashMap<String, String> map = new HashMap<>();
    //     map.put("name", name);
    //     map.put("userName", userName);
    //     map.put("password", password);
    //     return map;
    // }

    // public static UserModel fromMap(Map<String, String> map) {

    //     return new UserModel(
    //             map.get("name"),
    //             map.get("userName"),
    //             map.get("password")

    //     );
    // }
}