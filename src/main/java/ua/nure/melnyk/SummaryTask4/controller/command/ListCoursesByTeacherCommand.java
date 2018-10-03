package ua.nure.melnyk.SummaryTask4.controller.command;

import org.apache.log4j.Logger;
import ua.nure.melnyk.SummaryTask4.Const.Path;
import ua.nure.melnyk.SummaryTask4.dao.entitydao.Impl.MySQLCourseDaoImpl;
import ua.nure.melnyk.SummaryTask4.exceptions.CustomException;
import ua.nure.melnyk.SummaryTask4.model.Course;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

public class ListCoursesByTeacherCommand extends Command {
    private static final long serialVersionUID = 9061101299742179503L;
    private static final Logger LOG = Logger.getLogger(ListCoursesByTeacherCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, CustomException, SQLException, NoSuchAlgorithmException {
        LOG.debug("Command starts");

        MySQLCourseDaoImpl mySQLCourseDao = (MySQLCourseDaoImpl) request.getServletContext().getAttribute("mySQLCourseDao");
        Course course=new Course();

        List<Course> courses =mySQLCourseDao.getCoursesByTeacher(course);
        if (!courses.isEmpty()) {
            request.setAttribute("coursesList", courses);
            LOG.debug("Command finished");
            return Path.PAGE_LIST_COURSES;
        }
        LOG.error("Problem while getting  courses.");
        return Path.PAGE_ERROR_PAGE;
    }
}
