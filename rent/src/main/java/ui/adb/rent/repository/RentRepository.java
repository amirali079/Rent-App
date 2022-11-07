package ui.adb.rent.repository;

import org.springframework.data.repository.CrudRepository;
import ui.adb.rent.model.Rent;

public interface RentRepository extends CrudRepository<Rent, Integer> {
}
