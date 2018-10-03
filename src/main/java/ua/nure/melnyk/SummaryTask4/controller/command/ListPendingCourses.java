package ua.nure.melnyk.SummaryTask4.controller.command;

import org.apache.log4j.Logger;
import ua.nure.melnyk.SummaryTask4.Const.Path;
import ua.nure.melnyk.SummaryTask4.dto.ScheduleDto;
import ua.nure.melnyk.SummaryTask4.exceptions.CustomException;
import ua.nure.melnyk.SummaryTask4.model.Course;
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

public class ListPendingCourses extends Command {
    private static final long serialVersionUID = 8766348406248872655L;
    private static final Logger LOG = Logger.getLogger(ListPendingCourses.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, CustomException, SQLException, NoSuchAlgorithmException {
        LOG.debug("Command starts");

        UserService userService = (UserService) request.getServletContext().getAttribute("userService");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        List<ScheduleDto> pendingCourses = userService.getPendingCoursesByUser(user);
        if (!pendingCourses.isEmpty()) {
            request.setAttribute("coursesList", pendingCourses);
            LOG.debug("Command finished");
            return Path.PAGE_LIST_STUDENT_COURSES;
        }
        LOG.error("Problem while getting courses.");
        return Path.PAGE_ERROR_PAGE;
    }
}