package com.example.Atelier8.services;
import com.example.Atelier8.persistence.Student;
import com.example.Atelier8.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class StudentServiceImplimentation implements StudentService{
    @Autowired
    StudentRepository studentRepository;
    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }
    @Override
    public void delete(Student student) {
        studentRepository.delete(student);
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }
    @Override
    public Optional<Student> getOne(Long id) {
        return studentRepository.findById(id);
    }

}
