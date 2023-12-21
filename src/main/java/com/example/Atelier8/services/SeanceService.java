package com.example.Atelier8.services;

import com.example.Atelier8.persistence.Seance;

import java.util.List;
import java.util.Optional;

public interface SeanceService {
    public void save(Seance seance);
    public void delete(Seance seance);
    public List<Seance> getAll();
    public Optional<Seance> getOne(Long id );
}
