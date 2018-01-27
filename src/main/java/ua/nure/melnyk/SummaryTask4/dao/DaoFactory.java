package ua.nure.melnyk.SummaryTask4.dao;

import ua.nure.melnyk.SummaryTask4.dao.entitydao.CourseDao;
import ua.nure.melnyk.SummaryTask4.dao.entitydao.UserDao;
import ua.nure.melnyk.SummaryTask4.dao.factorydao.MySQLDaoFactory;
import ua.nure.melnyk.SummaryTask4.exceptions.DBException;

import javax.naming.NamingException;
import java.util.HashMap;
import java.util.Map;

public abstract class DaoFactory {
    private static Map<String, DaoFactory> factories;

    public static DaoFactory getDAOFactory(String factory) throws DBException, NamingException {
        factories = new HashMap<>();
        factories.put("mysql", MySQLDaoFactory.getInstance());
        return factories.get(factory);
    }
    public abstract UserDao getUserDao();
   public abstract CourseDao getCourseDao();

}
