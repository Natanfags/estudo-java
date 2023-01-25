package com.example.demo.service;

import com.example.demo.entity.Email;
import org.springframework.stereotype.Service;

@Service
public class EmailSerivce {

    private final PlataformaEnvio plataforma;

    public EmailSerivce(PlataformaEnvio plataforma) {
        this.plataforma = plataforma;
    }

    public void enviar(String para, String assunto, String mensagem) {

        Email email = new Email(para, assunto, mensagem);
        plataforma.enviar(email);

    }
}
