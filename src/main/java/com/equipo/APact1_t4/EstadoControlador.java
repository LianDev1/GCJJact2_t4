package com.equipo.APact1_t4;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class EstadoControlador {

    // Endpoint 3: Objeto/Estado simple
    @GetMapping("/estado")
    public Map<String, Object> obtenerEstado() {
        return Map.of("servidor", "Activo", "puerto", 8081);
    }
}