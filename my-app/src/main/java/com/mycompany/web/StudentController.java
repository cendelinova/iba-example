/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.web;

import com.mycompany.model.Student;
import com.mycompany.service.StudentService;
import com.mycompany.service.StudentServiceListImpl;
import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Petra
 */
@Controller
public class StudentController {
    StudentService service = new StudentServiceListImpl();
    
    @RequestMapping(value = "/student/add", method = RequestMethod.GET)
    public String showForm(ModelMap model) {
        model.addAttribute("studentForm", new Student());
        return "add";
    }
    
    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public String showAllStudents(ModelMap model) {
        List<Student> students = service.getAllStudents();
        
        model.addAttribute("students", students);
        return "students";
    }
    
    @RequestMapping(value = "/student/add",method = RequestMethod.POST)
    public String addStudent(@Valid @ModelAttribute("studentForm") Student student, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add";
        } else {
            service.addStudent(student);
            /*
                model.addAttribute("message", "Student added successfully");
                model.addAttribute("student", student);
                return "result";
            */
            return "redirect:/student/";
            
        }
    }
    
    
}
