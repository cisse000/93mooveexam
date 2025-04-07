package com.example.demo.service;

import com.example.demo.model.Adherent;
import com.example.demo.repository.AdherentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AdherentService {
    @Autowired
    private AdherentRepository adherentRepository;

    public List<Adherent> getAllAdherents() {
        Iterable<Adherent> adherents = adherentRepository.findAll();
        return StreamSupport.stream(adherents.spliterator(), false)
                .collect(Collectors.toList());
    }

    public Adherent createAdherent(Adherent adherent) {
        return adherentRepository.save(adherent);
    }

    public Adherent getAdherentById(Integer id) {
        return adherentRepository.findById(id).orElse(null);
    }
}
