/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.model.Student;
import java.util.List;

/**
 *
 * @author Petra
 */
public interface StudentServiceDao {
    public void addStudent(Student student);
    
    public void deleteStudent(long id);
    
    public void updateStudent(Student student);
    
    public Student findStudentById(Long id);
    
    public List<Student> getAllStudents();
}
