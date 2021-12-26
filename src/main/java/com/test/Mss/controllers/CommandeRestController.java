package com.test.Mss.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.Mss.entities.Commande;
import com.test.Mss.repositories.CommandeRepository;

@RestController
@RequestMapping("/api/commandes")
public class CommandeRestController {

	@Autowired
	private CommandeRepository commandeRepository;

	@GetMapping("/list")
	public List<Commande> getAllCommandes() {
		return (List<Commande>) commandeRepository.findAll();
	}

	@PostMapping("/add")
	public Commande createCommande(@Valid @RequestBody Commande commande) {
		return commandeRepository.save(commande);
	}

	@DeleteMapping("/delete/{commandeId}")
	public ResponseEntity<?> deleteProduit(@PathVariable(value = "commandeId") Long commandeId) {
		return commandeRepository.findById(commandeId).map(commande -> {
			commandeRepository.delete(commande);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new IllegalArgumentException("commande not found with id " + commandeId));
	}


	
	@PutMapping("/update/{commandeId}")
    public Commande updateCommande(@PathVariable (value = "commandeId") Long commandeId,
                                   @Valid @RequestBody Commande commandeRequest) {

        return commandeRepository.findById(commandeId).map(commande -> {
        	commande.setPrixTotal(commandeRequest.getPrixTotal());
        	commande.setNumero(commandeRequest.getNumero());
        	commande.setDate(commandeRequest.getDate());
        	commande.setEtat(commandeRequest.getEtat());
        return commandeRepository.save(commande);
        }).orElseThrow(() -> new IllegalArgumentException("commandeId " + commandeId + "not found"));
    }

}
