package com.abimael.example.todolist.user;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping("/create")
    public void create(@RequestBody UserModel user) {
        Map<String, String> map = user.toMap();

        UserModel teste = UserModel.fromMap(map);

        System.out.println(teste.name);

    }

}
