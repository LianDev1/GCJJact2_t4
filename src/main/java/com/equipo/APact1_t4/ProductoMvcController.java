package com.equipo.APact1_t4;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/productos")
public class ProductoMvcController {

    @Value("${app.autor}")
    private String autorApp;

    private static List<ProductoDTO> listaProductos = new ArrayList<>();

    static {
        listaProductos.add(new ProductoDTO(1L, "Teclado Mecanico", 1200.0, "Electronica"));
        listaProductos.add(new ProductoDTO(2L, "Mouse Gamer", 650.0, "Electronica"));
        listaProductos.add(new ProductoDTO(3L, "Cuaderno Profesional", 85.0, "Papeleria"));
    }

    // Listado con th:each y uso de @RequestParam para filtrar por categoría
    @GetMapping
    public String listarProductos(@RequestParam(required = false) String categoria, Model model) {
        List<ProductoDTO> resultado = listaProductos;
        if (categoria != null && !categoria.isEmpty()) {
            resultado = listaProductos.stream()
                    .filter(p -> p.getCategoria().equalsIgnoreCase(categoria))
                    .collect(Collectors.toList());
        }
        model.addAttribute("productos", resultado);
        model.addAttribute("autor", autorApp);
        model.addAttribute("categoriaFiltro", categoria);
        return "lista";
    }

    // Detalle por @PathVariable
    @GetMapping("/{id}")
    public String verDetalle(@PathVariable Long id, Model model) {
        ProductoDTO producto = listaProductos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
        model.addAttribute("producto", producto);
        model.addAttribute("autor", autorApp);
        return "detalle";
    }

    // Formulario para registro
    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("producto", new ProductoDTO());
        model.addAttribute("autor", autorApp);
        return "formulario";
    }

    // Procesar formulario con @ModelAttribute
    @PostMapping("/guardar")
    public String guardarProducto(@ModelAttribute ProductoDTO producto) {
        producto.setId((long) (listaProductos.size() + 1));
        listaProductos.add(producto);
        return "redirect:/productos";
    }
}