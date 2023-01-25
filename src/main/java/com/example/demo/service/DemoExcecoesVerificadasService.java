package com.example.demo.service;

import com.example.demo.exception.NomeIncorretoException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Service
public class DemoExcecoesVerificadasService {

    public void exceptionVerificadaComThrowsNoMetodo() throws FileNotFoundException {
        File arquivo = new File("nao_existe.txt");
        FileInputStream stream = new FileInputStream(arquivo);
    }

    public String exceptionVerificadaComTryCatch() {
        File arquivo = new File("nao_existe.txt");
        try {
            FileInputStream stream = new FileInputStream(arquivo);
        } catch (FileNotFoundException e) {
            return e.getMessage();
        }
        return "";
    }

    public String exceptionVerificaPersonalizada() throws NomeIncorretoException {
        String arquivo = "nome arquivo";
        try {
            FileInputStream stream = new FileInputStream(arquivo);
        } catch (FileNotFoundException e) {
            if (!estaComNomeCorreto(arquivo)) {
                throw new NomeIncorretoException("Nome errado: " + arquivo);
            }
            return e.getMessage();
        }
        return "";
    }

    private boolean estaComNomeCorreto(String arquivo) {
        //sempre falso
        return false;
    }

}
