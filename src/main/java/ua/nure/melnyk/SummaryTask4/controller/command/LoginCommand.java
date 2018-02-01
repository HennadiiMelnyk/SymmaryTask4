package ua.nure.melnyk.SummaryTask4.controller.command;

import org.apache.log4j.Logger;
import ua.nure.melnyk.SummaryTask4.Const.Path;
import ua.nure.melnyk.SummaryTask4.exceptions.CustomException;
import ua.nure.melnyk.SummaryTask4.model.User;
import ua.nure.melnyk.SummaryTask4.security.Password;
import ua.nure.melnyk.SummaryTask4.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import static ua.nure.melnyk.SummaryTask4.model.Role.ADMIN;
import static ua.nure.melnyk.SummaryTask4.model.Role.STUDENT;
import static ua.nure.melnyk.SummaryTask4.model.Role.TEACHER;

public class LoginCommand extends Command {

    private static final Logger LOG = Logger.getLogger(LoginCommand.class);
    private static final long serialVersionUID = -1304301803721254190L;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, CustomException, SQLException, NoSuchAlgorithmException {
        LOG.debug("Command starts");

        HttpSession session = request.getSession();

        // obtain login and password from a request

        String email = request.getParameter("email");
        LOG.trace("Request parameter: email --> " + email);

        String password = request.getParameter("password");
        if (email == null || password == null || email.isEmpty() || password.isEmpty()) {
            throw new CustomException("Email/password cannot be empty");
        }

        UserService userService = (UserService) request.getServletContext().getAttribute("userService");
        return userService.login(email, password, request.getSession());
    }
}

