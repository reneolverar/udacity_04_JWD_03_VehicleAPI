package com.udacity.vehicles.domain.car;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.udacity.vehicles.domain.Condition;
import com.udacity.vehicles.domain.Location;
import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Transient;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "car")
@Relation(collectionRelation = "cars")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarModel extends RepresentationModel<CarModel>
{
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private Condition condition;
    private Details details;
    private Location location;
    private String price;
}







