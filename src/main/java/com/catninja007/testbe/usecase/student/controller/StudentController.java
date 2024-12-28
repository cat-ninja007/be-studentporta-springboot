package com.catninja007.testbe.usecase.student.controller;

import com.catninja007.testbe.common.response.ApiResponse;
import com.catninja007.testbe.entity.Student;
import com.catninja007.testbe.usecase.student.dto.StudentDto;
import com.catninja007.testbe.usecase.student.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Get All Student
    @GetMapping
    public ResponseEntity<?> getAllStudents(){
        return ApiResponse.success("Success get all student", studentService.getAllStudents());
    }

    // Get Single Student
    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Integer id){
        return ApiResponse.success("Success get student", studentService.getStudentById(id));
    }

    // Update Single Student
    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Integer id, @RequestBody StudentDto studentDto){
        return ApiResponse.success("Success update student", studentService.updateStudent(id, studentDto));
    }

    // Delete Single Student
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);
        return ApiResponse.success("Success delete student");
    }


    @PostMapping("/create")
//    public Student createStudent(@RequestBody StudentDto studentDto){
    public ResponseEntity<?> createStudent(@RequestBody StudentDto studentDto){
//        return studentService.createStudent(studentDto);
        return ApiResponse.success("Success create student", studentService.createStudent(studentDto));
    }





}
