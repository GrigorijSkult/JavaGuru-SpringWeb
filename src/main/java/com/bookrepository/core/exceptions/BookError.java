package com.bookrepository.core.exceptions;

public class BookError {

    private String message;

    public BookError() {
    }

    public BookError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
