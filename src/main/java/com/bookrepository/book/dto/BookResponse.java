package com.bookrepository.book.dto;

import java.util.Objects;

public class BookResponse {

    private String id;
    private String book;
    private String bookDescription;

    public BookResponse() {
    }

    public BookResponse(String id, String book, String bookDescription) {
        this.id = id;
        this.book = book;
        this.bookDescription = bookDescription;
    }

    public BookResponse(String id, String book) {
        this.id = id;
        this.book = book;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookResponse that = (BookResponse) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(book, that.book) &&
                Objects.equals(bookDescription, that.bookDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, book, bookDescription);
    }

    @Override
    public String toString() {
        return "BookResponse{" +
                "id='" + id + '\'' +
                ", book='" + book + '\'' +
                ", bookDescription='" + bookDescription + '\'' +
                '}';
    }
}
