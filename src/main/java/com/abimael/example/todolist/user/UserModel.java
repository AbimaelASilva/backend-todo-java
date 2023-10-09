package com.abimael.example.todolist.user;

import java.util.HashMap;
import java.util.Map;

public class UserModel {

    String name;

    String userName;

    String password;

    public UserModel(String name, String userName, String password) {
        this.name = name;
        this.userName = userName;
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String email) {
        this.password = email;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Map<String, String> toMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("name", name);
        map.put("userName", userName);
        map.put("password", password);
        return map;
    }

    public static UserModel fromMap(Map<String, String> map) {
        
        return new UserModel(
                map.get("name"),
                map.get("userName"),
                map.get("password")

        );
    }
}