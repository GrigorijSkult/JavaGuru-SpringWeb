package com.bookrepository.book.service;

import com.bookrepository.book.domain.BookEntity;
import com.bookrepository.book.dto.BookResponse;
import com.bookrepository.book.mappers.BookMapper;
import com.bookrepository.book.repository.BookRepository;
import com.bookrepository.core.exceptions.ItemNotFound;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class BookService {

    private final BookMapper bookMapper;
    private final BookRepository bookRepository;

    public BookService(BookMapper bookMapper, BookRepository bookRepository) {
        this.bookMapper = bookMapper;
        this.bookRepository = bookRepository;
    }

    public BookResponse saveBook(BookResponse newBookResponse) {
        BookEntity bookEntity = bookMapper.bookToEntity(newBookResponse);
        bookEntity.setId(UUID.randomUUID().toString());
        return bookMapper.bookToDto(bookRepository.save(bookEntity));
    }

    public BookResponse findBookById(String id) throws ItemNotFound {
        return bookRepository.findById(id)
                .map(entity -> bookMapper.bookToDto(entity))
                .orElseThrow(() -> new ItemNotFound("Book with ID '" + id + "' is not found"));
    }

    public List<BookResponse> findAllBooks() {
        List<BookResponse> bookResponseList = new ArrayList<>(Collections.emptyList());
        List<BookEntity> bookEntityList = bookRepository.findAll();
        for (BookEntity bookEntity : bookEntityList) {
            bookResponseList.add(bookMapper.bookToDto(bookEntity));
        }
        return bookResponseList;
    }

    public void deleteBookById(String id) throws ItemNotFound {
        if (!bookRepository.existsById(id)) {
            throw new ItemNotFound("Book with ID '" + id + "' is not found");
        }
        bookRepository.deleteById(id);
    }

    public BookResponse updateBookById(String id, BookResponse updatedBookResponse) throws ItemNotFound {
        bookRepository.findById(id)
                .orElseThrow(() -> new ItemNotFound("Book with ID '" + id + "' is not found"));
        updatedBookResponse.setId(id);
        return bookMapper.bookToDto(bookRepository.save(bookMapper.bookToEntity(updatedBookResponse)));
    }
}
