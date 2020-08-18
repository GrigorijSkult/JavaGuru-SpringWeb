package com.bookrepository.book.service;

import com.bookrepository.book.domain.BookEntity;
import com.bookrepository.book.dto.BookDto;
import com.bookrepository.book.mappers.BookMapper;
import com.bookrepository.book.repository.BookRepository;
import com.bookrepository.repositoryutilities.exceptions.ItemNotFound;
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

    public void deleteBookById(String id) {
        if (!bookRepository.existsById(id)) {
            throw new ItemNotFound("Book with ID '" + id + "' is not found");
        }
        bookRepository.deleteById(id);
    }
}
