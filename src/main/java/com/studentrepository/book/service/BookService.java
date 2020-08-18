package com.studentrepository.book.service;

import com.studentrepository.book.domain.BookEntity;
import com.studentrepository.book.dto.BookDto;
import com.studentrepository.book.mappers.BookMapper;
import com.studentrepository.book.repository.BookRepository;
import com.studentrepository.projectUtilites.exceptions.*;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BookService {

    private final BookMapper bookMapper;
    private final BookRepository bookRepository;

    public BookService(BookMapper bookMapper, BookRepository bookRepository) {
        this.bookMapper = bookMapper;
        this.bookRepository = bookRepository;
    }

    public BookDto saveBook(BookDto newBookDto) {
        BookEntity bookEntity = bookMapper.bookToEntity(newBookDto);
        bookEntity.setId(UUID.randomUUID().toString());
        return bookMapper.bookToDto(bookRepository.save(bookEntity));
    }

    public BookDto findBookById(String id) {
        return bookRepository.findById(id)
                .map(entity -> bookMapper.bookToDto(entity))
                .orElseThrow(() -> new ItemNotFound("Book with ID '" + id + "' is not found"));
    }

//    public void deleteById
}
