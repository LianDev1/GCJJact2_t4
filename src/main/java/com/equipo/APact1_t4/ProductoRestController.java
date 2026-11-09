
package com.equipo.APact1_t4;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/productos")
public class ProductoRestController {

    @PostMapping
    public ResponseEntity<ProductoDTO> crearProductoApi(@RequestBody ProductoDTO dto) {
        // Asignación ficticia de ID para la respuesta JSON
        dto.setId(99L);
        return ResponseEntity.ok(dto);
    }
}