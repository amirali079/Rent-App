package ui.adb.rent.model.DTO;

import lombok.Value;

import java.util.Date;

@Value
public class RentRequest {

    Integer carId;
    Integer userId;
    Date startDate;
    Date endDate;

    Double price;
}
