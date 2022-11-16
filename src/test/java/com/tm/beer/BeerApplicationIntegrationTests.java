package com.tm.beer;



import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tm.beer.model.Beer;
import com.tm.beer.repository.BeerRepository;

import java.util.Date;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

public class BeerApplicationIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BeerRepository beerRepository;

    private Beer beer1 = new Beer("test1", "test1", "test1", "test1", 1, null, "test1");
    private Beer beer2 = new Beer("test2", "test2", "test2", "test2", 2, null, "test2");

    @BeforeEach
    public void beforeAllTests() {
        beerRepository.deleteAll();
        beerRepository.save(beer1);
        beerRepository.save(beer2);
    }

    @AfterEach
    public void afterAllTests() {
        //Watch out with deleteAll() methods when you have other data in the test database!
        beerRepository.deleteAll();
    }

/*     @Test
    public void givenBeers_whenGetBeers_thenReturnJsonArray() throws Exception {

        mockMvc.perform(get("/beers")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].beerName", is(beer1.getName())))
                .andExpect(jsonPath("$[1].beerName", is(beer2.getName())));
    }

    @Test
    public void getBeerByBeerId() throws Exception {

        mockMvc.perform(get("/beers/id/{beerId}", beer1.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.beerName", is(beer1.getName())));
    }

    @Test
    public void getBeerByBeerName() throws Exception {

        mockMvc.perform(get("/beers/{test1}", beer1.getName())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.beerName", is(beer1.getName())));
    }

    @Test
    public void getBeersByBeerNameContaining() throws Exception {

        mockMvc.perform(get("/beers/search/{test1}", beer1.getName())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].beerName", is(beer1.getName())));
    }

    @Test
    public void createBeer() throws Exception {
        Beer beer = new Beer("test3", "test3", "test3", "test3", 3, null, "test3");

        mockMvc.perform(post("/beers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(beer)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.beerName", is(beer.getName())));
    }

    @Test
    public void updateBeer() throws Exception {
        Beer beer = new Beer("test4", "test4", "test4", "test4", 4, null, "test4");

        mockMvc.perform(put("/beers/{beerId}", beer.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(beer)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.beerName", is(beer.getName())));
    }

    @Test
    public void deleteBeer() throws Exception {
        mockMvc.perform(delete("/beers/{beerName}", beer1.getName())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    } */


    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }  
    
}
