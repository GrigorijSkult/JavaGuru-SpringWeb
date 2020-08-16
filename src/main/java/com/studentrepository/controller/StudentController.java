package com.studentrepository.controller;

import com.studentrepository.dto.StudentDto;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/students")
public class StudentController {

    @GetMapping
    public StudentDto findAllStudents() {
        return new StudentDto(
                UUID.randomUUID().toString(),
                "Test_Student_Anderej",
                "Test_Student_Senjonov"
        );
    }

    @GetMapping("/{id}")
    public StudentDto findStudentById(@PathVariable String id) {
        System.out.println("Received request of student with id " + id);
        return new StudentDto(
                id,
                "Test_Student_Anderej",
                "Test_Student_Senjonov"
        );
    }

    @PostMapping
    public void createStudent(@RequestBody StudentDto newStudentDto){
        System.out.println("Received request, add new student " + newStudentDto);
    }

    @PutMapping("/{id}")
    public void updateStudent(@PathVariable String id, @RequestBody StudentDto updatedStudentDto){
        System.out.println("Received request, update for student with ID " + id);
        System.out.println("Received request, student updated" + updatedStudentDto);
    }
}
