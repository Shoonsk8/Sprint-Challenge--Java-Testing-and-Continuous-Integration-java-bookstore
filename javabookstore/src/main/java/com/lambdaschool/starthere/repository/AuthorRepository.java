package com.lambdaschool.starthere.repository;

import com.lambdaschool.starthere.models.Author;
import com.lambdaschool.starthere.models.Book;
import com.lambdaschool.starthere.view.CountAuthorsInBooks;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface  AuthorRepository extends CrudRepository<Author, Long> {
        //   List<Book> findBooksByBooknameEquals(String name);

        @Modifying
        @Query(value = "DELETE FROM wrote WHERE authorid = :authorid", nativeQuery = true)
        void deleteAuthorFromWrote(long authorid);

        @Query(value = "SELECT s.authorid, fname, lname, count(authorid) as countAuthors FROM wrote s INNER JOIN author c on s.authorid=c.authorid GROUP BY s.authorid, fname, lname", nativeQuery = true)
        List<CountAuthorsInBooks> getCountAuthorsInBook();

        List<Book> getBooksByAuthorid(long authorid);

}