package com.lambdaschool.starthere.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

    private String title;
    private String ISBN;
    private int copy;


    @ManyToOne
    @JoinColumn(name = "sectionid")
    @JsonIgnoreProperties("books")
//    @JsonView(View.BooksOnly.class)
    private Section section;

    @ManyToMany(mappedBy = "books")
    @JsonIgnoreProperties("books")
    private List<Student> students = new ArrayList<>();


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

    public Book(long bookid, String title, String ISBN, int copy, Section section) {
        this.bookid=bookid;
        this.title = title;
        this.ISBN = ISBN;
        this.copy = copy;
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

    public int getCopy() {
        return copy;
    }

    public void setCopy(int copy) {
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


    public List<Student> getStudents()
    {
        return students;
    }

    public void setStudents(List<Student> students)
    {
        this.students = students;
    }
}
