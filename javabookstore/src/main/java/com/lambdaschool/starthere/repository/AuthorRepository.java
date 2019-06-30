package com.lambdaschool.starthere.repository;


import com.lambdaschool.starthere.models.Author;
import com.lambdaschool.starthere.models.Book;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface  AuthorRepository  extends PagingAndSortingRepository<Author, Long> {




}