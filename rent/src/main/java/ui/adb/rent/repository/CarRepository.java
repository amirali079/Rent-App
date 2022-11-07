package ui.adb.rent.repository;

import org.springframework.data.repository.CrudRepository;
import ui.adb.rent.model.Car;

public interface CarRepository extends CrudRepository<Car, Integer> {
}
