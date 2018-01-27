package ua.nure.melnyk.SummaryTask4.service;

import ua.nure.melnyk.SummaryTask4.exceptions.DBException;
import ua.nure.melnyk.SummaryTask4.model.Course;

import java.sql.SQLException;

/**
 * Course Service
 *
 *
 *
 */
public interface CourseService {
    public boolean createCourse(Course course) throws DBException, SQLException;

    public Course updateCourse(int id,Course course);

    public Course getById(int id);

    public boolean delete(int id);
}
