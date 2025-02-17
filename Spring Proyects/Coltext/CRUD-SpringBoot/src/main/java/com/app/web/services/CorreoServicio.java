package com.app.web.services;

import java.util.List;

public interface CorreoServicio {
    void enviarCorreo(String destinatario, String asunto, String mensaje);
    void enviarCorreoMasivo(List<String> destinatarios, String asunto, String mensaje);
}
