package ua.nure.melnyk.SummaryTask4.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ua.nure.melnyk.SummaryTask4.dao.entitydao.UserDao;
import ua.nure.melnyk.SummaryTask4.exceptions.DBException;
import ua.nure.melnyk.SummaryTask4.model.User;
import ua.nure.melnyk.SummaryTask4.service.CourseService;
import ua.nure.melnyk.SummaryTask4.service.ImplService.UserServiceImpl;
import ua.nure.melnyk.SummaryTask4.service.UserService;

import java.sql.SQLException;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @Mock
    private UserDao userDao;

    @Mock
    private CourseService courseService;

    @Mock
    private User testUser;

    private UserService userService;

    @Before
    public void setUp() {
        userService = new UserServiceImpl(userDao, courseService);
    }

    @Test
    public void testRegisterUser_ShouldRegisterNewUser_TrueIfRegistrationIsSuccess() throws DBException, SQLException {
        when(userDao.create(testUser)).thenReturn(true);
        userService.createUser(testUser);
        verify(userDao).create(testUser);
    }
}
