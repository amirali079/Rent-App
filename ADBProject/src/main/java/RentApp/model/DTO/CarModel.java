package RentApp.model.DTO;

import lombok.Value;

@Value
public class CarModel {

    String model;
    Integer year;
    String company;
    String description;
    String imageURL;
    Double value;
    Double cost;
    Boolean isRented;
}
