package com.example.demo.service;

import com.example.demo.exception.VazioOuNuloException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class DemoExcecoesNaoVerificadasServiceTest {

    @InjectMocks
    DemoExcecoesNaoVerificadasService serviceException;

    @Test
    void exceptionNaoVerificadaNull() {

        Exception ex = assertThrows(NullPointerException.class, () -> serviceException.exceptionNaoVerificadaNull());

        String mensagemEsperada = "Cannot invoke \"com.example.demo.entity.Email.setAssunto(String)\" because \"email\" is null";
        assertDaMensagemDeErro(ex, mensagemEsperada);
    }

    @Test
    void exceptionNaoVerificadaForaDosLimitesDoArray() {
        Exception ex = assertThrows(StringIndexOutOfBoundsException.class, () -> serviceException.exceptionNaoVerificadaForaDosLimitesDoArray());

        String mensagemEsperada = "String index out of range: -1";
        assertDaMensagemDeErro(ex, mensagemEsperada);
    }

    @Test
    void exceptionNaoVerificadaFormatoNumerico() {
        Exception ex = assertThrows(NumberFormatException.class, () -> serviceException.exceptionNaoVerificadaFormatoNumerico());

        String mensagemEsperada = "For input string: \"100teste\"";
        assertDaMensagemDeErro(ex, mensagemEsperada);
    }

    @Test
    void exceptionNaoVerificadaAritimetica() {

        Exception ex = assertThrows(ArithmeticException.class, () -> serviceException.exceptionNaoVerificadaAritimetica());

        String mensagemEsperada = "/ by zero";
        assertDaMensagemDeErro(ex, mensagemEsperada);
    }

    @Test
    void exceptionNaoVerificadaCastIlegalTest() {

        Exception ex = assertThrows(ClassCastException.class, () -> serviceException.exceptionNaoVerificadaCastIlegal());

        String mensagemEsperada = "class java.lang.Object cannot be cast to class java.lang.Integer (java.lang.Object and java.lang.Integer are in module java.base of loader 'bootstrap')";
        assertDaMensagemDeErro(ex, mensagemEsperada);
    }

    @Test
    void exceptionNaoVerificadaArgumentoIlegalTest() {

        Exception ex = assertThrows(IllegalArgumentException.class, () -> serviceException.exceptionNaoVerificadaArgumentoIlegal());

        String mensagemEsperada = "timeout value is negative";
        assertDaMensagemDeErro(ex, mensagemEsperada);
    }

    @Test
    void exceptionNaoVerificadaEstadoIlegal() {

        assertThrows(IllegalStateException.class, () -> serviceException.exceptionNaoVerificadaEstadoIlegal());
    }

    @Test
    void testeDeExcecaoVerificadaPersonalizada() {

        Exception ex = assertThrows(VazioOuNuloException.class, () -> serviceException.exceptionNaoVerificadaPersonalizada());
        String mensagemEsperada = "arquivo vazio ou nulo";
        assertDaMensagemDeErro(ex, mensagemEsperada);
    }

    private void assertDaMensagemDeErro(Exception ex, String mensagemEsperada) {
        String atual = ex.getMessage();
        assertTrue(atual.contains(mensagemEsperada));
    }
}