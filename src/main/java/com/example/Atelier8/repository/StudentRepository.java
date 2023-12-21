package com.example.Atelier8.repository;
import com.example.Atelier8.persistence.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
