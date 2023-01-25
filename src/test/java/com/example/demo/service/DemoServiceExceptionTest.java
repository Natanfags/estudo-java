package com.example.demo.service;

import com.example.demo.exception.NomeIncorretoException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class DemoServiceExceptionTest {

    @InjectMocks
    DemoExcecoesVerificadasService serviceException;

    @Test
    void testeDeExcecaoComThrownsNoMetodo() {

        Exception ex = assertThrows(FileNotFoundException.class, () -> serviceException.exceptionVerificadaComThrowsNoMetodo());

        String mensagemEsperada = "nao_existe.txt (O sistema não pode encontrar o arquivo especificado)";
        String atual = ex.getMessage();

        assertTrue(atual.contains(mensagemEsperada));
    }

    @Test
    void testeDeExcecaoUsandoTryCatch() {

        String s = serviceException.exceptionVerificadaComTryCatch();
        String mensagemEsperada = "nao_existe.txt (O sistema não pode encontrar o arquivo especificado)";

        assertTrue(s.contains(mensagemEsperada));
    }

    @Test
    void testeDeExcecaoVerificadaPersonalizada() {

        Exception ex = assertThrows(NomeIncorretoException.class, () -> serviceException.exceptionVerificaPersonalizada());
        String mensagemEsperada = "Nome errado: nome arquivo";
        String atual = ex.getMessage();

        assertTrue(atual.contains(mensagemEsperada));
    }

}