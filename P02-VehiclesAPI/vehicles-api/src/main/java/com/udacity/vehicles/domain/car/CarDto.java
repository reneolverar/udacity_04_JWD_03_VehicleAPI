package com.udacity.vehicles.domain.car;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.udacity.vehicles.domain.Condition;
import com.udacity.vehicles.domain.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class CarDto {
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private Condition condition;
    private Details details;
    private Location location;
    private String price;
    @JsonIgnore
    private String _links;
}
