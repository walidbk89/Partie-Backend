package com.test.Mss.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.Mss.entities.Categorie;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long>{

}
