package ua.nure.melnyk.SummaryTask4.dao.factorydao;

import org.apache.log4j.Logger;
import ua.nure.melnyk.SummaryTask4.dao.DaoFactory;
import ua.nure.melnyk.SummaryTask4.dao.entitydao.CourseDao;
import ua.nure.melnyk.SummaryTask4.dao.entitydao.Impl.MySQLCourseDaoImpl;
import ua.nure.melnyk.SummaryTask4.dao.entitydao.Impl.MySQLUserDaoImpl;
import ua.nure.melnyk.SummaryTask4.dao.entitydao.UserDao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

//todo add docs.
public class MySQLDaoFactory extends DaoFactory {

    private static final Logger LOG = Logger.getLogger(MySQLDaoFactory.class);

    DataSource dataSource;

    private static MySQLDaoFactory instance;

    public static synchronized MySQLDaoFactory getInstance() throws NamingException {
        if (instance == null) {
            instance = new MySQLDaoFactory();
        }
        return instance;
    }

    private MySQLDaoFactory() {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            dataSource = (DataSource) envContext.lookup("/ldbc/ST4DB");
        } catch (NamingException e) {
            //TODO implement log messages
            //TODO implement custom exceptions(decide best practice to use checked or unchecked)
            LOG.error("");
        }
    }

    public Connection getConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        return connection;
    }

    @Override
    public UserDao getUserDao() {
        return new MySQLUserDaoImpl();
    }

    @Override
    public CourseDao getCourseDao() {
        return new MySQLCourseDaoImpl();
    }
}

