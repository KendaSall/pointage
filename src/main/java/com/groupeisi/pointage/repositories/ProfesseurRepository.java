package com.groupeisi.pointage.repositories;


import com.groupeisi.pointage.entities.Professeur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesseurRepository extends JpaRepository<Professeur,Long> {
    Page<Professeur> findByNomContains(String kw, Pageable pageable);
}
