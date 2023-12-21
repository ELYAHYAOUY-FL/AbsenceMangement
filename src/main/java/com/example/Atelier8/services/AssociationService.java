package com.example.Atelier8.services;

import com.example.Atelier8.persistence.Association;

import java.util.List;
import java.util.Optional;

public interface AssociationService {
    public void save(Association association);
    public void delete(Association association);
    public List<Association> getAll();
    public Optional<Association> getOne(Long id );
}
