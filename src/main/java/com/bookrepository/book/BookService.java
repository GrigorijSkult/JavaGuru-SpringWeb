package com.bookrepository.book;

import com.bookrepository.book.domain.BookEntity;
import com.bookrepository.book.dto.BookCreateRequest;
import com.bookrepository.book.dto.BookResponse;
import com.bookrepository.book.dto.BookUpdateRequest;
import com.bookrepository.book.mappers.BookMapper;
import com.bookrepository.core.apirequests.QuoteService;
import com.bookrepository.core.exceptions.ItemNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class BookService {

    private final BookMapper bookMapper;
    private final BookRepository bookRepository;
    private final QuoteService quoteService;

    public BookService(BookMapper bookMapper, BookRepository bookRepository, QuoteService quoteService) {
        this.bookMapper = bookMapper;
        this.bookRepository = bookRepository;
        this.quoteService = quoteService;
    }

    public BookResponse saveBook(BookCreateRequest newBook) throws IllegalAccessException {
        BookEntity bookEntity = new BookEntity(
                UUID.randomUUID().toString(),
                newBook.getBookName(),
                quoteService.getUrlApiRandomRequest().getDescription());
        return bookMapper.bookToResponse(bookRepository.save(bookEntity));
    }

    public BookResponse findBookById(String id) throws ItemNotFoundException {
        return bookRepository.findById(id)
                .map(entity -> bookMapper.bookToResponse(entity))
                .orElseThrow(() -> new ItemNotFoundException("Book with ID '" + id + "' is not found"));
    }

    public List<BookResponse> findAllBooks() {
        List<BookResponse> bookResponseList = new ArrayList<>(Collections.emptyList());
        List<BookEntity> bookEntityList = bookRepository.findAll();
        for (BookEntity bookEntity : bookEntityList) {
            bookResponseList.add(bookMapper.bookToResponse(bookEntity));
        }
        return bookResponseList;
    }

    public void deleteBookById(String id) throws ItemNotFoundException {
        if (!bookRepository.existsById(id)) {
            throw new ItemNotFoundException("Book with ID '" + id + "' is not found");
        }
        bookRepository.deleteById(id);
    }

    public BookResponse updateBookById(String id, BookUpdateRequest updatedBook) throws ItemNotFoundException {
        bookRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Book with ID '" + id + "' is not found"));
        BookEntity bookEntity = new BookEntity(
                id,
                updatedBook.getBookName(),
                updatedBook.getBookDescription());
        return bookMapper.bookToResponse(bookRepository.save(bookEntity));
    }
}
