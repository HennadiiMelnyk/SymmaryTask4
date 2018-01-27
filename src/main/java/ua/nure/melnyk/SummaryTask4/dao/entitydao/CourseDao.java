package ua.nure.melnyk.SummaryTask4.dao.entitydao;

import ua.nure.melnyk.SummaryTask4.dao.CrudDao;
import ua.nure.melnyk.SummaryTask4.exceptions.DBException;
import ua.nure.melnyk.SummaryTask4.model.Course;

import java.sql.SQLException;
import java.util.List;

//TODO write docs.
public interface CourseDao extends CrudDao<Course> {
//sortByAsc
    //sortByDesc
    //getCoursesByTopic
    //getCoursesByTeacher
    public List<Course> sortByAsc(Course course) throws DBException, SQLException;


    public List<Course> sortByDesc(Course course) throws DBException, SQLException;

    public List<Course>getCoursesByTopic(Course course) throws DBException, SQLException;

    public List<Course> getCoursesByTeacher(Course course) throws DBException, SQLException;
}
