package com.example.demo.service;

import com.example.demo.entity.Email;
import com.example.demo.exception.VazioOuNuloException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;

@Service
public class DemoExcecoesNaoVerificadasService {

    public void exceptionNaoVerificadaNull() {
        Email email = null;
        String assuntoEmail = "assunto";

        email.setAssunto(assuntoEmail);
    }

    public void exceptionNaoVerificadaForaDosLimitesDoArray() {
        String teste = "teste";
        char caracterNegativo = teste.charAt(-1);
        char caracterComTamanhoDoIndex = teste.charAt(5);
    }

    public void exceptionNaoVerificadaFormatoNumerico() {
        String teste = "100teste";
        int x = Integer.parseInt(teste);
    }

    public void exceptionNaoVerificadaAritimetica() {
        int divisaoPorZero = 10 / 0;
    }

    public void exceptionNaoVerificadaCastIlegal() {
        Object teste = new Object();
        Integer i = (Integer) teste;
    }

    public void exceptionNaoVerificadaArgumentoIlegal() throws InterruptedException {
        Thread.currentThread().sleep(-10000);
    }

    public void exceptionNaoVerificadaEstadoIlegal() {
        Iterator<Object> teste = new ArrayList<>().iterator();
        teste.remove();
    }

    public void exceptionNaoVerificadaPersonalizada() throws InterruptedException {

        String arquivo = "";

        try {
            Thread.currentThread().sleep(-10000);
        } catch (IllegalArgumentException e) {
            if (estaVazioOuNulo(arquivo)) {
                throw new VazioOuNuloException("arquivo vazio ou nulo");
            }
        }
    }

    private boolean estaVazioOuNulo(String nome) {
        return true;
    }

}
