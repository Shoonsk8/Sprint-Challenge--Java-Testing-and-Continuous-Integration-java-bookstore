package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.models.Author;
import com.lambdaschool.starthere.models.Book;
import com.lambdaschool.starthere.view.CountAuthorsInBooks;

import java.util.List;

public interface  AuthorService {

    List<Author> findAll();


    void delete(long authorid);

    Author findAuthorById(long authorid);

    void save(Author newAuthor);
}
