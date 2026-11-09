package com.equipo.APact1_t4;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class InfoControlador {

    // Endpoint 1: Nombre del proyecto
    @GetMapping("/proyecto")
    public String obtenerProyecto() {
        return "Proyecto Actividad 1 - Instancia de Jonathan";
    }

    // Endpoint 2: Lista simulada de materias
    @GetMapping("/materias")
    public List<String> obtenerMaterias() {
        return List.of("Programación Web", "Bases de Datos", "Estructuras de Datos");
    }
}