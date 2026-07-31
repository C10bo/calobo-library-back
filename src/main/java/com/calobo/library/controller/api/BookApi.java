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

import com.calobo.library.models.request.BookRequest;
import com.calobo.library.repository.entity.BookEntity;

import io.swagger.v3.oas.annotations.Operation;

@RequestMapping(path = "/book")
public interface BookApi {

    @GetMapping
    @Operation(summary = "Service to get all books", tags = "Book")
    public ResponseEntity<List<BookEntity>> getBooks();

    @GetMapping("/{id}")
    @Operation(summary = "Service to get book by id", tags = "Book")
    public ResponseEntity<BookEntity> getBookByUser(@PathVariable Long id);


    @PostMapping
    @Operation(summary = "Service to create book", tags = "Book")
    public ResponseEntity<BookEntity> createBook(@RequestBody BookRequest request);

    @PutMapping("/{id}")
    @Operation(summary = "Service to update book", tags = "Book")
    public ResponseEntity<BookEntity> updateBook(@PathVariable Long id, @RequestBody BookRequest request);

    @DeleteMapping("/{id}")
    @Operation(summary = "Service to delete book", tags = "Book")
    public ResponseEntity<BookEntity> deleteBook(@PathVariable Long id);
    
}
