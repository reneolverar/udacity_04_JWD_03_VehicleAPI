package com.udacity.vehicles.api;

import com.udacity.vehicles.domain.car.Car;
import com.udacity.vehicles.domain.car.CarModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CarModelAssembler
        extends RepresentationModelAssemblerSupport<Car, CarModel> {

    public CarModelAssembler() {
        super(CarController.class, CarModel.class);
    }

    @Override
    public CarModel toModel(Car car)
    {
        CarModel carModel = instantiateModel(car);

        carModel.add(linkTo(
                methodOn(CarController.class)
                        .get(car.getId()))
                .withSelfRel());

        carModel.setId(car.getId());
        carModel.setCreatedAt(car.getCreatedAt());
        carModel.setModifiedAt(car.getModifiedAt());
        carModel.setCondition(car.getCondition());
        carModel.setDetails(car.getDetails());
        carModel.setLocation(car.getLocation());
        carModel.setPrice(car.getPrice());
        return carModel;
    }

    @Override
    public CollectionModel<CarModel> toCollectionModel(Iterable<? extends Car> entities)
    {
        CollectionModel<CarModel> carModels = super.toCollectionModel(entities);
        carModels.add(linkTo(methodOn(CarController.class).list()).withSelfRel());
        return carModels;
    }
}
