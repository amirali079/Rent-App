package ui.adb.rent.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ui.adb.rent.model.DTO.CarModel;

import javax.persistence.*;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@Data
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String model;
    private Integer year;
    private String company;
    private String description;
    private String imageURL;
    private Double value;
    private Double cost;
    private Boolean isRented;

    public CarModel carModel() {
        return new CarModel(id, model, year, company, description, imageURL, value, cost, isRented);
    }

}
