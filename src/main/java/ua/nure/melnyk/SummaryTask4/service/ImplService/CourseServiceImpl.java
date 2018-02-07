package ua.nure.melnyk.SummaryTask4.service.ImplService;

import ua.nure.melnyk.SummaryTask4.dao.entitydao.CourseDao;
import ua.nure.melnyk.SummaryTask4.exceptions.DBException;
import ua.nure.melnyk.SummaryTask4.model.Course;
import ua.nure.melnyk.SummaryTask4.model.User;
import ua.nure.melnyk.SummaryTask4.service.CourseService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Course Service
 * Business logic
 */
public class CourseServiceImpl implements CourseService {

    private CourseDao courseDao;

    public CourseServiceImpl(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public boolean createCourse(Course course) throws DBException, SQLException {
        courseDao.create(course);
        return true;
    }

    @Override
    public Course updateCourse(int id, Course course) {
        return null;
    }

    @Override
    public Course getById(int id) throws DBException, SQLException {
        return courseDao.getById(id);
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public List<Course> getAllCoursesByUser(User user) {
        List<Course> courses = new ArrayList<>();

        return courses;
    }

    @Override
    public List<Course> getAllCoursesByTeacher(User user) {
        List<Course> courses = new ArrayList<>();
        //getAllCoursesByTeacher()
        return courses;
    }
}
