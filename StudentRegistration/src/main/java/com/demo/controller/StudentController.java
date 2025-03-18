package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.demo.entity.Student;
import com.demo.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/page")
	public String viewStudents(Model model) {
		List<Student> liststudents = studentService.getAllStudents();
		model.addAttribute("students", liststudents);
		return "page";
	}

	@GetMapping("/index")
	public String addPage(Model model) {
		model.addAttribute("student", new Student());
		return "index";
	}

	@GetMapping("/")
	public String showForm(Model model) {
		model.addAttribute("student", new Student());
		return "index";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("student") Student s) {
		studentService.saveStudent(s);
		return "redirect:/page";
	}

	@RequestMapping("edit/{studentId}")
	public ModelAndView editStudent(@PathVariable(name = "studentId") int id) {

		ModelAndView mv = new ModelAndView("index");
		Student s = studentService.update(id);
		mv.addObject("student", s);
		return mv;

	}

	@RequestMapping("delete/{studentId}")
	public String deleteStudent(@PathVariable(name = "studentId") int id) {
		studentService.deleteStudent(id);
		return "redirect:/";
	}
}
