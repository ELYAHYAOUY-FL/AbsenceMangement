package com.example.Atelier8.services;

import com.example.Atelier8.persistence.Seance;
import com.example.Atelier8.repository.SeanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SeanceServiceImplimentation implements SeanceService {
    @Autowired
    SeanceRepository seanceRepository;
    @Override
    public void save(Seance seance) {
        seanceRepository.save(seance);
    }
    @Override
    public void delete(Seance seance) {
        seanceRepository.delete(seance);
    }

    @Override
    public List<Seance> getAll() {
        return seanceRepository.findAll();
    }
    @Override
    public Optional<Seance> getOne(Long id) {
        return seanceRepository.findById(id);
    }

}
