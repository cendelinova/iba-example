package com.mycompany.service;

import com.mycompany.model.Gender;
import com.mycompany.model.Student;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Petra
 */
public class StudentServiceTest {

    private static StudentService service;
    private long index = 0;
    
    public StudentServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        service = new StudentServiceListImpl();

    }

    @After
    public void tearDown() {
    }

    @Test
    public void emptyList() {
        assertEquals(0, service.getAllStudents().size());
    }

    @Test
    public void addStudent() {
        Student student = new Student();
        
        
        student.setName("ivona");
        student.setSurname("stara");
        student.setBirthday(new Date(1992,11,2));
        student.setGender(Gender.FEMALE);
        

        service.addStudent(student);
        index = student.getId();
        
        assertEquals(1, service.getAllStudents().size());
        assertEquals(student.getId(), service.findStudentById(index).getId());
        assertEquals(student.getName(), service.findStudentById(index).getName());
        assertEquals(student.getSurname(), service.findStudentById(index).getSurname());
        assertEquals(student.getBirthday(), service.findStudentById(index).getBirthday());
        assertEquals(student.getGender(), service.findStudentById(index).getGender());
    }

    @Test
    public void deleteStudent() {
        Student student = new Student();

        student.setName("petr");
        student.setSurname("novy");
        student.setBirthday(new Date(1996,11,2));
        student.setGender(Gender.MALE);

        service.addStudent(student);
        index = student.getId();
         
        assertEquals(1, service.getAllStudents().size());
        assertEquals(student.getId(), service.findStudentById(index).getId());
        assertEquals(student.getName(), service.findStudentById(index).getName());
        assertEquals(student.getSurname(), service.findStudentById(index).getSurname());
        assertEquals(student.getBirthday(), service.findStudentById(index).getBirthday());
        assertEquals(student.getGender(), service.findStudentById(index).getGender());

        service.deleteStudent(student.getId());

        assertEquals(0, service.getAllStudents().size());
    }

    @Test
    public void getStudent() {
        Student student = new Student();

        student.setName("hana");
        student.setSurname("novotna");
        student.setBirthday(new Date(1998,11,2));
        student.setGender(Gender.FEMALE);

        service.addStudent(student);
        index = student.getId();
        Student studentGet = service.findStudentById(index);

        assertEquals(student.getId(), studentGet.getId());
        assertEquals(student.getName(), studentGet.getName());
        assertEquals(student.getSurname(), studentGet.getSurname());
        assertEquals(student.getBirthday(), studentGet.getBirthday());
        assertEquals(student.getGender(), studentGet.getGender());
        
    }

    @Test
    public void updateStudent() {
        Student student = new Student();

        student.setName("eva");
        student.setSurname("novakova");
        student.setGender(Gender.FEMALE);
        student.setBirthday(new Date(2005,12,06));

        service.addStudent(student);
        index = student.getId();
        
        Student updatedStudent = new Student();

        updatedStudent.setId(index);
        updatedStudent.setName("nora");
        updatedStudent.setSurname("zimova");
        updatedStudent.setGender(Gender.FEMALE);
        updatedStudent.setBirthday(new Date(2003,12,06));

        service.updateStudent(updatedStudent);

        assertEquals(student.getId(), updatedStudent.getId());
        assertNotEquals(student.getName(), updatedStudent.getName());
        assertNotEquals(student.getSurname(), updatedStudent.getSurname());
        assertNotEquals(student.getBirthday(), updatedStudent.getBirthday());
        assertEquals(student.getGender(), updatedStudent.getGender());
    }
}
