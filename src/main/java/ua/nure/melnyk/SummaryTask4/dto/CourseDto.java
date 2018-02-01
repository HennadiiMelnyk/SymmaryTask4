package ua.nure.melnyk.SummaryTask4.dto;

import ua.nure.melnyk.SummaryTask4.model.Course;

import java.util.Objects;

/**
 * Course Data transfer object
 *
 *
 *
 */
public class CourseDto {


    private int id;
    private String name;
    private String progress;

    public CourseDto() {

    }

    public CourseDto(Course course) {
        this.id = course.getId();
        this.name = course.getName();
        this.progress = course.getProgress();

    }

    public CourseDto(int id, String name, String progress) {
        this.id = id;
        this.name = name;
        this.progress = progress;
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

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseDto courseDto = (CourseDto) o;
        return id == courseDto.id &&
                Objects.equals(name, courseDto.name) &&
                Objects.equals(progress, courseDto.progress);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, progress);
    }
}
