package ua.nure.melnyk.SummaryTask4.controller.command;

import org.apache.log4j.Logger;
import ua.nure.melnyk.SummaryTask4.Const.Path;
import ua.nure.melnyk.SummaryTask4.exceptions.CustomException;
import ua.nure.melnyk.SummaryTask4.model.User;
import ua.nure.melnyk.SummaryTask4.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SignUpCommand extends Command {
    private static final long serialVersionUID = -6745332027521116337L;

    private static final Logger LOG = Logger.getLogger(SignUpCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, CustomException, SQLException, NoSuchAlgorithmException {
        LOG.debug("Command starts");



        UserService userService = (UserService) request.getServletContext().getAttribute("userService");

        User user = new User();



                userService.createUser(user);

             //   sendMailCommand


        request.getRequestDispatcher(Path.PAGE_LIST_SIGN_UP).forward(request,response);
        //return userService.login(email, password, request.getSession());
         return userService.createUser(user).toString();

    }
}
