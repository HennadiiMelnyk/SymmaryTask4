package ua.nure.melnyk.SummaryTask4.service.ImplService;


import com.google.api.services.gmail.model.Message;
import ua.nure.melnyk.SummaryTask4.Const.Path;
import ua.nure.melnyk.SummaryTask4.dao.entitydao.UserDao;
import ua.nure.melnyk.SummaryTask4.exceptions.CustomException;
import ua.nure.melnyk.SummaryTask4.exceptions.DBException;
import ua.nure.melnyk.SummaryTask4.model.Schedule;
import ua.nure.melnyk.SummaryTask4.model.User;
import ua.nure.melnyk.SummaryTask4.service.CourseService;
import ua.nure.melnyk.SummaryTask4.service.UserService;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

import static ua.nure.melnyk.SummaryTask4.model.Role.ADMIN;
import static ua.nure.melnyk.SummaryTask4.model.Role.STUDENT;
import static ua.nure.melnyk.SummaryTask4.model.Role.TEACHER;

/**
 * User Service
 * Business logic
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private CourseService courseService;

    public UserServiceImpl(UserDao userDao, CourseService courseService) {
        this.userDao = userDao;
        this.courseService = courseService;
    }

    @Override
    public boolean registerUser(User user) throws DBException, SQLException {
        userDao.create(user);
        user = new User();
        user.getRole();
        user.getPassword();
        return false;
    }

    @Override
    public User updateUser(int id, User user) throws DBException, SQLException {
        userDao.update(id, user);
        return user;
    }

    @Override
    public User findUserById(int id) throws DBException, SQLException {
        userDao.getById(id);
        return userDao.getById(id);
    }

    @Override
    public boolean deleteUserById(int id) throws DBException, SQLException {

        userDao.delete(id);
        return true;
    }

    @Override
    public String login(String email, String password, HttpSession session) throws CustomException, SQLException {
        User user = userDao.getUserByEmail(email);
        String forward = Path.PAGE_ERROR_PAGE;
        if (checkLogin(password, user)) {
            //LOG.trace("Found in DB: user --> " + email);

            if (email == null || !password.equals(user.getPassword())) {
                //Password.hash(password);
                throw new CustomException("Cannot find user with such email/password");
            }

            String userRole = user.getRole();
            //LOG.trace("userRole --> " + userRole);

            if (ADMIN.toString().equals(userRole)) {
                forward = Path.COMMAND_LIST_ORDERS;
            }
            if (STUDENT.toString().equals(userRole)) {
                forward = Path.COMMAND_LIST_SCHEDULE;
            }
            if (TEACHER.toString().equals(userRole)) {
                forward = Path.COMMAND_LIST_COURSES;
            }

            session.setAttribute("user", user);
            //LOG.trace("Set the session attribute: user --> " + user);

            session.setAttribute("userRole", userRole);
            //LOG.trace("Set the session attribute: userRole --> " + userRole);

            //LOG.info("User " + user + " logged as " + userRole.toString().toLowerCase());
        }
        return forward;

    }

    private boolean checkLogin(String password, User user) {
        return user.getPassword().equals(password);
    }

    @Override
    public List<Schedule> getAllCoursesByUser(User user) throws DBException, SQLException {
        List<Schedule> courses = userDao.getAllCoursesByUser(user);
        return courses;
    }

    @Override
    public List<Schedule> getStartedCoursesByUser(User user) throws DBException, SQLException {
        List<Schedule> courses = userDao.getStartedCoursesByUser(user);
        /*List<ScheduleDto> scheduleDtos = new ArrayList<>();
        courses.stream().forEach(schedule -> {
            ScheduleDto scheduleDto = new ScheduleDto();
            scheduleDto.setId(schedule.getId());
            try {
                scheduleDto.setCourse(courseService.getById(schedule.getCourse()).getName());
            } catch (DBException | SQLException e) {
                e.printStackTrace();
            }
            scheduleDto.setUser(user.getName());
            scheduleDto.setMark(schedule.getMark());
            scheduleDto.setProgress(schedule.getProgress());
            scheduleDtos.add(scheduleDto);
        });*/
        return courses;
    }

    @Override
    public List<Schedule> getPendingCoursesByUser(User user) throws DBException, SQLException {
        List<Schedule> courses = userDao.getPendingCoursesByUser(user);
        /*List<ScheduleDto> scheduleDtos = new ArrayList<>();
        courses.stream().forEach(schedule -> {
            ScheduleDto scheduleDto = new ScheduleDto();
            scheduleDto.setId(schedule.getId());
            try {
                scheduleDto.setCourse(courseService.getById(schedule.getCourse()).getName());
            } catch (DBException | SQLException e) {
                e.printStackTrace();
            }
            scheduleDto.setUser(user.getName());
            scheduleDto.setMark(schedule.getMark());
            scheduleDto.setProgress(schedule.getProgress());
            scheduleDtos.add(scheduleDto);
        });*/
        return courses;
    }

    @Override
    public List<Schedule> getFinishedCoursesByUser(User user) throws DBException, SQLException {
        List<Schedule> courses = userDao.getFinishedCoursesByUser(user);
        /*List<ScheduleDto> scheduleDtos = new ArrayList<>();
        courses.stream().forEach(schedule -> {
            ScheduleDto scheduleDto = new ScheduleDto();
            scheduleDto.setId(schedule.getId());
            try {
                scheduleDto.setCourse(courseService.getById(schedule.getCourse()).getName());
            } catch (DBException | SQLException e) {
                e.printStackTrace();
            }
            scheduleDto.setUser(user.getName());
            scheduleDto.setMark(schedule.getMark());
            scheduleDto.setProgress(schedule.getProgress());
            scheduleDtos.add(scheduleDto);
        });*/
        return courses;
    }

    @Override
    public User createUser(User user) throws DBException, SQLException {
        userDao.create(user);
        return user;
    }

    @Override
    public Message sendMessage() {

        //SendMailCommand.sendMessage();
        // return Message;
        return null;
    }
}