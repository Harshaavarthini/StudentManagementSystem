package com.CRUD.studentManagementSystem.Controller;

import com.CRUD.studentManagementSystem.Entity.Student;
import com.CRUD.studentManagementSystem.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class studentManagementSystemController {
    private  StudentService studentService;

    @Autowired
    public studentManagementSystemController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String fetchStudents(Model model){
        model.addAttribute("students",studentService.fetchStudents());
        return "students";
    }

    @GetMapping("/students/new")
    public String newStudent(Model model){
        Student student = new Student();
        model.addAttribute("student",student);
        return "new_student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/update/{id}")
    public String updateStudent(@PathVariable Long id, Model model){
        model.addAttribute("student",studentService.getById(id));
        return "update";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student){
        studentService.updateStudent(id, student);
        return "redirect:/students";
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}
