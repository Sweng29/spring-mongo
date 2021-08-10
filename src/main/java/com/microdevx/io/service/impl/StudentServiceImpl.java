package com.microdevx.io.service.impl;

import com.microdevx.io.model.Student;
import com.microdevx.io.repository.StudentRepository;
import com.microdevx.io.service.StudentService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;


    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }


}
