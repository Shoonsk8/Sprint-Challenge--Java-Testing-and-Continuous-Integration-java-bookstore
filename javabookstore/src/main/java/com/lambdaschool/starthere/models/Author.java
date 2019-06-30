package com.lambdaschool.starthere.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
public class Author extends Auditable
{
    @ApiModelProperty(name = "authorid", value = "Primary key for Author", required = true, example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long authorid;

    @ApiModelProperty(name = "fname", value = "First Name", required = true, example = "John")
    @Column(nullable = false, unique = true)
    private String fname;

    @ApiModelProperty(name = "lname", value = "Last Name", required = true, example = "Doe")
    @Column(nullable = false, unique = true)
    private String lname;


    @ApiModelProperty(name = "books", value = "List of Books", required = true, example = "Some Name")
    @ManyToMany
    @JoinTable(name = "wrote",
               joinColumns = {@JoinColumn(name = "authorid")},
               inverseJoinColumns = {@JoinColumn(name = "bookid")})
    @JsonIgnoreProperties("authors")
    private List<Book> books = new ArrayList<>();

    public Author()
    {
    }


    public Author(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }


    public long getAuthorid() {
        return authorid;
    }

    public void setAuthorid(long authorid) {
        this.authorid = authorid;
    }


    public List<Book> getBooks()
    {
        return books;
    }

    public void setBooks(List<Book> books)
    {
        this.books = books;
    }
}
