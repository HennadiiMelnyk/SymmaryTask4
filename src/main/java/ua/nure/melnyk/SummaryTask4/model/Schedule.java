package ua.nure.melnyk.SummaryTask4.model;

import ua.nure.melnyk.SummaryTask4.dto.ScheduleDto;

import java.io.Serializable;
import java.util.Objects;

/**
 * Schedule Model
 *
 *
 *
 */
public class Schedule implements Serializable {
    private static final long serialVersionUID = 2295848915937522983L;
    private int id;
    private int idUser;
    private int courseName;
    private int mark;
    private String progress;
    public Schedule() {
    }

    public Schedule(int id, int mark) {
        this.id = id;
        this.mark = mark;
    }

    public Schedule(ScheduleDto scheduleDto) {
        this.id = scheduleDto.getId();
        this.mark = scheduleDto.getMark();

    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getCourseName() {
        return courseName;
    }

    public void setCourseName(int courseName) {
        this.courseName = courseName;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return id == schedule.id &&
                mark == schedule.mark;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, mark);
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
}
