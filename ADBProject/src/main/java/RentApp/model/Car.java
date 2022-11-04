package RentApp.model;


import RentApp.model.DTO.CarModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

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
        return new CarModel(model,year,company,description,imageURL,value,cost,isRented);
    }

}
