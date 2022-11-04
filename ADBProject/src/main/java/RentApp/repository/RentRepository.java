package RentApp.repository;

import RentApp.model.Rent;
import org.springframework.data.repository.CrudRepository;

public interface RentRepository extends CrudRepository<Rent, Integer> {
}
