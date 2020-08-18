package com.studentrepository.book.controller;

import com.studentrepository.book.dto.BookDto;
import com.studentrepository.book.service.BookService;
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
        return new BookDto(UUID.randomUUID().toString(), "Test_Azazel"
        );
    }

    @GetMapping("/{id}")
    public BookDto findBookById(@PathVariable String id) {
        System.out.println("Received request of book with id " + id);
        return bookService.findBookById(id);
    }

    @PostMapping
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto newBookDto, UriComponentsBuilder builder) {
        System.out.println("Received request, add new book " + newBookDto);
        BookDto response = bookService.saveBook(newBookDto);
        return ResponseEntity.created(
                builder.path("/books/{id}")
                        .buildAndExpand(response.getId()).toUri()).build();
    }

    @PutMapping("/{id}")
    public void updateStudent(@PathVariable String id, @RequestBody BookDto updatedBookDto) {
        System.out.println("Received request, update for book with ID " + id);
        System.out.println("Received request, book updated" + updatedBookDto);
    }

}
