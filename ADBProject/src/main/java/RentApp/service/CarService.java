package RentApp.service;

import RentApp.model.DTO.CarAddResponse;
import RentApp.model.DTO.CarModel;

import java.util.List;

public interface CarService {

    CarAddResponse addCar(CarModel carModel);

    CarModel getCar(Integer carId);

    List<CarModel> getCarList();


}
