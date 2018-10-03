package ua.nure.melnyk.SummaryTask4.controller.command;

import org.apache.log4j.Logger;
import ua.nure.melnyk.SummaryTask4.Const.Path;
import ua.nure.melnyk.SummaryTask4.dto.ScheduleDto;
import ua.nure.melnyk.SummaryTask4.exceptions.CustomException;
import ua.nure.melnyk.SummaryTask4.model.User;
import ua.nure.melnyk.SummaryTask4.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ListCoursesCommand extends Command {


    private static final long serialVersionUID = -8091899143051088131L;

    private static final Logger LOG = Logger.getLogger(ListCoursesCommand.class);

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) throws IOException, ServletException, CustomException, SQLException {
        LOG.debug("Command starts");

        UserService userService = (UserService) request.getServletContext().getAttribute("userService");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        List<ScheduleDto> coursesList = userService.getAllCoursesByUser(user);
        if (!coursesList.isEmpty()) {
            request.setAttribute("All courses", coursesList);
            LOG.debug("Command finished");
            return Path.PAGE_LIST_COURSES;
        }
        LOG.error("Problem while getting all courses.");
        return Path.PAGE_ERROR_PAGE;
    }
}


