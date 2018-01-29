package ua.nure.melnyk.SummaryTask4.Const;

/**
 * Path holder (jsp pages, controller commands).
 *
 *
 *
 */
public final class Path {
    // pages
    public static final String PAGE_LOGIN = "/login.jsp";
    public static final String PAGE_ERROR_PAGE = "/WEB-INF/jsp/error_page.jsp";
    public static final String PAGE_LIST_SCHEDULE = "/WEB-INF/jsp/client/list_schedule.jsp";
    public static final String PAGE_LIST_COURSES = "/WEB-INF/jsp/admin/list_courses.jsp";
    public static final String PAGE_LIST_

    public static final String PAGE_SETTINGS = "/WEB-INF/jsp/settings.jsp";

    // commands
    public static final String COMMAND_LIST_ORDERS = "/controller?command=listOrders";
    public static final String COMMAND_LIST_COURSES = "/controller?command=listCourses";
    public static final String COMMAND_LIST_SCHEDULE="/controller?command=listSchedule";
}
