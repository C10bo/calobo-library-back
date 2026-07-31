package com.calobo.library.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.calobo.library.controller.api.BookApi;
import com.calobo.library.models.request.BookRequest;
import com.calobo.library.repository.entity.BookEntity;
import com.calobo.library.service.BookService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BookController implements BookApi {

    private final BookService bookService;
    
    @Override
    public ResponseEntity<List<BookEntity>> getBooks() {
        return ResponseEntity.ok(bookService.getBooks());
    }

    @Override
    public ResponseEntity<BookEntity> getBookByUser(Long id) {
        return ResponseEntity.ok(bookService.getBooks(id));
    }

    @Override
    public ResponseEntity<BookEntity> createBook(BookRequest request) {
        return ResponseEntity.ok(bookService.createBook(request));
    }

    @Override
    public ResponseEntity<BookEntity> updateBook(Long id, BookRequest request) {
        return ResponseEntity.ok(bookService.updateBook(id, request));
    }

    @Override
    public ResponseEntity<BookEntity> deleteBook(Long id) {
        return ResponseEntity.ok(bookService.deleteBook(id));
    }
}
