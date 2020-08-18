package com.studentrepository.book.dto;

import java.util.Objects;

public class BookDto {

    private String id;
    private String book;

    public BookDto() {
    }

    public BookDto(String id, String book) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookDto bookDto = (BookDto) o;
        return Objects.equals(id, bookDto.id) &&
                Objects.equals(book, bookDto.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, book);
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "id='" + id + '\'' +
                ", book='" + book + '\'' +
                '}';
    }
}
