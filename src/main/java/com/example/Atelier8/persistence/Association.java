package com.example.Atelier8.persistence;

import jakarta.persistence.*;

@Entity
@Table(name = "student_seance")
public class Association {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public void setSeance(Seance seance) {
        this.seance = seance;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Seance getSeance() {
        return seance;
    }

    public Long getId() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "seance_id")
    private Seance seance;

    private Status stat ;
}
