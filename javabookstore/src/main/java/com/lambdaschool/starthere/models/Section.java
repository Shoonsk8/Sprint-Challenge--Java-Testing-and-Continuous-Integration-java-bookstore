package com.lambdaschool.starthere.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "section")
class Section{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long sectionid;

    private String name;

    @OneToMany(mappedBy = "section")
    @JsonIgnoreProperties("sections")
    private List<Book> books = new ArrayList<>();

    public Section()
    {
    }

    public Section(String sectionname)
    {
        this.name = sectionname;
    }

    public long getSectionid()
    {
        return sectionid;
    }

    public void setSectionid(long sectionid)
    {
        this.sectionid = sectionid;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
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
