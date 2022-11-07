package ui.adb.rent.service;

import ui.adb.rent.model.DTO.RentAddResponse;
import ui.adb.rent.model.DTO.RentRequest;
import ui.adb.rent.model.DTO.RentResponse;

import java.util.List;

public interface RentService {

    RentAddResponse rentCar(RentRequest rentRequest);

    List<RentResponse> getRentList();

}
