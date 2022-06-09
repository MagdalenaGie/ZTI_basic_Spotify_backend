package com.zti.tunesbackend.service.impl;
import com.zti.tunesbackend.entity.PlaylistEntity;
import com.zti.tunesbackend.entity.UserEntity;
import com.zti.tunesbackend.repository.UserRepository;
import com.zti.tunesbackend.service.UserService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository employeeRepository) {
        this.userRepository = employeeRepository;
    }

    @Override
    public List<UserEntity> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserEntity> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public UserEntity saveUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity updateUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
