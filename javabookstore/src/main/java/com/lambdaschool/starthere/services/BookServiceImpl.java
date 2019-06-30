package com.lambdaschool.starthere.services;


import com.lambdaschool.starthere.models.Book;

import com.lambdaschool.starthere.repository.AuthorRepository;
import com.lambdaschool.starthere.repository.BookRepository;
import com.lambdaschool.starthere.view.CountAuthorsInBooks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;
import javax.persistence.EntityNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service(value = "bookService")
public class BookServiceImpl implements BookService
{
    @Autowired
    private BookRepository bookrepos;
    @Autowired
    private AuthorRepository authorrepos;

    @Override
    public List<Book> findAll(Pageable pageable)
    {
        List<Book> books = new ArrayList<>();
        bookrepos.findAll(pageable).iterator().forEachRemaining(books::add);
        return books;
    }

    @Override
    public void delete(long bookid) {

    }


    @Override
    public Book findBookById(long bookid) {
        return bookrepos.getBookByBookid(bookid);
    }

    @Override
    public Book save(Book newBook) {
        return bookrepos.save(newBook);
    }

    @Override
    public void update(Book updateBook, long id) {
        bookrepos.getBookByBookid(id).setTitle(updateBook.getTitle());
        if(updateBook.getAuthors()!=null)bookrepos.getBookByBookid(id).setAuthors(updateBook.getAuthors());
        if(updateBook.getCopy()!=null)bookrepos.getBookByBookid(id).setCopy(updateBook.getCopy());
        if(updateBook.getISBN()!=null)bookrepos.getBookByBookid(id).setISBN(updateBook.getISBN());
        if(updateBook.getSection()!=null)bookrepos.getBookByBookid(id).setSection(updateBook.getSection());

        bookrepos.save(bookrepos.getBookByBookid(id));
    }

    @Override
    public void assignAuthor(long bookid, long authorid) {
        Book currentBook = bookrepos.findById(bookid).orElseThrow(EntityNotFoundException::new);
        currentBook.getAuthors().add(authorrepos.findById(authorid).orElseThrow(EntityNotFoundException::new));
    }
}
