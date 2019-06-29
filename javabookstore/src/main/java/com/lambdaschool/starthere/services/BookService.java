package com.lambdaschool.starthere.services;


import com.lambdaschool.starthere.models.Book;
import com.lambdaschool.starthere.view.CountStudentsInBooks;

import java.util.ArrayList;
import java.util.List;

public interface BookService
{
    List<Book> findAll();

    List<CountStudentsInBooks> getCountStudentsInBook();

    void delete(long bookid);

    Book findBookById(long bookid);

    Book save(Book newBook);
}
