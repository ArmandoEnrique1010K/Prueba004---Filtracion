package com.prueba04.service;

import com.prueba04.entity.ProductoEntity;
import java.util.List;

public interface ProductoService {
    // Si no vamos a utilizar DTO, entonces nos vamos con la Entidad
    
    // METODO DE PRUEBA
    public List<ProductoEntity> ListarProductos();
    public List<ProductoEntity> ListarProductosPorCategoria2();
    public List<ProductoEntity> listarProductosPorCategoriaEspecifica(Long categoriaId);

}
