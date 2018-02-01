package ua.nure.melnyk.SummaryTask4.dto;

import ua.nure.melnyk.SummaryTask4.model.Schedule;

import java.util.Objects;

/**
 * Schedule Data transfer object
 */
public class ScheduleDto {
    private int id;
    private String course;
    private String user;
    private int mark;
    private String progress;

    public ScheduleDto() {

    }

    public ScheduleDto(Schedule schedule) {
        this.id = schedule.getId();
        this.mark = schedule.getMark();

    }

    public ScheduleDto(int id, int mark) {
        this.id = id;
        this.mark = mark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScheduleDto that = (ScheduleDto) o;
        return id == that.id &&
                mark == that.mark;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, mark);
    }
}

