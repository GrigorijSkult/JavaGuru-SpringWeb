package com.bookrepository.book.mappers;

import com.bookrepository.book.domain.BookEntity;
import com.bookrepository.book.dto.BookDto;
import org.springframework.stereotype.Service;

@Service
public class BookMapper {

    public BookEntity bookToEntity(BookDto bookDto) {
        return new BookEntity(
                bookDto.getId(),
                bookDto.getBook()
        );
    }

    public BookDto bookToDto(BookEntity bookEntity) {
        return new BookDto(
                bookEntity.getId(),
                bookEntity.getBookName()
        );
    }
}
