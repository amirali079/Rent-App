package RentApp.model.DTO;

import lombok.Value;

import java.util.Date;

@Value
public class RentResponse {

    Integer rentId;

    Integer carId;
    String carModel;

    Integer userId;
    String username;

    Date startDate;
    Date endDate;

    Double price;

}
