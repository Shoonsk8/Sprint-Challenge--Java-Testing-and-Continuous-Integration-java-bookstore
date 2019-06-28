package com.lambdaschool.starthere.services;


import com.lambdaschool.starthere.models.Course;
import com.lambdaschool.starthere.view.CountStudentsInCourses;

import java.util.ArrayList;
import java.util.List;

public interface CourseService
{
    List<Course> findAll();
    List<CountStudentsInCourses> getCountStudentsInCourse();

    void delete(long id);

    Course findCourseById(long id);

    Course save(Course newCourse);
}
