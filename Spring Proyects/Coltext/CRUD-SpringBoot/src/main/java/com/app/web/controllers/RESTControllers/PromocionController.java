package com.app.web.controllers.RESTControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.web.entities.Promocion;
import com.app.web.services.PromocionServicio;

@RestController
@RequestMapping("/api/promociones")
public class PromocionController {

    @Autowired
    private PromocionServicio promocionServicio;

    @GetMapping
    public List<Promocion> obtenerTodasLasPromociones() {
        return promocionServicio.obtenerTodasLasPromociones();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Promocion> obtenerPromocionPorId(@PathVariable Long id) {
        Promocion promocion = promocionServicio.obtenerPromocionPorId(id);
        if (promocion != null) {
            return new ResponseEntity<>(promocion, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Promocion> crearPromocion(@RequestBody Promocion promocion) {
        Promocion nuevaPromocion = promocionServicio.crearPromocion(promocion);
        return new ResponseEntity<>(nuevaPromocion, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Promocion> actualizarPromocion(@PathVariable Long id, @RequestBody Promocion promocion) {
        Promocion promocionActualizada = promocionServicio.actualizarPromocion(id, promocion);
        if (promocionActualizada != null) {
            return new ResponseEntity<>(promocionActualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPromocion(@PathVariable Long id) {
        boolean eliminado = promocionServicio.eliminarPromocion(id);
        if (eliminado) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
