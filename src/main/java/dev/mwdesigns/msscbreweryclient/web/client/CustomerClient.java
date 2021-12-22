package dev.mwdesigns.msscbreweryclient.web.client;

import dev.mwdesigns.msscbreweryclient.web.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@ConfigurationProperties(value = "snafu.customer", ignoreUnknownFields = false)
@Component
public class CustomerClient {
    private String apihost;
    public final String CUSTOMER_API_V1 = "/api/v1/customer/";
    private final RestTemplate restTemplate;

    public CustomerClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
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

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }
}
