package com.lambdaschool.starthere.repository;


import com.lambdaschool.starthere.models.Book;
import com.lambdaschool.starthere.view.CountAuthorsInBooks;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long>
{
 //   List<Book> findBooksByBooknameEquals(String name);

    @Modifying
    @Query(value = "DELETE FROM wrote WHERE bookid = :bookid", nativeQuery = true)
    void deleteBookFromWrote(long bookid);

    @Query(value = "SELECT s.bookid, title, count(authorid) as countAuthors FROM wrote s INNER JOIN book c on s.bookid=c.bookid GROUP BY s.bookid, title", nativeQuery = true)
    List<CountAuthorsInBooks> getCountAuthorsInBook();

    Book getBookByBookid(long bookid);


//    @Modifying
//    @Query(value = "UPDATE book SET  title = :title WHERE bookid = :bookid", nativeQuery = true)
//    void update(String title,  long bookid);

}

