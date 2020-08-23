package com.bookrepository.book;

import com.bookrepository.book.dto.BookCreateRequest;
import com.bookrepository.book.dto.BookResponse;
import com.bookrepository.book.dto.BookUpdateRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookResponse> findAllBooks() {
        return bookService.findAllBooks();
    }

    @GetMapping("/{id}")
    public BookResponse findBookById(@PathVariable String id) {
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
    public ResponseEntity<BookResponse> createBook(@Valid @RequestBody BookCreateRequest newBookResponse, UriComponentsBuilder builder){
        System.out.println("Received request, add new book " + newBookResponse);
        BookResponse response = bookService.saveBook(newBookResponse);
        return ResponseEntity.created(
                builder.path("/books/{id}")
                        .buildAndExpand(response.getId()).toUri()).build();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public ResponseEntity<BookResponse> updateStudent(@PathVariable String id, @Valid @RequestBody BookUpdateRequest updatedBookResponse, UriComponentsBuilder builder) {
        System.out.println("Received request, update for book with ID " + id);
        BookResponse response = bookService.updateBookById(id, updatedBookResponse);
        return ResponseEntity.created(
                builder.path("/books/{id}")
                        .buildAndExpand(response.getId()).toUri()).build();
    }
}
