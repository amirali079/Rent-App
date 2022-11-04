package RentApp.model.DTO;

import lombok.Value;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Value
public class RentRequest {

    Integer carId;
    Integer userId;

    @Temporal(TemporalType.DATE)
    Date startDate;

    @Temporal(TemporalType.DATE)
    Date endDate;

    Double price;
}
