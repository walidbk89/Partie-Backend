package com.test.Mss.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.test.Mss.entities.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long>{
	
//	@Query("delete from produit p where p.produitId in ?1")
//	void deleteProduitsWithIds(List<Long> ids);

}
