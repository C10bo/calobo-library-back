package com.calobo.library.service;

import java.util.List;

import com.calobo.library.models.request.UserRequest;
import com.calobo.library.repository.entity.UserEntity;

public interface UserService {

    public List<UserEntity> getAll();
    public UserEntity getUserById(Long id);
    public UserEntity create(UserRequest request);
    public UserEntity update(Long id, UserRequest request);
    public UserEntity delete(Long id);
    
}
