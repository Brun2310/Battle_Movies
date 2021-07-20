package com.example.battlemoveis;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;
import java.net.URISyntaxException;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration


public class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void deveriaDevolver400CasoDadosDeValidacaoEstejamIncorretos() throws Exception {
        URI uri = new URI("/usuario");
        String json = "{\"nome\": \"nomeDoUsuario\", \"senha\": \"12331222212121\"}";

        mockMvc
                .perform(MockMvcRequestBuilders
                        .post(uri)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                .status()
                .is(400));


    }


}
