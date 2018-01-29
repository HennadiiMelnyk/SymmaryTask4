package ua.nure.melnyk.SummaryTask4.service.ImplService;


import ua.nure.melnyk.SummaryTask4.dao.entitydao.UserDao;
import ua.nure.melnyk.SummaryTask4.exceptions.DBException;
import ua.nure.melnyk.SummaryTask4.exceptions.UserDataException;
import ua.nure.melnyk.SummaryTask4.model.User;
import ua.nure.melnyk.SummaryTask4.service.UserService;

import java.sql.SQLException;

/**
 * User Service
 * Business logic
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean registerUser(User user) throws DBException, SQLException {
        userDao.create(user);
        user = new User();
        user.getRole();
        user.getPassword();
        return false;
    }

    @Override
    public User updateUser(int id, User user) throws DBException, SQLException {
        userDao.update(id, user);
        return user;
    }

    @Override
    public User findUserById(int id) throws DBException, SQLException {
        userDao.getById(id);
        return userDao.getById(id);
    }

    @Override
    public boolean deleteUserById(int id) throws DBException, SQLException {

        userDao.delete(id);
        return true;
    }

    @Override
    public boolean login(String email, String password) throws DBException, SQLException, UserDataException {
        User user = userDao.getUserByEmail(email);

        return true;

    }
}
