package com.example.demo.service;

import com.example.demo.provider.DadosProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StringConverter {

    private final DadosProvider dadosProvider;

    @Autowired
    public StringConverter(DadosProvider dadosProvider) {
        this.dadosProvider = dadosProvider;
    }

    public List<String> convert() {
        return dadosProvider.getValues().map(String::toUpperCase).toList();
    }
}
