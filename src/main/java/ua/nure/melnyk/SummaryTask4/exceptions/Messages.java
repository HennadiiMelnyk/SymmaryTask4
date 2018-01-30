package ua.nure.melnyk.SummaryTask4.exceptions;

/**
 * Exception Messages for Log info
 */
public class Messages {
    private Messages() {
        // no op
    }

    public static final String LOG_CREATE_USER_EXCEPTION = "Cannot create a user";

    public static final String LOG_UPDATE_USER_BY_ID_EXCEPTION = "Cannot update data";

    public static final String LOG_GET_USER_BY_ID_EXCEPTION = "Cannot get user by id";

    public static final String LOG_DELETE_USER_BY_ID_EXCEPTION = "Cannot delete user";
    public static final String LOG_DELETE_COURSE_BY_ID_EXCEPTION = "Cannot delete course";

    public static final String LOG_GET_CONNECTION_EXCEPTION="Cannot get connection";

    public static final String LOG_EXECUTION_EXCEPTION = "Cannot Execute";

    public static final String LOG_COMMIT_EXCEPTION = "Cannot commit";

    public static final String LOG_ROLLBACK_EXCEPTION = "Cannot rollback";

    public static final String LOG_CLOSE_EXCEPTION = "Cannot close";

    public static final String LOG_RS_CLOSE_EXCEPTION = "Cannot close result set";

    public static final String LOG_GET_ALL_COURSE_BY_USER_EXCEPTION = "Cannot get course";

    public static final String LOG_GET_FINISHED_COURSES_BY_USER_EXCEPTION = "Cannot get finished course";
    public static final String LOG_GET_PENDING_COURSES_BY_USER_EXCEPTION = "Cannot get pending course";
    public static final String LOG_GET_STARTED_COURSES_BY_USER_EXCEPTION = "Cannot get started course";
    public static final String LOG_SORTED_BY_ASC_EXCEPTION = "Cannot sorted by asc";
    public static final String LOG_SORTED_BY_DESC_EXCEPTION = "Cannot sorted by desc";
    public static final String LOG_UPDATE_COURSE_BY_ID_EXCEPTION = "Cannot update course by id";
    public static final String LOG_UPDATE_COURSE_EXCEPTION = "Cannot update course";
    public static final String LOG_GET_COURSE_BY_ID_EXCEPTION = "Cannot get course by id";
    public static final String LOG_GET_USER_BY_EMAIL_EXCEPTION="Cannot get user by email";
}
