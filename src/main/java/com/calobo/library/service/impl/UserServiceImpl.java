package com.calobo.library.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.calobo.library.models.request.UserRequest;
import com.calobo.library.repository.UserRepository;
import com.calobo.library.repository.entity.UserEntity;
import com.calobo.library.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    
    @Override
    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity getUserById(Long id) {
        UserEntity user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario No Existe"));
  
        return user;
    }

    @Override
    public UserEntity create(UserRequest request) {
        UserEntity user = UserEntity.builder()
            .name(request.getName())
            .lastName(request.getLastName())
            .email(request.getEmail())
            .birthDate(request.getBirthDate())
            .build();

        userRepository.save(user);
            
        return user;
    }

    @Override
    public UserEntity update(Long id, UserRequest request) {
        UserEntity user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario No Existe"));

        user.setName(request.getName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setBirthDate(request.getBirthDate());


        userRepository.save(user);

        return user;
    }

    @Override
    public UserEntity delete(Long id) {
        UserEntity user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario No Existe"));


        userRepository.delete(user);
        return user;
    }


}
