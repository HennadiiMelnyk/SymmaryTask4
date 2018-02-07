package ua.nure.melnyk.SummaryTask4.service;

import com.google.api.services.gmail.model.Message;
import ua.nure.melnyk.SummaryTask4.exceptions.CustomException;
import ua.nure.melnyk.SummaryTask4.exceptions.DBException;
import ua.nure.melnyk.SummaryTask4.model.Schedule;
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

    public List<Schedule> getAllCoursesByUser(User user) throws DBException, SQLException;

    public List<Schedule> getStartedCoursesByUser(User user) throws DBException, SQLException;

    public List<Schedule> getPendingCoursesByUser(User user) throws DBException, SQLException;

    public List<Schedule> getFinishedCoursesByUser(User user) throws DBException, SQLException;

    public User createUser(User user) throws DBException, SQLException;

    public Message sendMessage();


}
