package com.example.bookstore.repository;

import com.example.bookstore.model.BookDTO;
import com.example.bookstore.model.BookListDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class BookRepository {

    private List<BookDTO> bookDTOList;

    public BookRepository() {
        bookDTOList = new ArrayList<>();
    }

    public void addBook(BookDTO bookDTO) {
        this.bookDTOList.add(bookDTO);
    }

    public void addCollection(BookListDTO bookListDTO) {
        this.bookDTOList.addAll(bookListDTO.getBookDTOList());
        System.out.println("Livros adicionados com sucesso: " + this.bookDTOList.size());
    }

    public BookDTO getBookById(Integer id) {
        for (BookDTO book: bookDTOList) {
            if(Objects.equals(book.getId(), id)) {
                return book;
            }
        }
        return null;
    }

    public List<BookDTO> getBooks() {
        return bookDTOList;
    }

    public boolean updateBook(Integer id, BookDTO bookDTO) {
        for (BookDTO book: bookDTOList) {
            if(Objects.equals(book.getId(), id)) {
                book.setAuthor(bookDTO.getAuthor());
                book.setDescription(bookDTO.getDescription());
                book.setGenre(book.getGenre());
                book.setName(book.getName());
                return true;
            }
            System.out.println("Livro atualizado com sucesso: " + this.bookDTOList.get(id));
        }
        return false;
    }

    public boolean deleteBook(Integer id) {

        return this.bookDTOList.removeIf(book -> book.getId().equals(id));
        /*for (BookDTO book: bookDTOList) {
            if(Objects.equals(book.getId(), id)) {
                this.bookDTOList.remove(book);
                return true;
            }
        }
        return false;*/
    }

}
