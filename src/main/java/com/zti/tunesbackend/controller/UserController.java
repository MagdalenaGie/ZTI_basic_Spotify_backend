package com.zti.tunesbackend.controller;
import java.util.List;
import java.util.Optional;

import com.zti.tunesbackend.entity.PlaylistEntity;
import com.zti.tunesbackend.entity.UserEntity;
import com.zti.tunesbackend.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
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

    @PostMapping("playlist/{id}")
    public Optional<UserEntity> addPlaylistToUser(@PathVariable("id") Long id, @RequestBody PlaylistEntity playlist) {
        Optional<UserEntity> optionalUser = userService.findById(id);
        optionalUser.ifPresent( user -> user.addPlaylist(playlist));
        return optionalUser;
    }
}