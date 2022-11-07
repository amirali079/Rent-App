package ui.adb.rent.service;

import ui.adb.rent.model.DTO.CarAddResponse;
import ui.adb.rent.model.DTO.CarModel;

import java.util.List;

public interface CarService {

    CarAddResponse addCar(CarModel carModel);

    CarModel getCar(Integer carId);

    List<CarModel> getCarList();


}
