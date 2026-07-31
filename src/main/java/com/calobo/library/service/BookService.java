package com.calobo.library.service;

import java.util.List;

import com.calobo.library.models.request.BookRequest;
import com.calobo.library.repository.entity.BookEntity;

public interface BookService {

    List<BookEntity> getBooks();
    BookEntity getBooks(Long id);
    BookEntity createBook(BookRequest request);
    BookEntity updateBook(Long id, BookRequest request);
    BookEntity deleteBook(Long id);
    
} 
