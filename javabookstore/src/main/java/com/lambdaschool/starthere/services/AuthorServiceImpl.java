package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.models.Author;
import com.lambdaschool.starthere.repository.AuthorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "authorService")
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorrepos;

    @Override
    public List<Author> findAll(Pageable pageable)
    {
        List<Author> authors = new ArrayList<>();
        authorrepos.findAll(pageable).iterator().forEachRemaining(authors::add);
        return authors;
    }

    @Transactional
    @Override
    public void delete(long authorid) throws EntityNotFoundException
    {

    }

    @Override
    public Author findAuthorById(long authorid) {
        return null;
    }

    @Override
    public void save(Author newAuthor) {
        authorrepos.save(newAuthor);
        return;
    }

}
