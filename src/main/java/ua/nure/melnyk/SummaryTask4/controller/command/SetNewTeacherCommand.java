package ua.nure.melnyk.SummaryTask4.controller.command;

import org.apache.log4j.Logger;
import ua.nure.melnyk.SummaryTask4.exceptions.CustomException;
import ua.nure.melnyk.SummaryTask4.model.User;
import ua.nure.melnyk.SummaryTask4.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class SetNewTeacherCommand extends Command {
    private static final long serialVersionUID = 1751982338098910045L;
    private static final Logger LOG = Logger.getLogger(SetNewTeacherCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, CustomException, SQLException, NoSuchAlgorithmException {
        LOG.debug("Command starts");

        UserService userService = (UserService) request.getServletContext().getAttribute("userService");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        // List<User> userList = userService.createUser(user);

        String email = request.getParameter("email");
        LOG.trace("Request parameter: email --> " + email);
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        String active = request.getParameter("active");
        return null;
    }
}
