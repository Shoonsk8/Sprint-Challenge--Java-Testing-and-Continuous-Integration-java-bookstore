package com.lambdaschool.starthere.services;


import com.lambdaschool.starthere.models.Book;
import com.lambdaschool.starthere.repository.BookRepository;
import com.lambdaschool.starthere.view.CountAuthorsInBooks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "bookService")
public class BookServiceImpl implements BookService
{
    @Autowired
    private BookRepository bookrepos;

    @Override
    public List<Book> findAll()
    {
        List<Book> books = new ArrayList<>();
        bookrepos.findAll().iterator().forEachRemaining(books::add);
        return books;
    }
    @Override
    public List<CountAuthorsInBooks> getCountAuthorsInBook()
    {
        return bookrepos.getCountAuthorsInBook();
    }

    @Transactional
    @Override
    public void delete(long bookid) throws EntityNotFoundException
    {
        if (bookrepos.findById(bookid).isPresent())
        {
            bookrepos.deleteBookFromWrote(bookid);
            bookrepos.deleteById(bookid);
        } else
        {
            throw new EntityNotFoundException(Long.toString(bookid));
        }
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
}
