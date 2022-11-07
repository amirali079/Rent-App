package ui.adb.rent.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ui.adb.rent.exception.EntityNotFoundException;
import ui.adb.rent.model.Car;
import ui.adb.rent.model.DTO.CarAddResponse;
import ui.adb.rent.model.DTO.CarModel;
import ui.adb.rent.repository.CarRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class CarServiceImpl implements CarService {

    CarRepository carRepository;

    @Override
    public CarAddResponse addCar(CarModel carModel) {

        Car createdCar = Car.builder().company(carModel.getCompany()).description(carModel.getDescription())
                .model(carModel.getModel()).year(carModel.getYear()).value(carModel.getValue())
                .cost(carModel.getCost()).isRented(carModel.getIsRented()).imageURL(carModel.getImageURL())
                .build();

        return new CarAddResponse(carRepository.save(createdCar).getId());
    }

    @Override
    public CarModel getCar(Integer carId) {
        return checkCarId(carId).carModel();
    }

    @Override
    public List<CarModel> getCarList() {

        List<CarModel> cars = new ArrayList<>();

        carRepository.findAll().forEach(car -> cars.add(car.carModel()));

        return cars;
    }

    private Car checkCarId(Integer id) {
        Optional<Car> loaded = carRepository.findById(id);
        if (loaded.isEmpty())
            throw new EntityNotFoundException(Car.class.getName(), id.toString());
        return loaded.get();
    }
}
