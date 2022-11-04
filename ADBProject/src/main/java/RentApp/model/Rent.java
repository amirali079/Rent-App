package RentApp.model;


import RentApp.model.DTO.RentResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@Data
@Entity
@Table
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    private Car car;

    @OneToOne
    private User user;

    private Date startDate;
    private Date endDate;

    private Double price;

    public RentResponse rentResponse(){
        return new RentResponse(id,car.getId(),car.getModel(),user.getId(),user.getUsername(),startDate,endDate,price);
    }

}