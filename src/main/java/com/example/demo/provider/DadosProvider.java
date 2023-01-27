package com.example.demo.provider;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Stream;

@Component
public class DadosProvider {

    private final List<String> dados = List.of("lakers", "timberwolfes", "heat", "grizles");

    public Stream<String> getValues() {
        return dados.stream();
    }
}
