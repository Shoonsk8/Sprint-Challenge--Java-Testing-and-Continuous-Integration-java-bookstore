package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.models.Author;
import com.lambdaschool.starthere.repository.AuthorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "authorService")
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorrepos;

    @Override
    public List<Author> findAll()
    {
        List<Author> authors = new ArrayList<>();
        authorrepos.findAll().iterator().forEachRemaining(authors::add);
      //  authorrepos.findAll().iterator().forEachRemaining(authors::add);
        return authors;
    }

    @Transactional
    @Override
    public void delete(long authorid) throws EntityNotFoundException
    {
        if (authorrepos.findById(authorid).isPresent())
        {
            authorrepos.deleteAuthorFromWrote(authorid);
            authorrepos.deleteById(authorid);
        } else {
            throw new EntityNotFoundException(Long.toString(authorid));
        }
    }

    @Override
    public Author findAuthorById(long authorid) {
        return null;
    }

    @Override
    public Author save(Author newAuthor) {
        return null;
    }

}
