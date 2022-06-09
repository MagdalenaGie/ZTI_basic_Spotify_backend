package com.zti.tunesbackend.service;
import com.zti.tunesbackend.entity.UserEntity;

import java.util.List;
import java.util.Optional;


public interface UserService {
    List<UserEntity> findAllUsers();
    Optional<UserEntity> findById(Long id);
    UserEntity saveUser(UserEntity employeeEntity);
    UserEntity updateUser(UserEntity employeeEntity);
    void deleteUser(Long id);
}
