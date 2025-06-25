package com.result.mvc.service;

import com.result.mvc.entities.Marks;
import com.result.mvc.entities.Student;
import com.result.mvc.payload.FormStudent;
import com.result.mvc.repository.ResultRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {

    @Autowired
    private ResultRepo resultRepo;

    public int save(FormStudent student){
        Student saveStudent = new Student();
        int random = (int) (Math.random()*100);
        saveStudent.setId(random);
        saveStudent.setName(student.getName());
        saveStudent.setRollNumber(student.getRollNumber());
        saveStudent.setEmail(student.getEmail());
        saveStudent.setAddress(student.getAddress());
        saveStudent.setGender(student.getGender());
        saveStudent.setGrade(student.getGrade());
        saveStudent.setDateOfBirth(student.getDateOfBirth());

      List<Marks> markStudent = student.getSubjects().stream().map(formMarks -> {
            Marks mark = new Marks();
            mark.setMarks(formMarks.getMarks());
            mark.setMaxMarks(formMarks.getMaxMarks());
            mark.setGradeGpa(formMarks.getGradeGpa());
            mark.setSubject(formMarks.getSubject());
            mark.setRemarks(formMarks.getRemarks());
            mark.setStudent(saveStudent);
            return mark;
        }).toList();

    saveStudent.setMarks(markStudent);

    resultRepo.save(saveStudent);
    return random;
    }

    public Student find(String rollNumber){
        System.out.println("RolNumber: "+ rollNumber);
        return resultRepo.findByRollNumber(rollNumber);
    }

}
