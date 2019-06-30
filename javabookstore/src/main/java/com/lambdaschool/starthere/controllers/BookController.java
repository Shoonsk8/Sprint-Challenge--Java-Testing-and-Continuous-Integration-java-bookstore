package com.lambdaschool.starthere.controllers;


import com.lambdaschool.starthere.models.Author;
import com.lambdaschool.starthere.models.Book;
import com.lambdaschool.starthere.services.AuthorService;
import com.lambdaschool.starthere.services.BookService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Pageable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class BookController
{
    public BookController() {
    }

    private static final Logger logger = LoggerFactory.getLogger(RolesController.class);
    @Autowired
    private BookService bookService;


    @ApiOperation(value = "Return all Books", response = Book.class, responseContainer = "List")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integr", paramType = "query",
                    value = "Results page you want to retrieve (0..N)"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
                    value = "Number of records per page."),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                    value = "Sorting criteria in the format: property(,asc|desc). " +
                            "Default sort order is ascending. " +
                            "Multiple sort criteria are supported.")})



    //GET /books - returns a JSON object list of all the books and their authors.
    @GetMapping(value = "/books", produces = {"application/json"})
    public ResponseEntity<?> listAllBooks(HttpServletRequest request, Pageable pageable)
    {
        logger.info(request.getRequestURI() + " accessed");
        List<Book> myBooks = bookService.findAll(pageable);
        return new ResponseEntity<>(myBooks, HttpStatus.OK);
    }





    @DeleteMapping("/books/{bookid}")
    public ResponseEntity<?> deleteBookById(HttpServletRequest request,@PathVariable long bookid)
    {
        logger.info(request.getRequestURI() + " accessed");
        bookService.delete(bookid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //PUT /data/books/{id} - updates a books info (Title, Copyright, ISBN) but does NOT have to assign authors to the books.

    @PutMapping(value = "/data/books/{bookid}", produces = {"application/json"})
    public ResponseEntity<?> updateUser(HttpServletRequest request,
                                        @RequestBody
                                                Book updateBook,
                                        @PathVariable
                                                long bookid)
    {
        logger.info(request.getRequestURI() + " accessed");

        bookService.update(updateBook, bookid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //POST /data/books/authors{id} - assigns a book already in the system to an author already in the system (see how roles are handled for users)
    @PostMapping(value = "/data/books/{id}")
    public ResponseEntity<?> matchBookWithAuthor(@PathVariable long bookid, @RequestBody Author author){
        bookService.assignAuthor(bookid, author.getAuthorid());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> addNewBook(HttpServletRequest request, @Valid
    @RequestBody
            Book newBook) throws URISyntaxException
    {
        logger.info(request.getRequestURI() + " accessed");

        newBook = bookService.save(newBook);

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newBookURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{quoteid}").buildAndExpand(newBook.getBookid()).toUri();
        responseHeaders.setLocation(newBookURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

}
