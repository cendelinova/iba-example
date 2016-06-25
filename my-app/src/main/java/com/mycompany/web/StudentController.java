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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Petra
 */
@Controller
public class StudentController {

    StudentService service = new StudentServiceListImpl();

    @RequestMapping(value = "/student/add", method = RequestMethod.GET)
    public String showAddForm(ModelMap model) {
        model.addAttribute("studentForm", new Student());
        return "studentForm";
    }

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public String showAllStudents(ModelMap model) {
        List<Student> students = service.getAllStudents();

        model.addAttribute("students", students);
        return "students";
    }

    @RequestMapping(value = "/student/add", method = RequestMethod.POST)
    public String addStudent(@Valid @ModelAttribute("studentForm") Student student, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "studentForm";
        } else {
            service.addStudent(student);
            //model.addAttribute("message", "Student added successfully");
            /*
                model.addAttribute("message", "Student added successfully");
                model.addAttribute("student", student);
                return "result";
             */
            return "redirect:/student/";

        }
    }

    @RequestMapping(value = "/student/{id}/update", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable("id") long id, Model model) {

        Student student = service.findStudentById(id);
        model.addAttribute("studentForm", student);
        return "studentForm";

    }

    @RequestMapping(value = "/student/{id}/update", method = RequestMethod.POST)
    public String updateStudent(@ModelAttribute("studentForm") @Valid Student student,
            BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "studentForm";
        } else {
            service.updateStudent(student);
            /*redirectAttributes.addFlashAttribute("css", "success");
			if(user.isNew()){
				redirectAttributes.addFlashAttribute("msg", "User added successfully!");
			}else{
				redirectAttributes.addFlashAttribute("msg", "User updated successfully!");
			}*/
            return "redirect:/student";

        }
    }

    @RequestMapping(value = "/student/{id}/detail", method = RequestMethod.GET)
    public String showStudent(@PathVariable("id") long id, Model model) {

        Student student = service.findStudentById(id);
        /*if (user == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "User not found");
		}*/
        model.addAttribute("student", student);

        return "detail";

    }
    
    @RequestMapping(value = "/student/{id}/delete", method = RequestMethod.GET)
	public String deleteUser(@PathVariable("id") long id) {

		service.deleteStudent(id);
		
		return "redirect:/student";

	}

}


