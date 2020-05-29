package com.ensim.MaaApp.Controller;

import java.net.URI;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ensim.MaaApp.Model.Garantie;



@RestController
public class GarantieController {
    private Map<Integer, Garantie> listDb = new HashMap<Integer, Garantie>();
    
    
    //recuperer la liste des garanties  
    @GetMapping("/api/garantie")
    public ResponseEntity<Collection<Garantie>> getGarantie() {
        return ResponseEntity.ok().body(listDb.values());
    }
    
    //supprimer garantie
    @DeleteMapping("/api/garantie/{id}")
    public ResponseEntity<String> deleteGarantie(@PathVariable("id") @NonNull int id) {
        if (listDb.containsKey(id)) {
        	listDb.remove(id);
            return ResponseEntity.ok().body(listDb.get(id).getNom()+ " a été supprimée");
        }

        return ResponseEntity.notFound().build();
    }
    //modifier garantie
    @PutMapping(path = "/api/garantie/{id}", produces= {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Garantie> modifierGarantie(@PathVariable("id") @NonNull int id, @RequestBody String nom, @RequestBody String description, @RequestBody int montant) {
        if (listDb.containsKey(id)) {
        	Garantie garantie=listDb.get(id);
        	garantie.setNom(nom);
        	garantie.setMontant(montant);
        	garantie.setDescription(description);
        	
        	listDb.put(id, garantie);
        	
            return ResponseEntity.ok(garantie);
        }

        return ResponseEntity.notFound().build();
    }
    
    //recuperation de quarantie specifique
    @GetMapping("/api/garantie/{id}")
    public ResponseEntity<Garantie> getEquipe(@PathVariable("id") @NonNull int id) {
        if (listDb.containsKey(id)) {
            return ResponseEntity.ok(listDb.get(id));
        }

        return ResponseEntity.notFound().build();
    }
    
    //creation de garantie
    
    @PostMapping("/api/garantie")
    public ResponseEntity<Garantie> postGarantie(@RequestParam("nom") String nom, @RequestParam("montant") int montant, @RequestParam("description") String description) {

    	if(nom.isEmpty()|| description.isEmpty()) {
            return ResponseEntity.badRequest().build();
    	}
    	
        // affectation d'un id et persistance
        Garantie garantie = new Garantie();
        garantie.setId(listDb.size()-1);
        garantie.setNom(nom);
        garantie.setDescription(description);
        garantie.setMontant(montant);

        listDb.put(garantie.getId(), garantie);

        return ResponseEntity.ok().body(garantie);

    }
}
