package com.example.bookstore.services;

import com.example.bookstore.model.BookDTO;
import com.example.bookstore.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;

    public void addBook(BookDTO bookDTO) {
        bookRepository.addBook(bookDTO);
    }

    public BookDTO getBookById(Integer id) {
      return bookRepository.getBookById(id);
    }

    public List<BookDTO> getBooks() {
        return bookRepository.getBooks();
    }

    public boolean updateBook(Integer id, BookDTO bookDTO) {
        return bookRepository.updateBook(id, bookDTO);
    }

    public boolean deleteBook(Integer id) {
        return bookRepository.deleteBook(id);
    }

}
