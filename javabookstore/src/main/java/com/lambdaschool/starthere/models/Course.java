package com.lambdaschool.starthere.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
public class Course extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @JsonView(View.CoursesOnly.class)
    private long courseid;

//    @JsonView(View.CoursesOnly.class)
    private String coursename;

    @ManyToOne
    @JoinColumn(name = "sectionid")
    @JsonIgnoreProperties("courses")
//    @JsonView(View.CoursesOnly.class)
    private Section section;

    @ManyToMany(mappedBy = "courses")
    @JsonIgnoreProperties("courses")
    private List<Student> students = new ArrayList<>();


    public Course()
    {
    }

    public Course(String coursename)
    {
        this.coursename = coursename;
    }

    public Course(String coursename, Section section)
    {
        this.coursename = coursename;
        this.section = section;
    }

    public long getCourseid()
    {
        return courseid;
    }

    public void setCourseid(long courseid)
    {
        this.courseid = courseid;
    }

    public String getCoursename()
    {
        return coursename;
    }

    public void setCoursename(String coursename)
    {
        this.coursename = coursename;
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
