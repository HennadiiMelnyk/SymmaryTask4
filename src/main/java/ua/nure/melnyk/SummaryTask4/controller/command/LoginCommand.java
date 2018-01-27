package ua.nure.melnyk.SummaryTask4.controller.command;

import org.apache.log4j.Logger;
import ua.nure.melnyk.SummaryTask4.Const.Path;
import ua.nure.melnyk.SummaryTask4.exceptions.CustomException;
import ua.nure.melnyk.SummaryTask4.model.Role;
import ua.nure.melnyk.SummaryTask4.model.User;
import ua.nure.melnyk.SummaryTask4.service.ImplService.UserServiceImpl;
import ua.nure.melnyk.SummaryTask4.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class LoginCommand extends Command {

    private static final Logger LOG = Logger.getLogger(LoginCommand.class);
    private static final long serialVersionUID = -1304301803721254190L;
    private UserService userService;

    public LoginCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, CustomException, SQLException {
        LOG.debug("Command starts");

        HttpSession session = request.getSession();

        // obtain login and password from a request

        String email = request.getParameter("email");
        LOG.trace("Request parameter: email --> " + email);

        String password = request.getParameter("password");
        if (email == null || password == null || email.isEmpty() || password.isEmpty()) {
            throw new CustomException("Email/password cannot be empty");
        }

        // User user = UserServiceImpl.findUserByLogin(login);
        User user = userService.
        //userService.login(email,password);
        LOG.trace("Found in DB: user --> " + email);

        // if (email == null || !password.equals(user.getPassword()))
        if (email == null || !password.equals(user.getPassword())) {
            throw new CustomException("Cannot find user with such email/password");
        }


        Role userRole = user.getRole();
        LOG.trace("userRole --> " + userRole);

        String forward = Path.PAGE_ERROR_PAGE;

        if (userRole == Role.ADMIN) {
            forward = Path.COMMAND_LIST_ORDERS;
        }

        if (userRole == Role.STUDENT) {
            forward = Path.COMMAND_LIST_MENU;
        }
        if (userRole == Role.TEACHER) {
            forward = Path.COMMAND_LIST_MENU;
        }


        session.setAttribute("user", user);
        LOG.trace("Set the session attribute: user --> " + user);

        session.setAttribute("userRole", userRole);
        LOG.trace("Set the session attribute: userRole --> " + userRole);

        LOG.info("User " + user + " logged as " + userRole.toString().toLowerCase());

        LOG.debug("Command finished");
        return forward;
    }
}

