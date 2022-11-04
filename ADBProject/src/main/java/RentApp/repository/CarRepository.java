package RentApp.repository;

import RentApp.model.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car , Integer> {
}
