package dev.mwdesigns.msscbreweryclient.web.client;

import dev.mwdesigns.msscbreweryclient.web.model.BeerDto;
import dev.mwdesigns.msscbreweryclient.web.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@ConfigurationProperties(prefix = "snafu.brewery", ignoreUnknownFields = false)
@Component
public class BreweryClient {
    private String apihost;
    public final String BEER_PATH_V1 = "/api/v1/beer/";
    public final String CUSTOMER_API_V1 = "/api/v1/customer/";
    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDto getBeerById(UUID beerId){

        return restTemplate.getForObject(apihost+BEER_PATH_V1+beerId.toString(),BeerDto.class);
    }

    public URI saveNewBeer(BeerDto beerDto){
        return restTemplate.postForLocation(apihost+BEER_PATH_V1, beerDto);
    }

    public void updateBeer(UUID beerId, BeerDto beerDto){
        restTemplate.put(apihost+BEER_PATH_V1+beerId.toString(), beerDto);
    }

    public void deleteBeer(UUID beerId){
        restTemplate.delete(apihost+BEER_PATH_V1+beerId.toString());
    }

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }

    public CustomerDto getCustomerById(UUID customerId){
        return restTemplate.getForObject(apihost+CUSTOMER_API_V1+customerId.toString(),CustomerDto.class);

    }

    public URI saveNewCustomer(CustomerDto customerDto){
        return restTemplate.postForLocation(apihost+CUSTOMER_API_V1,customerDto);
    }

    public void updateCustomer(UUID customerId, CustomerDto customerDto){
        restTemplate.put(apihost+CUSTOMER_API_V1+customerId.toString(),customerDto);
    }

    public void deleteCustomer(UUID customerId){
        restTemplate.delete(apihost+CUSTOMER_API_V1+customerId.toString());
    }

}
