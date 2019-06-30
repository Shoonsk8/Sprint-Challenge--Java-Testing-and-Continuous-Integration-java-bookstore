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
import org.springframework.data.web.PageableDefault;
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
class AuthorController {
    public AuthorController() {
    }

    private static final Logger logger = LoggerFactory.getLogger(RolesController.class);
    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @ApiOperation(value = "Return all Authors", response = Author.class, responseContainer = "List")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integr", paramType = "query",
                    value = "Results page you want to retrieve (0..N)"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
                    value = "Number of records per page."),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                    value = "Sorting criteria in the format: property(,asc|desc). " +
                            "Default sort order is ascending. " +
                            "Multiple sort criteria are supported.")})

    //GET /authors - returns a JSON object list of all the authors and their books.
    @GetMapping(value = "/authors")
    public ResponseEntity<?> findAllAuthors(HttpServletRequest request,
                                            @PageableDefault(page = 0,
                                                    size = 2)
                                                    Pageable pageable){
        logger.info(request.getRequestURI() + " accessed");
        List<Author> authorList = authorService.findAll(pageable);
        return new ResponseEntity<>(authorList, HttpStatus.OK);
    }






}
