package ua.nure.melnyk.SummaryTask4;

import ua.nure.melnyk.SummaryTask4.controller.command.*;
import ua.nure.melnyk.SummaryTask4.dao.entitydao.Impl.MySQLCourseDaoImpl;
import ua.nure.melnyk.SummaryTask4.dao.entitydao.Impl.MySQLUserDaoImpl;
import ua.nure.melnyk.SummaryTask4.service.ImplService.CourseServiceImpl;
import ua.nure.melnyk.SummaryTask4.service.ImplService.UserServiceImpl;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Map;
import java.util.TreeMap;

@WebListener
public class ApplicationContext implements ServletContextListener {

    //private static final Logger LOG = Logger.getLogger(ApplicationContext.class);

    private UserServiceImpl userService;
    private CourseServiceImpl courseService;
    private MySQLUserDaoImpl mySQLUserDao;
    private MySQLCourseDaoImpl mySQLCourseDao;
    private static Map<String, Command> commands = new TreeMap<String, Command>();

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        servletContextEvent.getServletContext().setAttribute("userService", getUserService());
        servletContextEvent.getServletContext().setAttribute("courseService", getCourseService());
        servletContextEvent.getServletContext().setAttribute("userDao", getMySQLUserDao());
        servletContextEvent.getServletContext().setAttribute("courseDao", getMySQLCourseDao());
        servletContextEvent.getServletContext().setAttribute("commands", getCommandContainer());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    public Map<String, Command> getCommandContainer() {
        // common commands
        commands.put("login", new LoginCommand());
        commands.put("logout", new LogoutCommand());
        commands.put("viewSettings", new ViewSettingsCommand());
        commands.put("noCommand", new NoCommand());
        commands.put("signUp",new SignUpCommand());

        // student commands
        commands.put("listSchedule", new ViewStudentListScheduleCommand());
        commands.put("progressingCourses", new ListStartedCourses());
        commands.put("finishedCourses", new ListFinishedCourses());
        commands.put("pendingCourses", new ListPendingCourses());

        // admin commands
        commands.put("listOrders", new ListAdminCommand());




        //teacher commands
        commands.put("listCourses", new ListCoursesCommand());

        //LOG.debug("Command container was successfully initialized");
        //LOG.trace("Number of commands --> " + commands.size());
        return commands;
    }

    public UserServiceImpl getUserService() {
        if (userService == null) {
            userService = new UserServiceImpl(getMySQLUserDao(), getCourseService());
        }
        return userService;
    }

    public CourseServiceImpl getCourseService() {
        if (courseService == null) {
            courseService = new CourseServiceImpl(getMySQLCourseDao());
        }
        return courseService;
    }

    public MySQLUserDaoImpl getMySQLUserDao() {
        if (mySQLUserDao == null) {
            mySQLUserDao = new MySQLUserDaoImpl();
        }
        return mySQLUserDao;
    }

    public MySQLCourseDaoImpl getMySQLCourseDao() {
        if (mySQLCourseDao == null) {
            mySQLCourseDao = new MySQLCourseDaoImpl();
        }
        return mySQLCourseDao;
    }
}
