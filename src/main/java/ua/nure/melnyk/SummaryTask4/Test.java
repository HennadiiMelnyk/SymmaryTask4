package ua.nure.melnyk.SummaryTask4;

import ua.nure.melnyk.SummaryTask4.dao.CrudDao;
import ua.nure.melnyk.SummaryTask4.dao.DaoFactory;
import ua.nure.melnyk.SummaryTask4.exceptions.DBException;

import javax.naming.NamingException;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws DBException, NamingException, SQLException {
        DaoFactory daoFactory = DaoFactory.getDAOFactory("mysql");
        CrudDao crudDao = daoFactory.getUserDao();
        crudDao.getById(1);
    }
}
