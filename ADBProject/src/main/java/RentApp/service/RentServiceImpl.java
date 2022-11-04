package RentApp.service;

import RentApp.exception.CarIsRentedException;
import RentApp.exception.EntityNotFoundException;
import RentApp.model.Car;
import RentApp.model.DTO.RentAddResponse;
import RentApp.model.DTO.RentRequest;
import RentApp.model.DTO.RentResponse;
import RentApp.model.Rent;
import RentApp.model.User;
import RentApp.repository.CarRepository;
import RentApp.repository.RentRepository;
import RentApp.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class RentServiceImpl implements RentService {

    private final RentRepository rentRepository;
    private final CarRepository carRepository;
    private final UserRepository userRepository;


    @Override
    public RentAddResponse rentCar(RentRequest rentRequest) {
        User user = checkUserId(rentRequest.getUserId());
        Car car = checkCarId(rentRequest.getCarId());

        if (car.getIsRented())
            throw new CarIsRentedException();

        car.setIsRented(true);
        carRepository.save(car);

        return new RentAddResponse(rentRepository.save(Rent.builder().car(car).user(user)
                .startDate(rentRequest.getStartDate()).endDate(rentRequest.getEndDate())
                .price(rentRequest.getPrice()).build()).getId());
    }

    @Override
    public List<RentResponse> getRentList() {

        List<RentResponse> rents = new ArrayList<>();
        rentRepository.findAll().forEach(rent -> rents.add(rent.rentResponse()));

        return rents;
    }


    private User checkUserId(Integer id) {
        Optional<User> loaded = userRepository.findById(id);
        if (loaded.isEmpty())
            throw new EntityNotFoundException(User.class.getName(), id.toString());
        return loaded.get();
    }

    private Car checkCarId(Integer id) {
        Optional<Car> loaded = carRepository.findById(id);
        if (loaded.isEmpty())
            throw new EntityNotFoundException(Car.class.getName(), id.toString());
        return loaded.get();
    }
}
