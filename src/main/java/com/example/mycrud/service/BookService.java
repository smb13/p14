package com.example.mycrud.service;

import com.example.mycrud.model.Book;
import com.example.mycrud.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void save(Book book) {
        bookRepository.save(book);
    }

    
    public List<Book> readAll() {
        return bookRepository.findAll();
    }

    public boolean update(Book book, Integer id) {
        if (bookRepository.existsById(id)) {
            book.setId(id);
            bookRepository.save(book);
            return true;
        }
        return false;
    }
    
    public Optional<Book> read(Integer id) {
        return bookRepository.findById(id);
    }

    
    public boolean delete(Integer id) {
        bookRepository.deleteById(id);
        return !bookRepository.existsById(id);
    }
}
