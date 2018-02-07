package ua.nure.melnyk.SummaryTask4.Const;

public final class SQLQuery {

    //Courses constant
    public static final String SQL_GET_ALL_COURSE_BY_USER = "SELECT c.id, c.name, s.mark, s.progress FROM schedule s JOIN course c ON s.id_course = c.id " +
            "JOIN users_courses u ON c.id = u.id_course " +
            "JOIN users u2 ON u.id_user = u2.id " +
            "WHERE u2.id = ?";
    public static final String SQL_GET_STARTED_COURSES_BY_USER = "SELECT * FROM schedule WHERE id_user=? AND progress='Started'";
    public static final String SQL_GET_PENDING_COURSES_BY_USER = "SELECT * FROM schedule WHERE id_user=? AND progress='Pending'";
    public static final String SQL_GET_FINISHED_COURSES_BY_USER = "SELECT * FROM schedule WHERE id_user=? AND progress='Finished'";
    public static final String SQL_SORTED_BY_ASC = "SELECT * FROM course ORDER BY ASC";
    public static final String SQL_SORTED_BY_DESC = "SELECT * FROM course ORDER BY DESC";
    public static final String SQL_CREATE_COURSE = "INSERT INTO course VALUES(DEFAULT, ?)";
    public static final String SQL_GET_COURSES_BY_TEACHER = "SELECT * FROM course WHERE course.id in"
            + "(SELECT course.id FROM users WHERE id_role=2)";
    public static final String SQL_UPDATE_COURSE = "UPDATE course SET id=?, name=?,progress=?";
    public static final String SQL_UPDATE_COURSE_BY_ID = "UPDATE course SET name=?, progress=? WHERE id=?";
    public static final String SQL_SELECT_USER_BY_ID = "SELECT * FROM users WHERE id=?";
    public static final String SQL_UPDATE_USER_BY_ID = "UPDATE users WHERE id=?";
    public static final String SQL_SELECT_COURSE_BY_ID = "SELECT * FROM course WHERE id=?";
    public static final String SQL_DELETE_COURSE_BY_ID = "DELETE FROM course WHERE id=?";


    //Users constant
    public static final String SQL_CREATE_USER = "INSERT INTO users VALUES(DEFAULT, ?)";
    public static final String SQL_GET_USER_BY_EMAIL = "SELECT * FROM users WHERE email=?";
    public static final String SQL_DELETE_USER_BY_ID = "DELETE FROM users WHERE id=?";
    public static final String SQL_FIND_ALL_USERS = "SELECT * FROM users";
    public static final String SQL_INSERT_USER = "INSERT INTO users VALUES (DEFAULT, ?, ?)";
    public static final String SQL_UPDATE_USER = "UPDATE user SET name=? WHERE id=?";
    public static final String SQL_SELECT_ALL_USERS="SELECT * FROM users";

    //Column indexes
    public static final int SQL_NAME_COLUMN_INDEX = 1;
    public static final int SQL_PASSWORD_COLUMN_INDEX = 3;
    public static final int SQL_EMAIL_COLUMN_INDEX = 2;
    public static final int SQL_STATUS_COLUMN_INDEX = 5;
    public static final int SQL_PROGRESS_COLUMN_INDEX = 3;


}
