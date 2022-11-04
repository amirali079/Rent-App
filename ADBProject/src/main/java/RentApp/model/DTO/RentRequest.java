package RentApp.model.DTO;

import lombok.Value;

import java.sql.Date;

@Value
public class RentRequest {

    Integer carId;
    Integer userId;

    Date startDate;
    Date endDate;

    Double price;
}
