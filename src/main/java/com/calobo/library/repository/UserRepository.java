package com.calobo.library.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.calobo.library.repository.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    
}
