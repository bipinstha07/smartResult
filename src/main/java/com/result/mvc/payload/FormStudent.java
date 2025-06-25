package com.result.mvc.payload;

import com.result.mvc.entities.Marks;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FormStudent {

    private String name;
    private String rollNumber;
    private String email;
    private String  grade;
    private LocalDate dateOfBirth;
    private String gender;
    private String address;

    private List<formMarks> subjects = new ArrayList<>();

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public List<formMarks> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<formMarks> subjects) {
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }
}
