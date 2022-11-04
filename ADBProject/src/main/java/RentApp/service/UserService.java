package RentApp.service;

import RentApp.model.DTO.*;
import RentApp.model.DTO.UserLoginRequest;
import RentApp.model.DTO.UserRegisterRequest;

public interface UserService {

    UserResponse addUser(UserRegisterRequest user);
    UserResponse loginUser(UserLoginRequest user);

}
