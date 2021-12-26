package com.test.Mss.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.Mss.entities.Commande;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long>{

}
