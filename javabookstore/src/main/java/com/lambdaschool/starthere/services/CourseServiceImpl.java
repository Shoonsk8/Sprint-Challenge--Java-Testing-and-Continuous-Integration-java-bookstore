package com.lambdaschool.starthere.services;


import com.lambdaschool.starthere.models.Course;
import com.lambdaschool.starthere.repository.CourseRepository;
import com.lambdaschool.starthere.view.CountStudentsInCourses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "courseService")
public class CourseServiceImpl implements CourseService
{
    @Autowired
    private CourseRepository courserepos;

    @Override
    public List<Course> findAll()
    {
        List<Course> list = new ArrayList<>();
        courserepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }
    @Override
    public List<CountStudentsInCourses> getCountStudentsInCourse()
    {
        return courserepos.getCountStudentsInCourse();
    }

    @Transactional
    @Override
    public void delete(long id) throws EntityNotFoundException
    {
        if (courserepos.findById(id).isPresent())
        {
            courserepos.deleteCourseFromStudcourses(id);
            courserepos.deleteById(id);
        } else
        {
            throw new EntityNotFoundException(Long.toString(id));
        }
    }

    @Override
    public Course findCourseById(long courseid) {
        return courserepos.getCourseByCourseid(courseid);
    }

    @Override
    public Course save(Course newCourse) {
        return courserepos.save(newCourse);
    }
}
