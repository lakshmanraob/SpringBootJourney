package com.sample.spring.SampleSpring.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Document
public class Student implements Serializable {

    @Id
    String id;
    String name;
    String description;
    List<Course> enrolled_courses;

    public Student(String id, String name, String description, List<Course> enrolled_courses) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.enrolled_courses = enrolled_courses;
    }

    public Student() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Course> getEnrolled_courses() {
        return enrolled_courses;
    }

    public void setEnrolled_courses(List<Course> enrolled_courses) {
        this.enrolled_courses = enrolled_courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", enrolled_courses=" + enrolled_courses +
                '}';
    }
}
