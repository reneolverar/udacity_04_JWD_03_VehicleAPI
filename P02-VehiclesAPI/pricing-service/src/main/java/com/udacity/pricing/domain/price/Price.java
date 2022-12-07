package com.udacity.pricing.domain.price;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Represents the price of a given vehicle, including currency.
 */
@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Price {

    @Id
    private Long vehicleId;
    private BigDecimal price;
    private String currency;
}
