package com.CRUD.studentManagementSystem.Service;

import com.CRUD.studentManagementSystem.Entity.Student;
import com.CRUD.studentManagementSystem.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StudentServiceImplementation implements StudentService{

    private StudentRepository repo;

    @Autowired
    public StudentServiceImplementation(StudentRepository repo) {
        this.repo = repo;
    }
    @Override
    public List<Student> fetchStudents() {
        return repo.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return repo.save(student);
    }

    @Override
    public Student getById(Long id) {
        return repo.findById(id).get();
    }
    @Override
    public Student updateStudent(Long id, Student student) {
        Student update = repo.findById(id).get();
        if(Objects.nonNull(student.getFirstname()) && !"".equalsIgnoreCase(student.getFirstname())){
            update.setFirstname(student.getFirstname());
        }

        if(Objects.nonNull(student.getLastname()) && !"".equalsIgnoreCase(student.getLastname())){
            update.setLastname(student.getLastname());
        }

        if(Objects.nonNull(student.getEmail()) && !"".equalsIgnoreCase(student.getEmail())){
            update.setEmail(student.getEmail());
        }
        return repo.save(update);
    }

    @Override
    public void deleteStudent(Long id) {
        repo.deleteById(id);
    }

}
