package com.catninja007.testbe.usecase.student.service;

import com.catninja007.testbe.common.exception.DataNotFoundExceptions;
import com.catninja007.testbe.entity.Student;
import com.catninja007.testbe.usecase.student.dto.StudentDto;
import com.catninja007.testbe.usecase.student.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public Student createStudent(StudentDto studentDto){
        Student student = new Student();
        student.setFullname(studentDto.getFullname());
        student.setEmail(studentDto.getEmail());
        student.setAge(studentDto.getAge());
        student.setFaculty(studentDto.getFaculty());
        student.setDateOfBirth(studentDto.getDateOfBirth());

        return studentRepository.save(student);
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student getStudentById(Integer id){
        Student findStudent = studentRepository.findById(id).orElseThrow(() -> new DataNotFoundExceptions("Student with ID " + id + " not found"));
        return findStudent;
    }

    public Student updateStudent(Integer id, StudentDto studentDto){
        Student findStudent = studentRepository.findById(id).orElseThrow(() -> new DataNotFoundExceptions("Student with ID " + id + " not found"));
        findStudent.setFullname(studentDto.getFullname());
        findStudent.setEmail(studentDto.getEmail());
        findStudent.setAge(studentDto.getAge());
        findStudent.setFaculty(studentDto.getFaculty());
        findStudent.setDateOfBirth(studentDto.getDateOfBirth());
        return studentRepository.save(findStudent);
    }

    public void deleteStudent(Integer id){
        Student findStudent = studentRepository.findById(id).orElseThrow(() -> new DataNotFoundExceptions("Student with ID " + id + " not found"));
        studentRepository.delete(findStudent);
    }
}
