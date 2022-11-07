package ui.adb.rent.service;

import ui.adb.rent.model.DTO.UserLoginRequest;
import ui.adb.rent.model.DTO.UserRegisterRequest;
import ui.adb.rent.model.DTO.UserResponse;

public interface UserService {

    UserResponse addUser(UserRegisterRequest user);

    UserResponse loginUser(UserLoginRequest user);

}
