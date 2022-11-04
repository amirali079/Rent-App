package RentApp.service;

import RentApp.model.DTO.RentAddResponse;
import RentApp.model.DTO.RentRequest;
import RentApp.model.DTO.RentResponse;

import java.util.List;

public interface RentService {

    RentAddResponse rentCar(RentRequest rentRequest);

    List<RentResponse> getRentList();

}
