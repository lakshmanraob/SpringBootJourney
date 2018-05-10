package com.sample.spring.SampleSpring.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Document
public class Course {

    @Id
    private String courseId;
    private String course_name;
    private String course_description;
    private List<String> completion_steps;

    public Course() {
    }

    public Course(String course_id, String course_name, String course_description, List<String> completion_steps) {
        super();
        this.courseId = course_id;
        this.course_name = course_name;
        this.course_description = course_description;
        this.completion_steps = completion_steps;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourse_id(String courseId) {
        this.courseId = courseId;
    }

    public String getCourse_name() {
        return course_name;
    }

    public String getCourse_description() {
        return course_description;
    }


    public List<String> getCompletion_steps() {
        return completion_steps;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(courseId, course.courseId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(courseId, course_name, course_description, completion_steps);
    }

    @Override
    public String toString() {
        return "Course{" +
                "course_id='" + courseId + '\'' +
                ", course_name='" + course_name + '\'' +
                ", course_description='" + course_description + '\'' +
                ", completion_steps=" + completion_steps +
                '}';
    }
}
