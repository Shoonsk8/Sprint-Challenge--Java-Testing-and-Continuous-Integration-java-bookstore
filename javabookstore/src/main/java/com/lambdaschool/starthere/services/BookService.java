package com.lambdaschool.starthere.services;


import com.lambdaschool.starthere.models.Book;
import com.lambdaschool.starthere.view.CountAuthorsInBooks;

import java.util.ArrayList;
import java.util.List;

public interface BookService
{
    List<Book> findAll();

    List<CountAuthorsInBooks> getCountAuthorsInBook();

    void delete(long bookid);

    Book findBookById(long bookid);

    Book save(Book newBook);

    void update(Book updateBook, long id);
}
