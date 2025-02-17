package com.app.web.services;

import com.app.web.entities.Promocion;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface PromocionServicio {
    List<Promocion> obtenerTodasLasPromociones();
    Promocion obtenerPromocionPorId(Long id);
    void cargarPromociones(MultipartFile file) throws IOException;
    Promocion crearPromocion(Promocion promocion);
    Promocion actualizarPromocion(Long id, Promocion promocion);
    boolean eliminarPromocion(Long id);
}
