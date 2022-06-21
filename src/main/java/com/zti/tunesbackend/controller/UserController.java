package com.zti.tunesbackend.controller;
import java.util.List;
import java.util.Optional;

import com.zti.tunesbackend.entity.PlaylistEntity;
import com.zti.tunesbackend.entity.UserEntity;
import com.zti.tunesbackend.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserEntity> findAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<UserEntity> findUserById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @GetMapping("/{login}/{password}")
    public UserEntity findUserByCredentials(
            @PathVariable("login") String login,
            @PathVariable("password") String password) {

        List<UserEntity> allUsers = userService.findAllUsers();
        for(UserEntity user: allUsers){
            if (user.getUsername().equals(login))
                if (user.getPassword().equals(password)) {
                    return user;
                }
        }
        return null;
    }

    @PostMapping
    public UserEntity saveUser(@RequestBody UserEntity userEntity) {
        return userService.saveUser(userEntity);
    }

    @PutMapping
    public UserEntity updateUser(@RequestBody UserEntity userEntity) {
        return userService.updateUser(userEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }
}