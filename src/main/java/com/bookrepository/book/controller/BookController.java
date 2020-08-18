package com.bookrepository.book.controller;

import com.bookrepository.book.dto.BookDto;
import com.bookrepository.book.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public BookDto findAllBooks() {
        return new BookDto(UUID.randomUUID().toString(), "Test_Azazel");
    }

    @GetMapping("/{id}")
    public BookDto findBookById(@PathVariable String id) {
        System.out.println("Received request, find book with ID " + id);
        return bookService.findBookById(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable String id) {
        System.out.println("Received request, delete book with ID " + id);
        bookService.deleteBookById(id);
    }

    @PostMapping
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto newBookDto, UriComponentsBuilder builder) {
        System.out.println("Received request, add new book " + newBookDto);
        BookDto response = bookService.saveBook(newBookDto);
        return ResponseEntity.created(
                builder.path("/books/{id}")
                        .buildAndExpand(response.getId()).toUri()).build();
    }

    @PutMapping("/{id}")//+ привязка к сервису
    public void updateStudent(@PathVariable String id, @RequestBody BookDto updatedBookDto) {
        System.out.println("Received request, update for book with ID " + id);
        System.out.println("Received request, book updated" + updatedBookDto);
    }

}
