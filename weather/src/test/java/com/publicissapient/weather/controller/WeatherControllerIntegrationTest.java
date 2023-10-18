package com.publicissapient.weather.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WeatherControllerIntegrationTest {

    /** The mvc. */
    @Autowired
    private MockMvc mvc;

    /** The web application context. */
    @Autowired
    private WebApplicationContext webApplicationContext;

    /**
     * Setup.
     *
     * @throws Exception the exception
     */
    @Before
    public void setup() throws Exception {
        this.mvc = webAppContextSetup(webApplicationContext).build();
    }


    /**
     * @throws Exception the exception
     */
    @Test
    public void getWeatherByCityTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/v1/weather/London").accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
    }

    /**
     * @throws Exception the exception
     */
    @Test
    public void getWeatherByCityNoContentTest() throws Exception {
        String city = " ";
        mvc.perform(MockMvcRequestBuilders.get("/v1/weather/" + city).accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest()).andReturn();
    }

}
