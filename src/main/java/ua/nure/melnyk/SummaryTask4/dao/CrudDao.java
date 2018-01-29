package ua.nure.melnyk.SummaryTask4.dao;


import ua.nure.melnyk.SummaryTask4.exceptions.DBException;

import java.sql.SQLException;

/**Main operations of Data Access Object layer
 *
 * @param <T> Type variable.
 */
public interface CrudDao<T> {
    boolean create(T t) throws DBException, SQLException;

    T update(int id, T t) throws DBException, SQLException;

    T getById(int id) throws DBException, SQLException;

    boolean delete(int id) throws DBException, SQLException;

}
