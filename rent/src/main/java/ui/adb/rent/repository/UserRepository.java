package ui.adb.rent.repository;

import org.springframework.data.repository.CrudRepository;
import ui.adb.rent.model.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByUsername(String name);
}
