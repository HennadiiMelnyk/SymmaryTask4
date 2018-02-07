package ua.nure.melnyk.SummaryTask4.dao.entitydao.Impl;

import org.apache.log4j.Logger;
import ua.nure.melnyk.SummaryTask4.dao.entitydao.UserDao;
import ua.nure.melnyk.SummaryTask4.dao.factorydao.MySQLDaoFactory;
import ua.nure.melnyk.SummaryTask4.exceptions.DBException;
import ua.nure.melnyk.SummaryTask4.exceptions.Messages;
import ua.nure.melnyk.SummaryTask4.exceptions.UserDataException;
import ua.nure.melnyk.SummaryTask4.model.Course;
import ua.nure.melnyk.SummaryTask4.model.Schedule;
import ua.nure.melnyk.SummaryTask4.model.User;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static ua.nure.melnyk.SummaryTask4.Const.SQLQuery.SQL_CREATE_USER;
import static ua.nure.melnyk.SummaryTask4.Const.SQLQuery.SQL_DELETE_USER_BY_ID;
import static ua.nure.melnyk.SummaryTask4.Const.SQLQuery.SQL_GET_ALL_COURSE_BY_USER;
import static ua.nure.melnyk.SummaryTask4.Const.SQLQuery.SQL_GET_FINISHED_COURSES_BY_USER;
import static ua.nure.melnyk.SummaryTask4.Const.SQLQuery.SQL_GET_PENDING_COURSES_BY_USER;
import static ua.nure.melnyk.SummaryTask4.Const.SQLQuery.SQL_GET_STARTED_COURSES_BY_USER;
import static ua.nure.melnyk.SummaryTask4.Const.SQLQuery.SQL_GET_USER_BY_EMAIL;
import static ua.nure.melnyk.SummaryTask4.Const.SQLQuery.SQL_SELECT_USER_BY_ID;
import static ua.nure.melnyk.SummaryTask4.Const.SQLQuery.SQL_UPDATE_COURSE;
import static ua.nure.melnyk.SummaryTask4.Const.SQLQuery.SQL_UPDATE_USER_BY_ID;

public class MySQLUserDaoImpl implements UserDao {
    public MySQLUserDaoImpl() {

    }

    private static final Logger LOGGER = Logger.getLogger(MySQLUserDaoImpl.class);

    private Connection connection;

    private PreparedStatement preparedStatement;

    private ResultSet resultSet;


