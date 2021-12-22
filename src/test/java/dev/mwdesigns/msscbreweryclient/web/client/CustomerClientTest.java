package dev.mwdesigns.msscbreweryclient.web.client;

import dev.mwdesigns.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerClientTest {

    @Autowired
    CustomerClient customerClient;


    @Test
    void getCustomerById() {
        CustomerDto customerDto = customerClient.getCustomerById(UUID.randomUUID());
        assertNotNull(customerDto);
    }

    @Test
    void saveNewCustomer() {
        CustomerDto customerDto = CustomerDto.builder()
                .name("Mark Williams")
                .build();
        URI uri = customerClient.saveNewCustomer(customerDto);
        assertNotNull(uri);

    }

    @Test
    void updateCustomer() {

        CustomerDto customerDto = CustomerDto.builder()
                .name("Lyndsey Williams")
                .build();
        customerClient.updateCustomer(UUID.randomUUID(),customerDto);

    }

    @Test
    void deleteCustomer() {
        customerClient.deleteCustomer(UUID.randomUUID());
    }
}