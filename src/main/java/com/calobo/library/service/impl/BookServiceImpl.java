package com.calobo.library.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.calobo.library.models.request.BookRequest;
import com.calobo.library.repository.BookRepository;
import com.calobo.library.repository.entity.BookEntity;
import com.calobo.library.service.BookService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    @Override
    public List<BookEntity> getBooks() {
        return repository.findAll();
    }

    @Override
    public BookEntity getBooks(Long id) {
        BookEntity book = repository.findById(id).orElseThrow(() -> new RuntimeException("Libro no encontrado"));
        return book;
    }

    @Override
    public BookEntity createBook(BookRequest request) {
        BookEntity book = BookEntity.builder()
                .title(request.getTitle())
                .isbn(request.getIsbn())
                .edition(request.getEdition())
                .publicationDate(request.getPublicationDate())
                .author(request.getAuthor())
                .build();

        repository.save(book);

        return book;
    }

    @Override
    public BookEntity updateBook(Long id, BookRequest request) {
        BookEntity book = repository.findById(id).orElseThrow(() -> new RuntimeException("Libro no encontrado"));

        BookEntity updatedBook = BookEntity.builder()
                .id(book.getId())
                .title(request.getTitle())
                .isbn(request.getIsbn())
                .edition(request.getEdition())
                .publicationDate(request.getPublicationDate())
                .author(request.getAuthor())
                .build();

        repository.save(updatedBook);
        return updatedBook;
    }

    @Override
    public BookEntity deleteBook(Long id) {
        BookEntity book = repository.findById(id).orElseThrow(() -> new RuntimeException("Libro no encontrado"));

        repository.delete(book);
        return book;
    }

}
