package com.prueba04.repository;

import com.prueba04.entity.ProductoEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, Long>{
    
    // SELECCIONAR PRODUCTOS QUE COINCIDAN CON LA CATEGORIA DEL ID #2
    @Query(value = "SELECT p FROM ProductoEntity p JOIN p.categoriaEntity c "
        + "WHERE p.categoriaEntity.id_categoria = 2")
    List<ProductoEntity> findAllByCategoriaID2();
    
    // SELECCIONAR PRODUCTOS QUE COINCIDAN CON UNA CATEGORIA ESPECÍFICA
    @Query(value = "SELECT p FROM ProductoEntity p JOIN p.categoriaEntity c "
            + "WHERE c.id_categoria = :categoriaId")
    List<ProductoEntity> findAllByCategoriaIdParam(@Param("categoriaId") Long categoriaId);

}
