package com.app.web.services;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.web.entities.Promocion;
import com.app.web.repository.PromocionRepositorio;

@Service
public class PromocionServicioImpl implements PromocionServicio {

    @Autowired
    private PromocionRepositorio promocionRepositorio;

    @Override
    public List<Promocion> obtenerTodasLasPromociones() {
        return promocionRepositorio.findAll();
    }

    @Override
    public Promocion obtenerPromocionPorId(Long id) {
        return promocionRepositorio.findById(id).orElse(null);
    }

    @Override
    public void cargarPromociones(MultipartFile file) {
        List<Promocion> promociones = new ArrayList<>();

        try (InputStream inputStream = file.getInputStream();
             Workbook workbook = new XSSFWorkbook(inputStream)) {

            Sheet sheet = workbook.getSheetAt(0);
            Iterator<org.apache.poi.ss.usermodel.Row> rows = sheet.iterator();

            while (rows.hasNext()) {
                org.apache.poi.ss.usermodel.Row currentRow = rows.next();
                if (currentRow.getRowNum() == 0) { // Skip header
                    continue;
                }

                Promocion promocion = new Promocion();
                promocion.setRangoFechas(currentRow.getCell(0).getStringCellValue());
                promocion.setDescripcion(currentRow.getCell(1).getStringCellValue());

                Cell cell = currentRow.getCell(2);
                if (cell != null && cell.getCellType() == CellType.NUMERIC) {
                    promocion.setInsumoDescuento((long) cell.getNumericCellValue());
                } else {
                    promocion.setInsumoDescuento(0L); // Default value or handle as needed
                }

                promocion.setTitulo(currentRow.getCell(3).getStringCellValue());

                promociones.add(promocion);
            }
        } catch (Exception e) {
            // Handle the exception, e.g., log it or rethrow it
            e.printStackTrace();
        }

        promocionRepositorio.saveAll(promociones);
    }

    @Override
    public Promocion crearPromocion(Promocion promocion) {
        return promocionRepositorio.save(promocion);
    }

    @Override
    public Promocion actualizarPromocion(Long id, Promocion promocion) {
        if (promocionRepositorio.existsById(id)) {
            promocion.setIdpromocion(id);
            return promocionRepositorio.save(promocion);
        }
        return null;
    }

    @Override
    public boolean eliminarPromocion(Long id) {
        if (promocionRepositorio.existsById(id)) {
            promocionRepositorio.deleteById(id);
            return true;
        }
        return false;
    }
}
