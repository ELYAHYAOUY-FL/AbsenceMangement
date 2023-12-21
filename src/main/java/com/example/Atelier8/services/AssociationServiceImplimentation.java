package com.example.Atelier8.services;

import com.example.Atelier8.persistence.Association;
import com.example.Atelier8.repository.AssociationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AssociationServiceImplimentation implements AssociationService{
    @Autowired
    AssociationRepository associationRepository;
    @Override
    public void save(Association association) {
        associationRepository.save(association);
    }
    @Override
    public void delete(Association association) {
        associationRepository.delete(association);
    }

    @Override
    public List<Association> getAll() {
        return associationRepository.findAll();
    }
    @Override
    public Optional<Association> getOne(Long id) {
        return associationRepository.findById(id);
    }
}
