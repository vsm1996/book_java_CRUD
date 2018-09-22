package com.vanessamartin.web.booksDemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vanessamartin.web.booksDemo.models.Book;
import com.vanessamartin.web.booksDemo.repositories.BookRepository;
@Service
public class BookService {
    // adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }

    public Book updateBook(Book updatedBook ) {
    	 Optional<Book> optionalBook = bookRepository.findById(updatedBook.getId());
    	 
         if(optionalBook.isPresent()) {
        	 Book book = optionalBook.get();
        	 book.setTitle(updatedBook.getTitle());
        	 book.setDescription(updatedBook.getDescription());
        	 book.setLanguage(updatedBook.getLanguage());
        	 book.setNumberOfPages(updatedBook.getNumberOfPages());
             return bookRepository.save(book);
         } else {
             return null;
         }
    }
    
    public void deleteBook(Long id) {
    	bookRepository.deleteById(id);
    }

 
}