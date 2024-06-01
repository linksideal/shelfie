package de.linksideal.shelfie.mapper;

import de.linksideal.shelfie.domain.Book;
import de.linksideal.shelfie.dto.BookDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {

    Book toBook(BookDto bookDto);
    BookDto toDto(Book book);
}
