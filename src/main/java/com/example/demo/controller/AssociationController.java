package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class AssociationController {

    @GetMapping("/association")
    public String index() {
        return "93Moove est une association loi 1901 opérant dans l'ensemble du département\n" +
                "93. Leur but est non-lucratif, et est de permettre aux citoyens et citoyennes du\n" +
                "département d'accéder à des activités sportives, manuelles ou culturelles.\n" +
                "93Moove\n" +
                "fonctionne\n" +
                "en\n" +
                "délégation\n" +
                "de\n" +
                "service\n" +
                "public\n" +
                ":\n" +
                "ses\n" +
                "subventions\n" +
                "proviennent des départements ou des mairies. Elle assure en contrepartie un\n" +
                "service public auprès des habitants et habitantes.\n" +
                "Elle est implémentée dans cinq villes, où elle loue des locaux et réserve des\n" +
                "créneaux dans des gymnases ou établissements sportifs publics. Ces cinq centres\n" +
                "ont\n" +
                "des\n" +
                "noms\n" +
                ":\n" +
                "Saint-OuenMoove\n" +
                "(SOM),\n" +
                "Saint-DenisMoove\n" +
                "(SDM),\n" +
                "La\n" +
                "PlaineMoove(LMP), AubervilliersMoove (AM).\n" +
                "Ils proposent des activités différentes aux habitants et habitantes, en fonction de\n" +
                "l'âge :\n" +
                "•Sport : danses, arts martiaux, fitness, natation, sports d'équipes\n" +
                "•Culture : dessin, musique, photographie\n" +
                "•Artisanat : couture, broderie, création de jeux vidéos\n" +
                "Les cours et ateliers sont assurés par des professeur.es payé.es par l'association.\n" +
                "Certaines activités sont assurées par des animateurs et animatrices salarié.es de\n" +
                "l'association.\n" +
                "Les cours sont à l'année et se déroulent à heure fixe chaque semaine.\n" +
                "Les personnes souhaitant adhérer à l'association peuvent s'inscrire en allant aux\n" +
                "centres.\n" +
                "Les tarifs sont proportionnels aux revenus de la famille, pour les calculer le\n" +
                "personnel\n" +
                "administratif\n" +
                "des\n" +
                "centres\n" +
                "s'appuie\n" +
                "sur\n" +
                "le\n" +
                "quotient\n" +
                "familial\n" +
                "des\n" +
                "adhérent.es, présent sur leur déclaration de revenus aux impôts." +
                "<a href=\"/cours\">transfere cours</a>" ;

    }


   /* @GetMapping("/cours")
    public String cours() {
        return "<h1>bonjour</h1>" +
                "<a href=\"/\">retourne cours</a>" +
                "<br><a href=\"/association\">transfere association</a>";
    }*/



   /* @GetMapping("/association")
    public String association() {
        return

                "<br><a href=\"/cours\">transfere cours</a>";
    }*/
}


