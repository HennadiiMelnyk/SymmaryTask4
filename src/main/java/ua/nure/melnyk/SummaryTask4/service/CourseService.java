package ua.nure.melnyk.SummaryTask4.service;

import ua.nure.melnyk.SummaryTask4.exceptions.DBException;
import ua.nure.melnyk.SummaryTask4.model.Course;
import ua.nure.melnyk.SummaryTask4.model.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Course Service
 *
 *
 *
 */
public interface CourseService {
    public boolean createCourse(Course course) throws DBException, SQLException;

    public Course updateCourse(int id,Course course);

    public Course getById(int id) throws DBException, SQLException;

    public boolean delete(int id);

    public List<Course> getAllCoursesByUser(User user);
    public List<Course> getAllCoursesByTeacher(User user);
}
