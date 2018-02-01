package ua.nure.melnyk.SummaryTask4.dao.entitydao;

import ua.nure.melnyk.SummaryTask4.dao.CrudDao;
import ua.nure.melnyk.SummaryTask4.exceptions.DBException;
import ua.nure.melnyk.SummaryTask4.exceptions.UserDataException;
import ua.nure.melnyk.SummaryTask4.model.Course;
import ua.nure.melnyk.SummaryTask4.model.Schedule;
import ua.nure.melnyk.SummaryTask4.model.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @param
 * @return
 * @throws DBException
 */

public interface UserDao extends CrudDao<User> {

    //---------Student------------
    //getAllCoursesByUser(User user)
    //getStartedCoursesByUser(User user)-->courses
    //getPendingCoursesByUser(User user)
    //getFinishedCoursesByUser(User user) -- > courses + marks
    public List<Schedule> getAllCoursesByUser(User user) throws DBException, SQLException;

    public List<Course> getStartedCoursesByUser(User user) throws DBException, SQLException;

    public List<Course> getPendingCoursesByUser(User user) throws DBException, SQLException;

    public List<Course> getFinishedCoursesByUser(User user) throws DBException, SQLException;


    //---------Teacher------------
    //updateCourses(Course... courses)
    public void updateCourses(Course... course) throws DBException, SQLException;

    //--------Admin--------------
    //updateStudentUser(User user)

    public void updateStudentUser(User user) throws DBException, SQLException;

    public User getUserByEmail(String email) throws DBException, SQLException, UserDataException;

}
