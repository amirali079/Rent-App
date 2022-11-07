package ui.adb.rent.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ui.adb.rent.exception.EntityNotFoundException;
import ui.adb.rent.exception.InvalidPasswordException;
import ui.adb.rent.exception.UsernameExistException;
import ui.adb.rent.model.DTO.UserLoginRequest;
import ui.adb.rent.model.DTO.UserRegisterRequest;
import ui.adb.rent.model.DTO.UserResponse;
import ui.adb.rent.model.User;
import ui.adb.rent.repository.UserRepository;

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
