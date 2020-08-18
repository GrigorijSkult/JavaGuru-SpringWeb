package com.studentrepository.book.mappers;

import com.studentrepository.book.domain.BookEntity;
import com.studentrepository.book.dto.BookDto;
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
