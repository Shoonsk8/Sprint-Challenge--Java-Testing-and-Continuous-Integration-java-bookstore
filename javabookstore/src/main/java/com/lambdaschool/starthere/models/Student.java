package com.lambdaschool.starthere.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
public class Student extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long studid;

    private String studname;

    @ManyToMany
    @JoinTable(name = "studbooks",
               joinColumns = {@JoinColumn(name = "studid")},
               inverseJoinColumns = {@JoinColumn(name = "bookid")})
    @JsonIgnoreProperties("students")
    private List<Book> books = new ArrayList<>();

    public Student()
    {
    }

    public Student(String studname)
    {
        this.studname = studname;
    }

    public long getStudid()
    {
        return studid;
    }

    public void setStudid(long studid)
    {
        this.studid = studid;
    }

    public String getStudname()
    {
        return studname;
    }

    public void setStudname(String studname)
    {
        this.studname = studname;
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
