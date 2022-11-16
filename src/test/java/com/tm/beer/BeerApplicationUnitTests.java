package com.tm.beer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tm.beer.model.Beer;
import com.tm.beer.repository.BeerRepository;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class BeerApplicationUnitTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BeerRepository beerRepository;

    private Beer beer1 = new Beer("test1", "test1", "test1", "test1", 1, null, "test1");
    private Beer beer2 = new Beer("test2", "test2", "test2", "test2", 2, null, "test2");

    private List<Beer> allBeers = Arrays.asList(beer1, beer2);

    @Test
    public void givenBeers_whenGetBeers_thenReturnJsonArray() throws Exception {
        given(beerRepository.findAll()).willReturn(allBeers);

        mockMvc.perform(get("/beers")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].beerName", is(beer1.getName())))
                .andExpect(jsonPath("$[1].beerName", is(beer2.getName())));
    }

    @Test
    public void getBeerByBeerId() throws Exception {
        given(beerRepository.findBeerByBeerId(beer1.getId())).willReturn(beer1);

        mockMvc.perform(get("/beers/id/{beerId}", beer1.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.beerName", is(beer1.getName())));
    }

    @Test
    public void getBeerByBeerName() throws Exception {
        given(beerRepository.findBeerByBeerName(beer1.getName())).willReturn(beer1);

        mockMvc.perform(get("/beers/{test1}", beer1.getName())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.beerName", is(beer1.getName())));
    }

    @Test
    public void getBeersByBeerNameContaining() throws Exception {
        given(beerRepository.findBeerByBeerNameContaining(beer1.getName())).willReturn(allBeers);

        mockMvc.perform(get("/beers/search/{test1}", beer1.getName())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].beerName", is(beer1.getName())));
    }

    @Test
    public void createBeer() throws Exception {
        Beer beer = new Beer("test3", "test3", "test3", "test3", 3, null, "test3");
        given(beerRepository.save(beer)).willReturn(beer);

        mockMvc.perform(post("/beers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(beer)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.beerName", is(beer.getName())));
    }

    @Test
    public void updateBeer() throws Exception {
        Beer beer = new Beer("test4", "test4", "test4", "test4", 4, null, "test4");
        given(beerRepository.save(beer)).willReturn(beer);

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
    }


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
