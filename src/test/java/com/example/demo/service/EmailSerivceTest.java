package com.example.demo.service;

import com.example.demo.entity.Email;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.verify;

@SpringBootTest
class EmailSerivceTest {

    @InjectMocks
    EmailSerivce emailSerivce;

    @Mock
    PlataformaEnvio plataforma;

    @Captor
    ArgumentCaptor<Email> emailArgumentCaptor;

    @Test
    void enviar() {

        String para = "demo@email.com";
        String assunto = "argument captor teste";
        String mensagem = "mensagem de teste do email";
        String mensagemErrada = "mensagem diferente";

        emailSerivce.enviar(para, assunto, mensagem);
        verify(plataforma).enviar(emailArgumentCaptor.capture());

        Email expect = emailArgumentCaptor.getValue();

        assertThat(expect.getPara(), equalTo(para));
        assertThat(expect.getAssunto(), equalTo(assunto));
        assertThat(expect.getMensagem(), equalTo(mensagem));
        assertNotEquals(expect.getMensagem(), mensagemErrada);
    }
}