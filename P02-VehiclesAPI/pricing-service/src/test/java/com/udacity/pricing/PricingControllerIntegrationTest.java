package com.udacity.pricing;

import com.udacity.pricing.domain.price.Price;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

// Defines runner class to be used to run tests, SpringRunner is good as this is a spring application
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// Simulates calling the code from the client as if we were processing a real HTTP request
@AutoConfigureMockMvc
public class PricingControllerIntegrationTest {
    @LocalServerPort
    private int port;

    @Autowired
    // Allows us to consume REST APIs in a testing scenario programmatically
    private TestRestTemplate restTemplate;

    @Test
    public void getPricing() {
        ResponseEntity<Price> response =
                  this.restTemplate.getForEntity("http://localhost:" + port + "/prices/1", Price.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }
}