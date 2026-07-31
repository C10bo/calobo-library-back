package com.calobo.library.controller.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.calobo.library.models.request.UserRequest;
import com.calobo.library.repository.entity.UserEntity;

import io.swagger.v3.oas.annotations.Operation;

@RequestMapping(path = "/user")
public interface UserApi {
    
    @GetMapping
    @Operation(summary = "service to get all users", tags = "User")
    public ResponseEntity<List<UserEntity>> getAll();

    @GetMapping("/{id}")
    @Operation(summary = "Service to get a user by id", tags = "User")
    public ResponseEntity<UserEntity> getUSerById(@PathVariable Long id);

    @PostMapping
    @Operation(summary = "Service to add a user", tags = "User")
    public ResponseEntity<UserEntity> create(@RequestBody UserRequest request);

    @PutMapping("/{id}")
    @Operation(summary = "Service to update a user", tags = "User")
    public ResponseEntity<UserEntity> update(@PathVariable Long id, @RequestBody UserRequest request);

    @DeleteMapping("/{id}")
    @Operation(summary = "Service to delete a user", tags = "User")
    public ResponseEntity<UserEntity> delete(@PathVariable Long id);


}
