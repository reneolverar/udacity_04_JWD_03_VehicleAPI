package com.udacity.pricing;

import com.google.gson.JsonObject;
import com.udacity.pricing.api.PricingController;
import com.udacity.pricing.service.PricingService;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// Defines runner class to be used to run tests, SpringRunner is good as this is a spring application
@RunWith(SpringRunner.class)
// Used to test one controller layer at a time, works with Mockito to mock dependencies. Scans only controllers
// and won´t load the full application. Need dependency beens to be injected or mocked with @MockBean
@WebMvcTest(PricingController.class)
public class PricingControllerUnitTest {
    @Autowired
    // Test MVC Controllers without need to start full HTTP server
    private MockMvc mockMvc;

    // Created a Mockito mock of the services
    @MockBean
    PricingService pricingService;

    @Test
    public void getPricing() throws Exception {
        mockMvc.perform(get("/services/price?vehicleId=1"))
//                .get("/services/price?vehicleId={vehicleId}",1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}