package com.catninja007.testbe.usecase.student.dto;

import com.catninja007.testbe.entity.Student;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;


import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class StudentDto {

    @NotNull
    @Size(max = 100)
    private String fullname;


    @NotNull
    @Size(max = 100)
    private String email;

    @NotNull
    private LocalDate dateOfBirth;

    @NotNull
    private Integer age;

    @NotNull
    @Size(max = 100)
    private String faculty;
}