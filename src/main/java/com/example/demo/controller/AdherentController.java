package com.example.demo.controller;


import com.example.demo.model.Adherent;
import com.example.demo.repository.AdherentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//cette classe restcontroller va gérer les requêtes HTTP et répondre et appelle le Service
@RestController

public class AdherentController {

    //autowired Permet d'injecter automatiquement les dépendances de Spring
    @Autowired
    private AdherentRepository adherentRepository;

    //Indique que les requêtes http iront vers la fonction suivante. Ici le "/" signifie la racine.
    //Cette méthode est utilisée pour récupérer tous les adhérents de la base de données.
    //Elle retourne une liste d'objets Adherent sous forme
    @GetMapping("/adherent")
    public List<Adherent> getAllAdherents() {
        return (List<Adherent>) adherentRepository.findAll();
    }
    
    //Cette méthode permet de créer un nouvel adhérent.
    @PostMapping
    // Seuls les utilisateurs ayant le rôle ROLE_ADMIN peuvent y accéder.
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Adherent createUser(@RequestBody Adherent adherent) {
        return adherentRepository.save(adherent);
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Adherent getAdherentById(@PathVariable Integer id) {
        return adherentRepository.findById(id).orElse(null);
    }


    //Cette méthode permet de mettre à jour un adhérent.
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public Adherent updateAdherent(@PathVariable Integer id, @RequestBody Adherent updatedAdherent) {
        return adherentRepository.findById(id).map(adherent -> {
            adherent.setName(updatedAdherent
                    .getName());
            adherent.setEmail(updatedAdherent.getEmail());
            adherent.setPassword(updatedAdherent.getPassword());
            return adherentRepository.save(adherent);
        }).orElse(null);
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteAdherent(@PathVariable Integer id) {
        adherentRepository.deleteById(id);
    }
}






















