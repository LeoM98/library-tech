package com.org.utb.app.librarytech;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.org.utb.app.librarytech.entities.Address;
import com.org.utb.app.librarytech.repositories.AddressRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AddressServiceTest {

    @Autowired
    private WebApplicationContext wac;
    @Mock
    private AddressRepository repository;
    private MockMvc mvc;

    // It's so important to execute the test method
    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(
                this.wac);
        this.mvc = builder.build();
    }

    protected String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        return objectMapper.writeValueAsString(obj);
    }

    @Test
    public void getAllAddress_Status200() throws Exception {
        Address address = Address.builder().name("Gaviotas").build();
        Address address1 = Address.builder().name("Gaviotas").build();
        Address address2 = Address.builder().name("Gaviotas").build();
        List<Address> addressList = Lists.newArrayList(address1,address2,address);
        when(repository.findAll()).thenReturn(addressList);

        MvcResult mvcResult = mvc.perform( MockMvcRequestBuilders
                .get("/address")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(HttpStatus.OK.value(), status);
    }

    @Test
    public void getAddressById_Status200() throws Exception {
        Address address = Address.builder().name("Gaviotas").build();
        when(repository.findById(50L)).thenReturn(Optional.of(address));
        MvcResult mvcResult = mvc.perform( MockMvcRequestBuilders
                .get("/address")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(HttpStatus.OK.value(), status);
    }

    @Test
    public void getAddressById_Status404() throws Exception {
        Address address = Address.builder().name("Gaviotas").build();
        when(repository.findById(2L)).thenReturn(Optional.of(address));
        MvcResult mvcResult = mvc.perform( MockMvcRequestBuilders
                .get("/address")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(HttpStatus.NOT_FOUND.value(), status);
    }

    @Test
    public void getAllAddress_Status404() throws Exception {
        List<Address> addressList = new ArrayList<>();
        when(repository.findAll()).thenReturn(addressList);
        MvcResult mvcResult = mvc.perform( MockMvcRequestBuilders
                .get("/address")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(HttpStatus.NOT_FOUND.value(), status);
    }

    @Test
    public void givenFillAddress_getStatus201() throws Exception {
        Address address = Address.builder().name("Gaviotas").build();
        String inputJson = mapToJson(address);
        MvcResult mvcResult = mvc.perform(post("/address")
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).
                andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
    }

}
