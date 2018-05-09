package com.sample.spring.SampleSpring.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Document
public class Course implements Serializable {

    @Id
    String course_id;
    String course_name;
    String course_description;
    List<String> completion_steps;

    public Course() {
    }

    public Course(String course_id, String course_name, String course_description, List<String> completion_steps) {
        super();
        this.course_id = course_id;
        this.course_name = course_name;
        this.course_description = course_description;
        this.completion_steps = completion_steps;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
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
        return Objects.equals(course_id, course.course_id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(course_id, course_name, course_description, completion_steps);
    }

    @Override
    public String toString() {
        return "Course{" +
                "course_id='" + course_id + '\'' +
                ", course_name='" + course_name + '\'' +
                ", course_description='" + course_description + '\'' +
                ", completion_steps=" + completion_steps +
                '}';
    }
}
