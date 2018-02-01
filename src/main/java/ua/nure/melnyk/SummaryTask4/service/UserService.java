package ua.nure.melnyk.SummaryTask4.service;

import ua.nure.melnyk.SummaryTask4.dto.ScheduleDto;
import ua.nure.melnyk.SummaryTask4.exceptions.CustomException;
import ua.nure.melnyk.SummaryTask4.exceptions.DBException;
import ua.nure.melnyk.SummaryTask4.model.Course;
import ua.nure.melnyk.SummaryTask4.model.User;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

/**
 * User Service
 *
 *
 *
 */
public interface UserService {
    public boolean registerUser(User user) throws DBException, SQLException;

    public User updateUser(int id, User user) throws DBException, SQLException;

    public User findUserById(int id) throws DBException, SQLException;

    public boolean deleteUserById(int id) throws DBException, SQLException;

    public String login(String email, String password, HttpSession session) throws CustomException, SQLException;

    public List<ScheduleDto> getAllCoursesByUser(User user) throws DBException, SQLException;

    public List<Course> getStartedCoursesByUser(User user) throws DBException, SQLException;

    public List<Course> getPendingCoursesByUser(User user) throws DBException, SQLException;

    public List<Course> getFinishedCoursesByUser(User user) throws DBException, SQLException;


}
