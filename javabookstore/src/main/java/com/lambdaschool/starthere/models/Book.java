package com.lambdaschool.starthere.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
public class Book extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @JsonView(View.BooksOnly.class)
    private long bookid;

//    @JsonView(View.BooksOnly.class)

    @Column( nullable = false)
    private String title;


    @Column( nullable = true)
    private String ISBN;




    @Column( nullable = true)
    private String  copy;




    @ManyToOne
    @JoinColumn(name = "sectionid")
    @JsonIgnoreProperties("books")
//    @JsonView(View.BooksOnly.class)
    private Section section;

    @ManyToMany(mappedBy = "books")
    @JsonIgnoreProperties("books")
    private List<Author> authors = new ArrayList<>();


    public Book() { }

    public Book(String title)
    {
        this.title = title;
    }

    public Book(String title, Section section)
    {
        this.title = title;
        this.section = section;
    }

    public Book(long bookid, String title, String ISBN,String  copy, Section section) {
        this.bookid=bookid;
        this.title = title;
        this.ISBN = ISBN;

        this.copy=copy;


        this.section = section;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String  getCopy() {
        return copy;
    }

    public void setCopy(String  copy) {
        this.copy = copy;
    }


    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public long getBookid()
    {
        return bookid;
    }

    public void setBookid(long bookid)
    {
        this.bookid = bookid;
    }


    public List<Author> getAuthors()
    {
        return authors;
    }

    public void setAuthors(List<Author> authors)
    {
        this.authors = authors;
    }
}
