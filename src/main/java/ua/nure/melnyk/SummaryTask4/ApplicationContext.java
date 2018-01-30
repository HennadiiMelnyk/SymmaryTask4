package ua.nure.melnyk.SummaryTask4;

import ua.nure.melnyk.SummaryTask4.service.UserService;

public class ApplicationContext {
    private UserService userService;

    public ApplicationContext(UserService userService) {
        this.userService = userService;
    }
}
