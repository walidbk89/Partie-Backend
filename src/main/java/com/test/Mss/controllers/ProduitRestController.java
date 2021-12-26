package com.test.Mss.controllers;

import java.util.Arrays;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.test.Mss.entities.Produit;
import com.test.Mss.repositories.CategorieRepository;
import com.test.Mss.repositories.ProduitRepository;

@RestController
@RequestMapping("/api/produits")
@CrossOrigin(origins="*")
public class ProduitRestController {
	
	@Autowired
	private CategorieRepository categorieRepository;
	
	@Autowired
	private ProduitRepository produitRepository;
	
	@GetMapping("/list")
	public List<Produit> getAllProduits() {
		return (List<Produit>) produitRepository.findAll();
	}
	
	@PostMapping("/add/{id}")
	 public Optional<Produit> createProduit(@PathVariable (value = "id") Long id, @Valid @RequestBody Produit produit) {
		return categorieRepository.findById(id).map(categorie -> {produit.setCategorie(categorie);
			return produitRepository.save(produit);
				});
		 }
	
	@DeleteMapping("/delete/{id}")
	  public ResponseEntity<?> deleteProduit(@PathVariable (value = "id") Long id) {
	        return produitRepository.findById(id).map(produit -> {produitRepository.delete(produit);
	        	 return ResponseEntity.ok().build();
	        }).orElseThrow(() -> new IllegalArgumentException("produit not found with id " + id));
	    }
	
	//delete All
//	@DeleteMapping("/delete/{Long[] ids}")
//    public void deleteAll(Long[] ids) {
//		produitRepository.deleteProduitsWithIds(Arrays.asList(ids));
//	
//	}
	
}
