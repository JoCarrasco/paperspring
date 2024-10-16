package com.paperspring.app;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {
    private final BookRepo bookRepo;

    public List<Book> getAllBooks()
    {
        return bookRepo.findAll();
    }

    public Book getBookById(Integer id)
    {
        Optional<Book> optionalBook = bookRepo.findById(id);
        if (optionalBook.isPresent()) {
            return optionalBook.get();
        }
        log.info("Book with id: {} doesn't exist", id);
        return null;
    }

    public Book updateBook(Book book, Integer pageCount)
    {
        Optional<Book> existingBook = bookRepo.findById(book.getId());
        if (existingBook.isEmpty()) {
            log.info("Book with id: {} doesn't exist", book.getId());
            return null;
        }

        Book updatedBook = bookRepo.save(book);

        log.info("Book with id: {}, Updated successfully", book.getId());
        return updatedBook;
    }

    public void deleteBookById(Integer id)
    {
        bookRepo.deleteById(id);
    }

}
