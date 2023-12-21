package com.example.Atelier8.persistence;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Seance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String datedebut;
    private String datefin;
    private String cours;


    @ManyToMany(mappedBy = "seances")
    private Set<Student> students = new HashSet<>();


    public Long getId() {
        return id;
    }

    public String getDatedebut() {
        return datedebut;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDatedebut(String datedebut) {
        this.datedebut = datedebut;
    }

    public void setDatefin(String datefin) {
        this.datefin = datefin;
    }

    public void setCours(String cours) {
        this.cours = cours;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public String getDatefin() {
        return datefin;
    }

    public String getCours() {
        return cours;
    }

    public Set<Student> getStudents() {
        return students;
    }
}
