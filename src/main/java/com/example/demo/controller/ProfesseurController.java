package com.example.demo.controller;

import com.example.demo.model.Cours;
import com.example.demo.model.Professeur;
import com.example.demo.repository.ProfesseurRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/professeurs")
public class ProfesseurController {
    private List<Professeur> listeProfesseurs = new ArrayList<>();
    private List<Cours> listeCours = new ArrayList<>();


    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Professeur ajouterProfesseur(@RequestBody Professeur professeur) {
        listeProfesseurs.add(professeur);
        return professeur;
    }


    @GetMapping
    public List<Professeur> getListeProfesseurs() {
        return listeProfesseurs;
    }


    @PostMapping("/{professeurId}/cours")
    public Cours ajouterCours(@PathVariable Integer professeurId, @RequestBody Cours cours) {

        for (Professeur professeur : listeProfesseurs) {
            if (professeur.getId().equals(professeurId)) {
                listeCours.add(cours);
                return cours;
            }
        }
        return null;
    }


    @GetMapping("/cours")
    public List<Cours> getListeCours() {
        return listeCours;
    }
}
