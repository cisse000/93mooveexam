package com.example.demo.controller;
/*import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

@RestController
public class CoursController {
    // private static final String template = "Hello, %s!";
    //private final AtomicLong counter = new AtomicLong();
    /*private List<Cours> listeCours = new ArrayList<>();
    private List<Cours> ListeCours = Arrays.asList(
                 new Cours("danses", "dessin","couture"),
                 new Cours("arts martiaux", "musique","broderie"),
                 new Cours("fitness", "photographie","creation de jeux video"),
                 new Cours("natation", "",""),
                 new Cours("sports d'équipes","", "")

                 );


    @GetMapping("/cours")
    public List<Cours> cours(){
        return ListeCours;
    }

    @PostMapping ("/cours")
    public void ajouterCours(@RequestBody  Cours nouveauCours){
//partie à écrire
        ListeCours.add(nouveauCours);
    }

   /* @GetMapping("/cours/{Sport}")
    public Cours afficherCours(@PathVariable String Sport) {
        //Cherchez le tatoueur ou la tatoueuse dans votre liste et retourner l’objet trouvé.
        for (Sport: listeCours) {

            return this.listeCours.get(Integer.parseInt(Sport));
        }
    }
   @PutMapping("/cours/{id}")
   public Cours modifierCours(@RequestBody Cours coursAModif, @PathVariable int id)
           throws ChangeSetPersister.NotFoundException {
       Cours c = this.ListeCours.get(id).Artisanat(() -> new
               ChangeSetPersister.NotFoundException("Tatoueur non trouvé"));
       c.getArtisanat(coursAModif.Artisanat);
       t.setStyle(tatoueurAModif.getStyle());
       return this.tatoueurRepository.save(t);
   }
    @DeleteMapping("/cours/{id}")
    public void supprimerTatoueur(@PathVariable int id) throws ChangeSetPersister.NotFoundException {
        Tatoueur t = this.tatoueurRepository.findById(id).orElseThrow(() -> new
                ChangeSetPersister.NotFoundException("Tatoueur non trouvé"));
        this.tatoueurRepository.delete(t);
    }

}*/
import com.example.demo.model.Cours;
import com.example.demo.repository.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

//import java.util.Arrays;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@RestController
@CrossOrigin
@RequestMapping("/cours")
public class CoursController {

    private final CoursRepository coursRepository;

    public CoursController(CoursRepository coursRepository) {
        this.coursRepository = coursRepository;
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_PROF')")
    public Cours createCours(@RequestBody Cours nouveauCours) {
        return coursRepository.save(nouveauCours);
    }

    @GetMapping
    public List<Cours> getAllCours() {
        return this.coursRepository.findAll();
    }


    @GetMapping("/{id}")
    public Cours getCours(@PathVariable Integer id) {
        return this.coursRepository.findById(id).get();
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_PROF')")
    public Cours updateCours(@PathVariable Integer id, @RequestBody Cours updatedCours) {
        return coursRepository.findById(id)
                .map(cours -> {
                    cours.setNom(updatedCours.getNom());
                    cours.setDescription(updatedCours.getDescription());
                    return coursRepository.save(cours);
                })
                .orElseThrow(() -> new RuntimeException("Cours not found with id " + id));
    }
//    @PutMapping("/{id}")
//    public void modifierCours(@RequestBody Cours cours, @PathVariable String Sport) {
//        //parourir la liste, utiliser la fonction set
//        for (int i = 0; i < this.coursRepository.findBy(id); i++) {
//            if (this.coursRepository.get(i).getSport() == Sport) {
//                this.coursRepository.set(i, cours);
//            }
//        }
// autre manière de faire le @PutMapping
       /* for(Tatoueur t : this.listeTatoueurs){
            if(t.getId()==id){
                t.setNom(tatoueurAModif.getNom());
                t.setStyle(tatoueurAModif.getStyle());
            }
        }
        */


    @DeleteMapping("/id")
    public void supprimerCours() {
        coursRepository.delete((Cours) id);

    }
}
