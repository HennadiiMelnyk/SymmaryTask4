package ua.nure.melnyk.SummaryTask4.controller.command;

import org.apache.log4j.Logger;
import ua.nure.melnyk.SummaryTask4.Const.Path;
import ua.nure.melnyk.SummaryTask4.exceptions.CustomException;
import ua.nure.melnyk.SummaryTask4.model.Schedule;
import ua.nure.melnyk.SummaryTask4.model.User;
import ua.nure.melnyk.SummaryTask4.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

public class ListStartedCourses extends Command {
    private static final long serialVersionUID = 6977594662835611916L;
    private static final Logger LOG = Logger.getLogger(ListStartedCourses.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, CustomException, SQLException, NoSuchAlgorithmException {
        LOG.debug("Command starts");

        UserService userService = (UserService) request.getServletContext().getAttribute("userService");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        List<Schedule> startedCourses = userService.getStartedCoursesByUser(user);
        if (!startedCourses.isEmpty()) {
            request.setAttribute("coursesList", startedCourses);
            LOG.debug("Command finished");
            return Path.PAGE_LIST_PENDING_COURSES;
        }
        LOG.error("Problem while getting progress courses.");
        return Path.PAGE_ERROR_PAGE;
    }
}
