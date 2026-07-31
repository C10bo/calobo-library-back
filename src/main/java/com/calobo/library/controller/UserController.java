package com.calobo.library.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.calobo.library.controller.api.UserApi;
import com.calobo.library.models.request.UserRequest;
import com.calobo.library.repository.entity.UserEntity;
import com.calobo.library.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {

    private final UserService userService;
    
    @Override
    public ResponseEntity<List<UserEntity>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @Override
    public ResponseEntity<UserEntity> getUSerById(Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @Override
    public ResponseEntity<UserEntity> create(UserRequest request) {
        return ResponseEntity.ok(userService.create(request));
    }

    @Override
    public ResponseEntity<UserEntity> update(Long id, UserRequest request) {
        return ResponseEntity.ok(userService.update(id, request));
    }

    @Override
    public ResponseEntity<UserEntity> delete(Long id) {
        return ResponseEntity.ok(userService.delete(id));
    }

}
