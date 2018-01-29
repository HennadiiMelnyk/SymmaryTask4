package ua.nure.melnyk.SummaryTask4.controller.command;

import ua.nure.melnyk.SummaryTask4.exceptions.CustomException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public abstract class Command implements Serializable {
    private static final long serialVersionUID = 6296143423086058083L;
    public abstract String execute(HttpServletRequest request,
                                   HttpServletResponse response) throws IOException, ServletException, CustomException, SQLException, NoSuchAlgorithmException;

    @Override
    public final String toString() {
        return getClass().getSimpleName();
    }
}
