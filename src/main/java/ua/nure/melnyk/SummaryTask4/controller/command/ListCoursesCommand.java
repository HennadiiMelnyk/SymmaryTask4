package ua.nure.melnyk.SummaryTask4.controller.command;

import org.apache.log4j.Logger;
import ua.nure.melnyk.SummaryTask4.Const.Path;
import ua.nure.melnyk.SummaryTask4.exceptions.CustomException;
import ua.nure.melnyk.SummaryTask4.model.Course;
import ua.nure.melnyk.SummaryTask4.model.User;
import ua.nure.melnyk.SummaryTask4.service.CourseService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListCoursesCommand extends Command {


    private static final long serialVersionUID = -8091899143051088131L;

    private static final Logger LOG = Logger.getLogger(ListCoursesCommand.class);

    private CourseService courseService;

    public ListCoursesCommand(CourseService courseService) {

        this.courseService = courseService;
    }

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) throws IOException, ServletException, CustomException {

        LOG.debug("Command starts");

        // get menu items list

        User user= CourseService(courseService.getAllCoursesByUser(User user));
        List<Course> courses = courseService.getAllCoursesByUser(user);
                // DBManager.getInstance().findMenuItems();
        LOG.trace("Found in DB: menuItemsList --> " + menuItems);

        // sort menu by category
        Collections.sort(menuItems, new Comparator<Course>() {
            public int compare(menuitem o1, menuitem o2) {
                return (int)(o1.getCategoryId() - o2.getCategoryId());
            }
        });

        // put menu items list to the request
        request.setAttribute("menuItems", menuItems);
        LOG.trace("Set the request attribute: menuItems --> " + menuItems);

        LOG.debug("Command finished");

    }


