package com.app.web.controllers;

import com.app.web.entities.Domicilio;
import com.app.web.entities.Promocion;
import com.app.web.entities.Usuario;
import com.app.web.services.CorreoServicio;
import com.app.web.services.DomicilioServicio;
import com.app.web.services.PromocionServicio;
import com.app.web.services.UsuarioServicio;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import javax.validation.Valid;

@Controller
public class DomicilioControlador {

    @Autowired
    private DomicilioServicio servicio;

    @Autowired
    private UsuarioServicio servicio2;

    @Autowired
    private CorreoServicio correoServicio;

    @Autowired
    private PromocionServicio promocionServicio;

    @GetMapping({"/login", "/"})
    public String mostrarFormularioInicioSesion(Model modelo) {
        modelo.addAttribute("usuario", new Usuario());
        return "login";
    }

    @PostMapping("/login")
    public String iniciarSesion(@ModelAttribute("usuario") Usuario usuario, Model modelo) {
        Usuario usuarioAutenticado = servicio2.autenticarUsuario(usuario.getCorreo(), usuario.getCelular());
        if (usuarioAutenticado != null) {
            // Usuario autenticado, puedes redirigir a la página principal o a otro lugar
            return "redirect:/domicilios";
        } else {
            modelo.addAttribute("error", "Correo o contraseña incorrectos");
            return "login"; // Regresar a la misma vista para mostrar el mensaje de error
        }
    }

    @GetMapping("/domicilios")
    public String listarDomicilios(Model modelo) {
        modelo.addAttribute("domicilios", servicio.listarTodosLosDomicilios());
        modelo.addAttribute("usuarios", servicio2.listarTodosLosUsuarios());
        return "domicilios";
    }

    @GetMapping("/domicilios/nuevo")
    public String mostrarFormularioDeRegistrarDomicilio(Model modelo) {
        Domicilio domicilio = new Domicilio();
        modelo.addAttribute("domicilio", domicilio);
        return "crear_domicilio";
    }

    @PostMapping("/domicilios")
    public String guardarDomicilio(@Valid @ModelAttribute("domicilio") Domicilio domicilio, BindingResult result, Model modelo) {
        if (result.hasErrors()) {
            return "crear_domicilio";
        }
        servicio.guardarDomicilio(domicilio);
        return "redirect:/domicilios";
    }

    @GetMapping("/domicilios/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("domicilio", servicio.obtenerDomicilioPorId(id));
        return "editar_domicilio";
    }

    @PostMapping("/domicilios/{id}")
    public String actualizarDomicilio(@Valid @ModelAttribute("domicilio") Domicilio domicilio, BindingResult result, Model modelo) {
        if (result.hasErrors()) {
            return "editar_domicilio";
        }
        servicio.actualizarDomicilio(domicilio);
        return "redirect:/domicilios";
    }

    @GetMapping("/domicilios/{id}")
    public String eliminarDomicilio(@PathVariable Long id) {
        servicio.eliminarDomicilio(id);
        return "redirect:/domicilios";
    }

    @GetMapping("/enviar-correos")
    public String mostrarFormularioEnvioCorreos(Model model) {
        List<Promocion> promociones = promocionServicio.obtenerTodasLasPromociones();
        model.addAttribute("promociones", promociones);
        return "enviar_correos";
    }

    @PostMapping("/enviar-correos")
    public String enviarCorreos(@RequestParam("promocionId") Long promocionId, @RequestParam("emails") List<String> emails) {
        Promocion promocion = promocionServicio.obtenerPromocionPorId(promocionId);
        String asunto = "Nueva Promoción: " + promocion.getTitulo();
        String mensaje = promocion.getDescripcion();
        correoServicio.enviarCorreoMasivo(emails, asunto, mensaje);
        return "redirect:/domicilios";
    }

    @GetMapping("/estadisticas")
    public String mostrarEstadisticas(Model model) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String domiciliosPorEstadoJson = objectMapper.writeValueAsString(servicio.getDomiciliosPorEstado());
        String usuariosPorRolJson = objectMapper.writeValueAsString(servicio2.getUsuariosPorRol());
        
        // Imprimir en consola para verificar los datos
        System.out.println("Domicilios por Estado JSON: " + domiciliosPorEstadoJson);
        System.out.println("Usuarios por Rol JSON: " + usuariosPorRolJson);


        model.addAttribute("domiciliosPorEstadoJson", domiciliosPorEstadoJson);
        model.addAttribute("usuariosPorRolJson", usuariosPorRolJson);
        return "estadisticas";
    }

    @GetMapping("/promociones/cargar")
    public String mostrarFormularioCargar() {
        return "cargar_promociones";
    }

    @PostMapping("/promociones/cargar")
    public String cargarPromociones(@RequestParam("file") MultipartFile file, Model model) {
        try {
            promocionServicio.cargarPromociones(file);
            model.addAttribute("message", "Archivo cargado exitosamente");
        } catch (Exception e) {
            model.addAttribute("message", "Error al cargar archivo: " + e.getMessage());
        }
        return "cargar_promociones";
    }
}
