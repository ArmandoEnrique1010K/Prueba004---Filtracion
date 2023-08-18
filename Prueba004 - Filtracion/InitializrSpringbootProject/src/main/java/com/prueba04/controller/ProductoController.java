package com.prueba04.controller;

import com.prueba04.entity.CategoriaEntity;
import com.prueba04.service.CategoriaService;
import com.prueba04.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public String inicio(Model modelo) {
        modelo.addAttribute("productos", productoService.ListarProductos());
        // modelo.addAttribute("productos", productoService.ListarProductosPorCategoria2());
        modelo.addAttribute("categorias", categoriaService.ListarCategorias());
        return "listaproductos.html";
    }

    /*
    @GetMapping("/{categoriaId}")
    public String listarProductosPorCategoria(@PathVariable Long categoriaId, Model modelo) {
        CategoriaEntity categoria = categoriaService.obtenerCategoriaPorId(categoriaId);
        if (categoria != null) {
            modelo.addAttribute("productos", productoService.listarProductosPorCategoriaEspecifica(categoriaId));
            modelo.addAttribute("categorias", categoriaService.ListarCategorias());
            // Atributo para listar una sola categoria
            modelo.addAttribute("categoriaunica", categoriaService.obtenerCategoriaPorId(categoriaId));
            return "listaproductos.html";
        } else {
            // Manejar el caso en que la categoría no existe
            return "error.html";
        }
    }
    */
    
    @GetMapping("/{categoriaNombre}")
    public String listarProductosPorCategoriaNombre(@PathVariable String categoriaNombre, Model modelo) {
        CategoriaEntity categoria = categoriaService.obtenerCategoriaPorNombre(categoriaNombre);
        if (categoria != null) {
            modelo.addAttribute("productos", productoService.listarProductosPorCategoriaEspecifica(categoria.getId_categoria()));
            modelo.addAttribute("categorias", categoriaService.ListarCategorias());
            modelo.addAttribute("categoriaunica", categoriaService.obtenerCategoriaPorNombre(categoriaNombre));
            return "listaproductos.html";
        } else {
            // Manejar el caso en que la categoría no existe
            return "error.html";
        }
    }

}
