package com.bookrepository.core;

import com.bookrepository.core.exceptions.BookError;
import com.bookrepository.core.exceptions.ItemNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler
    public ResponseEntity<BookError> coreHandler(Exception exception) {
        if (exception instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException ex = (MethodArgumentNotValidException) exception;
            String message = ex.getBindingResult().getFieldErrors().stream()
                    .map(error -> error.getField() + ": " + error.getDefaultMessage())
                    .collect(Collectors.joining("; "));
            return ResponseEntity.badRequest()
                    .body(new BookError(message));
        }

        if (exception instanceof ItemNotFoundException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new BookError(exception.getMessage()));
        }

        if (exception instanceof IllegalAccessException) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
                    .body(new BookError(exception.getMessage()));
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new BookError(exception.getMessage()));

    }
}
