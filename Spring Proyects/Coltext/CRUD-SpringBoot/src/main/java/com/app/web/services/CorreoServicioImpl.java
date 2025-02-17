package com.app.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;

@Service
public class CorreoServicioImpl implements CorreoServicio {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void enviarCorreo(String destinatario, String asunto, String mensaje) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setTo(destinatario);
            helper.setSubject(asunto);
            helper.setText(mensaje, true);
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void enviarCorreoMasivo(List<String> destinatarios, String asunto, String mensaje) {
        for (String destinatario : destinatarios) {
            enviarCorreo(destinatario, asunto, mensaje);
        }
    }
}
