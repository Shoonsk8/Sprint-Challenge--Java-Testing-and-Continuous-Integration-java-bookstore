package com.lambdaschool.starthere.repository;


import com.lambdaschool.starthere.models.Book;
import com.lambdaschool.starthere.view.CountStudentsInBooks;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long>
{
 //   List<Book> findBooksByBooknameEquals(String name);

    @Modifying
    @Query(value = "DELETE FROM studbooks WHERE bookid = :bookid", nativeQuery = true)
    void deleteBookFromStudbooks(long bookid);

    @Query(value = "SELECT s.bookid, bookname, count(studid) as countstudents FROM studbooks s INNER JOIN book c on s.bookid=c.bookid GROUP BY s.bookid, bookname", nativeQuery = true)
    List<CountStudentsInBooks> getCountStudentsInBook();

    Book getBookByBookid(long bookid);

}

