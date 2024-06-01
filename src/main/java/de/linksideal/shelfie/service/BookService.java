package de.linksideal.shelfie.service;

import de.linksideal.shelfie.domain.Book;
import de.linksideal.shelfie.dto.BookDto;
import de.linksideal.shelfie.mapper.BookMapper;
import de.linksideal.shelfie.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookDto createBook(BookDto bookDto) {
        Book book = bookMapper.toBook(bookDto);
        Book savedBook = bookRepository.save(book);
        return bookMapper.toDto(savedBook);
    }

    public List<BookDto> getBooks() {
        return bookRepository.findAll().stream().map(bookMapper::toDto).toList();
    }
}
