package com.test.Mss.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.Mss.entities.Categorie;
import com.test.Mss.repositories.CategorieRepository;



@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins="*")
public class CategorieRestController {
	
	@Autowired
	private CategorieRepository categorieRepository; 
	
	@GetMapping("/list")
	public List<Categorie> getAllCategories() {
		return (List<Categorie>) categorieRepository.findAll();
	}
	
	@PostMapping("/add")
    public Categorie createCategorie(@Valid @RequestBody Categorie categorie) {
		return categorieRepository.save(categorie);
    }
	
	@PutMapping("/{id}")
    public Categorie updateCategorie(@PathVariable Long id, @Valid @RequestBody Categorie categorieRequest) {
        return categorieRepository.findById(id).map(categorie -> {
        	categorie.setCode(categorieRequest.getCode());
        	categorie.setLibelle(categorieRequest.getLibelle());
            return categorieRepository.save(categorie);
        }).orElseThrow(() -> new IllegalArgumentException("CategorieId" + id + " not found"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategorie(@PathVariable Long id) {
        return categorieRepository.findById(id).map(categorie -> {
        	categorieRepository.delete(categorie);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new IllegalArgumentException("CategorieId " + id + " not found"));
    }
    
    @GetMapping("/{id}")
    public Categorie getCategorie(@PathVariable Long id) {
    	
    	Optional<Categorie> c = categorieRepository.findById(id);
    	return c.get();
    }
}
