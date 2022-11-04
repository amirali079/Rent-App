package RentApp.model.DTO;

import lombok.Value;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Value
public class RentResponse {

    Integer rentId;

    Integer carId;
    String carModel;

    Integer userId;
    String username;

    @Temporal(TemporalType.DATE)
    Date startDate;

    @Temporal(TemporalType.DATE)
    Date endDate;

    Double price;

}
