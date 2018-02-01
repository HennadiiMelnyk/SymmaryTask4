package ua.nure.melnyk.SummaryTask4.dao.entitydao.Impl;

import ua.nure.melnyk.SummaryTask4.dao.entitydao.CourseDao;
import ua.nure.melnyk.SummaryTask4.dao.factorydao.MySQLDaoFactory;
import ua.nure.melnyk.SummaryTask4.exceptions.DBException;
import ua.nure.melnyk.SummaryTask4.exceptions.Messages;
import ua.nure.melnyk.SummaryTask4.model.Course;
import ua.nure.melnyk.SummaryTask4.dto.CourseDto;
import org.apache.log4j.Logger;
import ua.nure.melnyk.SummaryTask4.model.User;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import static ua.nure.melnyk.SummaryTask4.Const.SQLQuery.*;

public class MySQLCourseDaoImpl implements CourseDao {

    public MySQLCourseDaoImpl() {
    }

    private static final Logger LOGGER = Logger.getLogger(MySQLCourseDaoImpl.class);

    private Connection connection;

    private PreparedStatement preparedStatement;

    private ResultSet resultSet;

    @Override
    public List<Course> sortByAsc(Course course) throws DBException, SQLException {
        List<Course> courses = new ArrayList<>();
        Statement statement;
        try {
            getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_SORTED_BY_ASC);
            while (resultSet.next()) {
                courses.add(new Course(
                        resultSet.getString(SQL_NAME_COLUMN_INDEX),
                        resultSet.getString(SQL_PROGRESS_COLUMN_INDEX)
                ));
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            rollback();
            LOGGER.error(Messages.LOG_SORTED_BY_ASC_EXCEPTION);
            throw new DBException(Messages.LOG_SORTED_BY_ASC_EXCEPTION, e);
        }
        return courses;

    }


    @Override
    public List<Course> sortByDesc(Course course) throws DBException, SQLException {

        List<Course> courses = new ArrayList<>();
        Statement statement;
        try {
            getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_SORTED_BY_DESC);
            while (resultSet.next()) {
                courses.add(new Course(
                        resultSet.getString(SQL_NAME_COLUMN_INDEX),
                        resultSet.getString(SQL_PROGRESS_COLUMN_INDEX)
                ));
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            rollback();
            LOGGER.error(Messages.LOG_SORTED_BY_DESC_EXCEPTION);
            throw new DBException(Messages.LOG_SORTED_BY_DESC_EXCEPTION, e);
        }
        return courses;
    }

    @Override
    public List<Course> getCoursesByTopic(Course course) throws DBException, SQLException {

        Statement statement;
        List<Course> courses = new ArrayList<>();
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(SQL_GET_ALL_COURSE_BY_USER);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                course.setId(resultSet.getInt("id"));
                course.setName(resultSet.getString("name"));
                course.setProgress(resultSet.getString("progress"));

                courses.add(course);
            }
        } catch (SQLException e) {
            rollback();
            LOGGER.error(Messages.LOG_GET_ALL_COURSE_BY_USER_EXCEPTION);
            throw new DBException(Messages.LOG_GET_ALL_COURSE_BY_USER_EXCEPTION, e);
        } finally {
            close(resultSet);
            close();
        }
        return courses;
    }

    @Override
    public List<Course> getCoursesByTeacher(Course course) throws DBException, SQLException {
        List<Course> courses = new ArrayList<>();
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(SQL_GET_COURSES_BY_TEACHER);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                course.setId(resultSet.getInt("id"));
                course.setName(resultSet.getString("name"));
                course.setProgress(resultSet.getString("progress"));

                courses.add(course);
            }
        } catch (SQLException e) {
            rollback();
            LOGGER.error(Messages.LOG_GET_ALL_COURSE_BY_USER_EXCEPTION);
            throw new DBException(Messages.LOG_GET_ALL_COURSE_BY_USER_EXCEPTION, e);
        } finally {
            close(resultSet);
            close();
        }
        return courses;
    }

    @Override
    public boolean create(Course course) throws DBException, SQLException {
        boolean result = true;
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(SQL_CREATE_COURSE);
            int k = 1;
            preparedStatement.setString(k++, course.getName());
            preparedStatement.setString(k++, course.getProgress());

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

    @Override
    public Course update(int id, Course course) throws DBException {

        PreparedStatement preparedStatement;
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(SQL_UPDATE_COURSE_BY_ID);
            course.setProgress(resultSet.getString("progress"));
            course.setName(resultSet.getString("name"));
            course.setId(resultSet.getInt("id"));
            execute();
            commit();
        } catch (SQLException e) {

            rollback();
            LOGGER.error(Messages.LOG_UPDATE_COURSE_BY_ID_EXCEPTION);
            throw new DBException(Messages.LOG_UPDATE_COURSE_BY_ID_EXCEPTION, e);
        } finally {
            close();

            return course;
        }
    }

    @Override
    public Course getById(int id) throws DBException, SQLException {
        Course course = null;
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(SQL_SELECT_USER_BY_ID);
            int k = 1;
            preparedStatement.setInt(k++, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                course.setId(id);
                course.setName(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            rollback();
            LOGGER.error(Messages.LOG_GET_COURSE_BY_ID_EXCEPTION);
            new DBException(Messages.LOG_GET_COURSE_BY_ID_EXCEPTION, e);
        } finally {
            close(resultSet);
            close();
        }
        return course;
    }

    @Override
    public boolean delete(int id) throws DBException, SQLException {


        boolean result = true;
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(SQL_DELETE_COURSE_BY_ID);
            int k = 1;
            preparedStatement.setInt(k++, id);
            execute();
            commit();
        } catch (SQLException e) {
            result = false;
            rollback();
            LOGGER.error(Messages.LOG_DELETE_COURSE_BY_ID_EXCEPTION);
            throw new DBException(Messages.LOG_DELETE_COURSE_BY_ID_EXCEPTION, e);
        } finally {
            close();
        }
        return result;
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

    private void rollback() throws SQLException, DBException {
        try {
            connection.rollback();
        } catch (SQLException e) {
            LOGGER.error(Messages.LOG_ROLLBACK_EXCEPTION);
            throw new DBException(Messages.LOG_ROLLBACK_EXCEPTION, e);
        }
    }

    private void close() throws DBException {
        try {
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            LOGGER.error(Messages.LOG_CLOSE_EXCEPTION);
            throw new DBException(Messages.LOG_CLOSE_EXCEPTION, e);
        }
    }

    private void close(ResultSet resultSet) throws DBException {
        try {
            resultSet.close();
        } catch (SQLException e) {
            LOGGER.error(Messages.LOG_RS_CLOSE_EXCEPTION);
            throw new DBException(Messages.LOG_RS_CLOSE_EXCEPTION, e);
        }
    }

}
