package com.lambdaschool.starthere.controllers;


import com.lambdaschool.starthere.models.Book;
import com.lambdaschool.starthere.services.BookService;
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
@RequestMapping(value = "/books")
public class BookController
{

    private static final Logger logger = LoggerFactory.getLogger(RolesController.class);
    @Autowired
    private BookService bookService;

    @GetMapping(value = "/books", produces = {"application/json"})
    public ResponseEntity<?> listAllBooks(HttpServletRequest request)
    {
        logger.trace(request.getRequestURI() + " accessed");
        List<Book> myBooks = bookService.findAll();
        return new ResponseEntity<>(myBooks, HttpStatus.OK);
    }

    @GetMapping(value = "/studcount", produces = {"application/json"})
    public ResponseEntity<?> getCountAuthorsInBooks(HttpServletRequest request)
    {
        logger.trace(request.getRequestURI() + " accessed");
        return new ResponseEntity<>(bookService.getCountAuthorsInBook(), HttpStatus.OK);
    }

    @DeleteMapping("/books/{bookid}")
    public ResponseEntity<?> deleteBookById(HttpServletRequest request,@PathVariable long bookid)
    {
        logger.trace(request.getRequestURI() + " accessed");
        bookService.delete(bookid);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping(value = "/add")
    public ResponseEntity<?> addNewBook(HttpServletRequest request, @Valid
    @RequestBody
            Book newBook) throws URISyntaxException
    {
        logger.trace(request.getRequestURI() + " accessed");

        newBook = bookService.save(newBook);

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newBookURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{quoteid}").buildAndExpand(newBook.getBookid()).toUri();
        responseHeaders.setLocation(newBookURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

}
