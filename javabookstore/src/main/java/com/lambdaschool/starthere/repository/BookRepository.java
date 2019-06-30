package com.lambdaschool.starthere.repository;


import com.lambdaschool.starthere.models.Book;
import com.lambdaschool.starthere.view.CountAuthorsInBooks;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;


import java.util.List;

public interface BookRepository  extends  PagingAndSortingRepository<Book, Long>{
 //   List<Book> findBooksByBooknameEquals(String name);



    Book getBookByBookid(long bookid);


//    @Modifying
//    @Query(value = "UPDATE book SET  title = :title WHERE bookid = :bookid", nativeQuery = true)
//    void update(String title,  long bookid);

}

