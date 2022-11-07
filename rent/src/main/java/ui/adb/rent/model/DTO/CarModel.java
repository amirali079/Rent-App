package ui.adb.rent.model.DTO;

import lombok.Value;

@Value
public class CarModel {

    Integer id;
    String model;
    Integer year;
    String company;
    String description;
    String imageURL;
    Double value;
    Double cost;
    Boolean isRented;
}
