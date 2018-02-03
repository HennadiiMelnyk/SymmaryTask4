package ua.nure.melnyk.SummaryTask4.model;

import ua.nure.melnyk.SummaryTask4.dto.CourseDto;

import java.io.Serializable;
import java.util.Objects;

/**
 * Course Model
 *
 *
 *
 */
public class Course implements Serializable {
    private static final long serialVersionUID = -3882420568425907024L;
    private int id;
    private String name;
    private String progress;

    public Course() {

    }

    public Course(String string, String resultSetString) {
    }

    public Course(int id, String name, String progress) {
        this.id = id;
        this.name = name;
        this.progress=progress;
    }

    public Course(CourseDto courseDto) {
        this.id = courseDto.getId();
        this.name = courseDto.getName();
        this.progress=courseDto.getProgress();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        Course course = (Course) o;
        return id == course.id &&
                Objects.equals(name, course.name) &&
                Objects.equals(progress, course.progress);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, progress);
    }
}
