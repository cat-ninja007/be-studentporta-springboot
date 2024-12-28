package com.catninja007.testbe.usecase.student.repository;

import com.catninja007.testbe.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
