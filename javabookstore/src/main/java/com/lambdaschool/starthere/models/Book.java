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
    private String bookname;

    @ManyToOne
    @JoinColumn(name = "sectionid")
    @JsonIgnoreProperties("books")
//    @JsonView(View.BooksOnly.class)
    private Section section;

    @ManyToMany(mappedBy = "books")
    @JsonIgnoreProperties("books")
    private List<Student> students = new ArrayList<>();


    public Book()
    {
    }

    public Book(String bookname)
    {
        this.bookname = bookname;
    }

    public Book(String bookname, Section section)
    {
        this.bookname = bookname;
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

    public String getBookname()
    {
        return bookname;
    }

    public void setBookname(String bookname)
    {
        this.bookname = bookname;
    }

    public Section getInstructor()
    {
        return section;
    }

    public void setInstructor(Section section)
    {
        this.section = section;
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