    @Override
    public boolean create(User user) throws DBException, SQLException {
        boolean result = true;
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(SQL_CREATE_USER);
            int k = 1;
            preparedStatement.setString(k++, user.getEmail());
            preparedStatement.setString(k++, user.getPassword());
            preparedStatement.setString(k++, user.getName());
            preparedStatement.setBoolean(k++, user.isActive());
            //preparedStatement.setBoolean(k++, user.getStatus());
            execute();
            commit();
        } catch (SQLException e) {
            result = false;
            rollback();
            LOGGER.error(Messages.LOG_CREATE_USER_EXCEPTION);
            throw new DBException(Messages.LOG_CREATE_USER_EXCEPTION, e);
        } finally {
            close();
        }
        return result;
    }

    /**
     * Update user.
     *
     * @param user,id user to update.
     * @throws SQLException
     */
    @Override
    public User update(int id, User user) throws DBException, SQLException {
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(SQL_UPDATE_USER_BY_ID);
            int k = 1;
            //preparedStatement.setObject(k++, user.getStatus());
            preparedStatement.setString(k++, user.getEmail());
            preparedStatement.setString(k++, user.getPassword());
            preparedStatement.setInt(k, user.getId());
            execute();
            commit();
        } catch (SQLException e) {
            rollback();
            LOGGER.error(Messages.LOG_UPDATE_USER_BY_ID_EXCEPTION);
            throw new DBException(Messages.LOG_UPDATE_USER_BY_ID_EXCEPTION, e);
        } finally {
            close();
        }
        return null;
    }

    @Override
    public User getById(int id) throws DBException, SQLException {
        User user = null;
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(SQL_SELECT_USER_BY_ID);
            int k = 1;
            preparedStatement.setInt(k++, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setEmail(resultSet.getString(3));
                user.setPassword(resultSet.getString(4));
                user.setRole(resultSet.getString(5));
                user.setActive(resultSet.getBoolean(6));
            }
        } catch (SQLException e) {
            rollback();
            LOGGER.error(Messages.LOG_GET_USER_BY_ID_EXCEPTION);
            new DBException(Messages.LOG_GET_USER_BY_ID_EXCEPTION, e);
        } finally {
            close(resultSet);
            close();
        }
        return user;
    }

    @Override
    public boolean delete(int id) throws DBException, SQLException {
        boolean result = true;
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(SQL_DELETE_USER_BY_ID);
            int k = 1;
            preparedStatement.setInt(k++, id);
            execute();
            commit();
        } catch (SQLException e) {
            result = false;
            rollback();
            LOGGER.error(Messages.LOG_DELETE_USER_BY_ID_EXCEPTION);
            throw new DBException(Messages.LOG_DELETE_USER_BY_ID_EXCEPTION, e);
        } finally {
            close();
        }
        return result;
    }

    //
    @Override
    public List<Schedule> getAllCoursesByUser(User user) throws DBException, SQLException {
        List<Schedule> scheduleList = new ArrayList<>();
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(SQL_GET_ALL_COURSE_BY_USER);
            int k =1;
            preparedStatement.setInt(k++, user.getId());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Schedule schedule = new Schedule();
                schedule.setId(resultSet.getInt(1));
                schedule.setIdUser(user.getId());
                schedule.setCourseName(resultSet.getString(2));
                schedule.setMark(resultSet.getInt(3));
                schedule.setProgress(resultSet.getString(4));
                scheduleList.add(schedule);
            }
        } catch (SQLException e) {
            rollback();
            LOGGER.error(Messages.LOG_GET_ALL_COURSE_BY_USER_EXCEPTION);
            throw new DBException(Messages.LOG_GET_ALL_COURSE_BY_USER_EXCEPTION, e);
        } finally {
            close(resultSet);
            close();
        }
        return scheduleList;
    }

    @Override
    public List<Schedule> getStartedCoursesByUser(User user) throws DBException, SQLException {
        List<Schedule> scheduleList = new ArrayList<>();

        try {
            getConnection();
            int k =1;
            preparedStatement.setInt(k++, user.getId());
            preparedStatement = connection.prepareStatement(SQL_GET_STARTED_COURSES_BY_USER);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Schedule schedule = new Schedule();
                schedule.setId(resultSet.getInt(1));
                schedule.setIdUser(user.getId());
                schedule.setCourseName(resultSet.getString(2));
                schedule.setMark(resultSet.getInt(3));
                schedule.setProgress(resultSet.getString(4));
                scheduleList.add(schedule);
            }

        } catch (SQLException e) {
            rollback();
            LOGGER.error(Messages.LOG_GET_STARTED_COURSES_BY_USER_EXCEPTION);
            throw new DBException(Messages.LOG_GET_STARTED_COURSES_BY_USER_EXCEPTION, e);
        } finally {
            close(resultSet);
            close();
        }
        return scheduleList;
    }

    @Override
    public List<Schedule> getPendingCoursesByUser(User user) throws DBException, SQLException {
        List<Schedule> scheduleList = new ArrayList<>();

        try {
            getConnection();
            preparedStatement = connection.prepareStatement(SQL_GET_PENDING_COURSES_BY_USER);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Schedule schedule = new Schedule();
                schedule.setId(resultSet.getInt(1));
                schedule.setIdUser(user.getId());
                schedule.setCourseName(resultSet.getString(2));
                schedule.setMark(resultSet.getInt(3));
                schedule.setProgress(resultSet.getString(4));
                scheduleList.add(schedule);
            }

        } catch (SQLException e) {
            rollback();
            LOGGER.error(Messages.LOG_GET_PENDING_COURSES_BY_USER_EXCEPTION);
            throw new DBException(Messages.LOG_GET_PENDING_COURSES_BY_USER_EXCEPTION, e);
        } finally {
            close(resultSet);
            close();
        }
        return scheduleList;
    }

    @Override
    public List<Schedule> getFinishedCoursesByUser(User user) throws DBException, SQLException {
        List<Schedule> scheduleList = new ArrayList<>();
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(SQL_GET_FINISHED_COURSES_BY_USER);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Schedule schedule = new Schedule();
                schedule.setId(resultSet.getInt(1));
                schedule.setIdUser(user.getId());
                schedule.setCourseName(resultSet.getString(2));
                schedule.setMark(resultSet.getInt(3));
                schedule.setProgress(resultSet.getString(4));
                scheduleList.add(schedule);
            }

        } catch (SQLException e) {
            rollback();
            LOGGER.error(Messages.LOG_GET_FINISHED_COURSES_BY_USER_EXCEPTION);
            throw new DBException(Messages.LOG_GET_FINISHED_COURSES_BY_USER_EXCEPTION, e);
        } finally {
            close(resultSet);
            close();
        }
        return scheduleList;
    }


    @Override
    public void updateCourses(Course... courses) throws DBException, SQLException {
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(SQL_UPDATE_COURSE);
            for (Course course : courses) {
                int k = 1;
                preparedStatement.setString(k++, course.getName());
                preparedStatement.setString(k++, course.getProgress());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            commit();
        } catch (SQLException e) {
            rollback();
            LOGGER.error(Messages.LOG_UPDATE_COURSE_EXCEPTION);
            throw new DBException(Messages.LOG_UPDATE_COURSE_EXCEPTION, e);
        } finally {
            close();
        }


    }

    @Override
    public void updateStudentUser(User user) throws DBException, SQLException {

        try {
            getConnection();
            preparedStatement = connection.prepareStatement(SQL_UPDATE_USER_BY_ID);
            int k = 1;
            preparedStatement.setString(k++, user.getPassword());
            preparedStatement.setString(k++, user.getEmail());
            preparedStatement.setString(k++, user.getPassword());
            // preparedStatement.setObject(k++, user.getStatus());
            execute();
            commit();
        } catch (SQLException e) {
            rollback();
            LOGGER.error(Messages.LOG_UPDATE_USER_BY_ID_EXCEPTION);
            throw new DBException(Messages.LOG_UPDATE_USER_BY_ID_EXCEPTION, e);
        } finally {
            close();
        }


    }

    @Override
    public User getUserByEmail(String email) throws DBException, SQLException, UserDataException {
        User user = null;
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(SQL_GET_USER_BY_EMAIL);
            int k = 1;
            preparedStatement.setString(k++, email);
            resultSet = preparedStatement.executeQuery();
            user = new User();
            while (resultSet.next()) {
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setEmail(resultSet.getString(3));
                user.setPassword(resultSet.getString(4));
                user.setRole(resultSet.getString(5));
                user.setActive(resultSet.getBoolean(6));
            }
        } catch (SQLException e) {
            rollback();
            LOGGER.error(Messages.LOG_GET_USER_BY_EMAIL_EXCEPTION);
            throw new DBException(Messages.LOG_GET_USER_BY_EMAIL_EXCEPTION, e);
        } finally {
            close();
        }
        if (user != null) {
            return user;
        }
        throw new UserDataException(
                "[MySQLUserDaoImpl#getUserByEmail]getting user from database was returned null, check resultset");
    }

    private void getConnection() throws SQLException, DBException {
        try {
            connection = MySQLDaoFactory.getInstance().getConnection();
        } catch (SQLException e) {
            LOGGER.error(Messages.LOG_GET_CONNECTION_EXCEPTION);
            throw new SQLException(e);
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    private void execute() throws SQLException {
        try {
            preparedStatement.execute();
        } catch (SQLException e) {
            LOGGER.error(Messages.LOG_EXECUTION_EXCEPTION);
            throw new SQLException(e);
        }
    }

    private void commit() throws SQLException {
        try {
            connection.commit();
        } catch (SQLException e) {
            LOGGER.error(Messages.LOG_COMMIT_EXCEPTION);
            throw new SQLException(e);
        }
    }

    /**
     * rollback
     * Rollbacks a connection.
     */
    private void rollback() throws SQLException, DBException {
        try {
            connection.rollback();
        } catch (SQLException e) {
            LOGGER.error(Messages.LOG_ROLLBACK_EXCEPTION);
            throw new DBException(Messages.LOG_ROLLBACK_EXCEPTION, e);
        }
    }

    /**
     * Closes resources.
     */
    private void close() throws DBException {
        if (resultSet != null) {
            try {
                preparedStatement.close();
                connection.close();
                resultSet.close();
            } catch (SQLException e) {
                LOGGER.error(Messages.LOG_CLOSE_EXCEPTION);
                throw new DBException(Messages.LOG_CLOSE_EXCEPTION, e);
            }
        }
    }

    /**
     * Closes a result set object.
     */
    private void close(ResultSet resultSet) throws DBException {
        try {
            resultSet.close();
        } catch (SQLException e) {
            LOGGER.error(Messages.LOG_RS_CLOSE_EXCEPTION);
            throw new DBException(Messages.LOG_RS_CLOSE_EXCEPTION, e);
        }
    }


}
