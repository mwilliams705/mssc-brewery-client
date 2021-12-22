package dev.mwdesigns.msscbreweryclient.web.client;

import dev.mwdesigns.msscbreweryclient.web.model.BeerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;
import java.util.UUID;

@ConfigurationProperties(value = "snafu.brewery", ignoreUnknownFields = false)
@Component
public class BreweryClient {
    private String apihost;
    public final String BEER_PATH_V1 = "/api/v1/beer/";
    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDto getBeerById(UUID beerId){
        BeerDto getDTO = restTemplate.getForObject(apihost+BEER_PATH_V1+beerId.toString(),BeerDto.class);
        System.out.println(Objects.requireNonNull(getDTO).getBeerName());
        System.out.println(getDTO.getBeerStyle());
        System.out.println("This runs in the BeerDto class");
        return getDTO;
    }

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }

}
