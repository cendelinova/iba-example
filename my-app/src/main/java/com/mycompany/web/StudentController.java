/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.web;

import com.mycompany.model.Gender;
import com.mycompany.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Petra
 */
@Controller
public class StudentController {

    @RequestMapping(value = "/student/add", method = RequestMethod.GET)
    public String showForm(ModelMap model) {
        model.addAttribute("studentForm", new Student());
        //model.addAttribute("gender", Gender.values());
        return "add";
    }

    @RequestMapping(value = "/student/result", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("studentForm") Student student,
            ModelMap model) {
        model.addAttribute("message","Student added successfully");
        model.addAttribute("student",student);
       
        return "result";
    }
}
