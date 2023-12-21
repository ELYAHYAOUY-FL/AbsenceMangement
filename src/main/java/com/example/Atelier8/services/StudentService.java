package com.example.Atelier8.services;

import com.example.Atelier8.persistence.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    public void save(Student student);
    public void delete(Student student);
    public List<Student> getAll();
    public Optional<Student> getOne(Long id );
}
