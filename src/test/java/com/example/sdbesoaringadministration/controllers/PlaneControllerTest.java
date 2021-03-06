package com.example.sdbesoaringadministration.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PlaneControllerTest {

    @Autowired
    private MockMvc mvc;

    @WithMockUser(value = "ADMIN")
    @Test
    public void givenAuthRequest_shouldSucceedWith200() throws Exception {
        mvc.perform( get( "/planes" ).contentType( MediaType.APPLICATION_JSON ) )
                .andExpect( status().isOk() );
    }

}
