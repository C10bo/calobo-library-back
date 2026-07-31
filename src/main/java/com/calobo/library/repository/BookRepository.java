package com.calobo.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.calobo.library.repository.entity.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

    List<BookEntity> findByIsbn(String isbn);
    
}
