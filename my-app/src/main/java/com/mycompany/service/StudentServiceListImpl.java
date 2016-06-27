/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.model.Student;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Petra
 */
public class StudentServiceListImpl implements StudentService {

    private final List<Student> students;
    private static long id = 0;

    public StudentServiceListImpl() {
        this.students = new ArrayList();
    }

    @Override
    public void addStudent(Student student) {
        validateNull(student);
        //if (findStudentById(student.getId()) != null) throw new IllegalArgumentException("Student already exists"); 

        student.setId(++id);
        students.add(student);
    }

    @Override
    public void deleteStudent(long id) {
        //validateNull(student);
        students.removeIf(s -> s.getId() == id);
    }

    @Override
    public List<Student> getAllStudents() {
        return Collections.synchronizedList(students);
    }

    @Override
    public void updateStudent(Student student) {
        validateNull(student);
        existsStudent(student.getId());
        Student s = findStudentById(student.getId());
        
        int i = students.indexOf(s);
        students.set(i, student);
  
    }

    @Override
    public Student findStudentById(Long id
    ) {
        for (Student s : getAllStudents()) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    private void validateNull(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student is null");
        }
    }

    private void existsStudent(Long id) {
        if (findStudentById(id) == null) {
            throw new IllegalArgumentException("Student does not exist");
        }

    }
}
