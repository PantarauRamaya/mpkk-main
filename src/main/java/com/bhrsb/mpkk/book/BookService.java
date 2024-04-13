package com.bhrsb.mpkk.book;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//defining the business logic  
@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService() {
    }

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    public Book save(Book book) {
        bookRepository.save(book);
        return book;
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    public void update(Book book) {
        bookRepository.save(book);
    }


}
