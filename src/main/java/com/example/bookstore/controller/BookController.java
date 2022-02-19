package com.example.bookstore.controller;

import com.example.bookstore.model.BookDTO;
import com.example.bookstore.model.BookListDTO;
import com.example.bookstore.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/bookstore")
public class BookController {

    private final BookService bookService;

    @GetMapping("/{id}")
    private ResponseEntity<BookDTO> getBookById(@PathVariable("id") Integer id) {
        BookDTO response = bookService.getBookById(id);

        if (response == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @PostMapping
    private ResponseEntity<String> addBook(@RequestBody BookDTO bookDTO) {
        bookService.addBook(bookDTO);
        return new ResponseEntity<>("Livro adicionado com sucesso", HttpStatus.OK);
    }


    @PostMapping("/all")
    public ResponseEntity<String> addCollections(@RequestBody BookListDTO bookDTOList) {
        //implementar o método addCollection para adicionar uma lista de livros
        return new ResponseEntity<>("Livros adicionados com sucesso", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBook(@PathVariable("id") Integer id, @RequestBody BookDTO bookDTO) {
        boolean responseService = bookService.updateBook(id, bookDTO);

        if (!responseService) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Livro atualizado com sucesso", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") Integer id) {
        boolean responseService = bookService.deleteBook(id);

        if (!responseService) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Livro deletado com sucesso", HttpStatus.OK);
    }

}
