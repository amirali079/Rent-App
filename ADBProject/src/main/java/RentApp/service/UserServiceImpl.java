package RentApp.service;

import RentApp.exception.CarIsRentedException;
import RentApp.exception.EntityNotFoundException;
import RentApp.exception.InvalidPasswordException;
import RentApp.exception.UsernameExistException;
import RentApp.model.Car;
import RentApp.model.DTO.RentResponse;
import RentApp.model.DTO.UserLoginRequest;
import RentApp.model.DTO.UserRegisterRequest;
import RentApp.model.DTO.UserResponse;
import RentApp.model.Rent;
import RentApp.model.User;
import RentApp.repository.CarRepository;
import RentApp.repository.RentRepository;
import RentApp.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponse addUser(UserRegisterRequest user) {
        Optional<User> loaded = userRepository.findByUsername(user.getUsername());
        if (loaded.isPresent())
            throw new UsernameExistException(user.getUsername());

        User createdUser = User.builder().username(user.getUsername()).password(user.getPassword())
                .phoneNumber(user.getPhoneNumber()).name(user.getName()).build();

        return new UserResponse(userRepository.save(createdUser).getId());
    }

    @Override
    public UserResponse loginUser(UserLoginRequest user) {
        Optional<User> loaded = userRepository.findByUsername(user.getUsername());
        if (loaded.isEmpty())
            throw new EntityNotFoundException(User.class.getName(), user.getUsername());
        if (!loaded.get().getPassword().equals(user.getPassword()))
            throw new InvalidPasswordException();
        return new UserResponse(loaded.get().getId());
    }



}
