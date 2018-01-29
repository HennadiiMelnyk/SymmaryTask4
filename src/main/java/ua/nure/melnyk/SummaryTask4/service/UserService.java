package ua.nure.melnyk.SummaryTask4.service;

import ua.nure.melnyk.SummaryTask4.exceptions.DBException;
import ua.nure.melnyk.SummaryTask4.exceptions.UserDataException;
import ua.nure.melnyk.SummaryTask4.model.User;

import java.sql.SQLException;

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

    public boolean login(String email, String password) throws DBException, SQLException, UserDataException;


}
