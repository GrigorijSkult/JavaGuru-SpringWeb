package com.studentrepository.projectUtilites.exceptions;

public class ItemNotFound extends RuntimeException {
    public ItemNotFound(String message) {
        super(message);
    }
}