package dev.mwdesigns.msscbreweryclient.web.client;

import dev.mwdesigns.msscbreweryclient.web.model.BeerDto;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient breweryClient;

    @Test
    void getBeerById() {
        BeerDto dto = breweryClient.getBeerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void saveNewBeer(){
        BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();
        URI uri = breweryClient.saveNewBeer(beerDto);

        System.out.println(uri.toString());
        assertNotNull(uri);

    }

    @Test
    void updateBeer(){
        BeerDto beerDto = BeerDto.builder().beerName("Update Beer").build();
        breweryClient.updateBeer(UUID.randomUUID(),beerDto);
    }

    @Test
    void deleteBeer(){
        breweryClient.deleteBeer(UUID.randomUUID());
    }
}