package ua.nure.melnyk.SummaryTask4.controller.command;

import ua.nure.melnyk.SummaryTask4.exceptions.CustomException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class CoursesManagementCommand extends Command {
    private static final long serialVersionUID = 284994263552748685L;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, CustomException, SQLException, NoSuchAlgorithmException {
        return null;
    }
}
