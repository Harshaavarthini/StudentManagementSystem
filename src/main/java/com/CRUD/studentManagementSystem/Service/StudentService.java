package com.CRUD.studentManagementSystem.Service;

import com.CRUD.studentManagementSystem.Entity.Student;

import java.util.List;

public interface StudentService  {


    List<Student> fetchStudents();

    Student saveStudent(Student student);

    Student getById(Long id);

    Student updateStudent(Long id, Student student);

    void deleteStudent(Long id);
}
