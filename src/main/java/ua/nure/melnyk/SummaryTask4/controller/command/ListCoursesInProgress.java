package ua.nure.melnyk.SummaryTask4.controller.command;

import ua.nure.melnyk.SummaryTask4.exceptions.CustomException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class ListCoursesInProgress extends Command {
    private static final long serialVersionUID = 6977594662835611916L;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, CustomException, SQLException, NoSuchAlgorithmException {
        return null;
    }
}
