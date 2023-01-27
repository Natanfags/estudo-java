package com.example.demo.service;

import com.example.demo.provider.DadosProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class StringConverterTest {

    @Mock
    private DadosProvider dadosProvider;

    @InjectMocks
    private StringConverter stringConverter;

    @Test
    void convertStringParaMaiuscula() {

        when(dadosProvider.getValues()).thenReturn(Stream.of("um", "dois"));

        List<String> convert = stringConverter.convert();

        assertThat(convert).contains("UM", "DOIS");
    }

}