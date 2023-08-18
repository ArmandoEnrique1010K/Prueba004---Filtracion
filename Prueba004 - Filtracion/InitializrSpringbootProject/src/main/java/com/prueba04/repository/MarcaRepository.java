package com.prueba04.repository;

import com.prueba04.entity.MarcaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepository extends JpaRepository<MarcaEntity, Long>{

}
