package ui.adb.rent.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ui.adb.rent.model.DTO.UserLoginRequest;
import ui.adb.rent.model.DTO.UserRegisterRequest;
import ui.adb.rent.model.DTO.UserResponse;
import ui.adb.rent.service.UserService;

@AllArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    // This program has a security problem because it does not use any authentication mechanism for requests.
    @PostMapping("/user/register")
    public ResponseEntity<UserResponse> saveUser(@RequestBody UserRegisterRequest userRegisterRequest) {
        return new ResponseEntity<>(userService.addUser(userRegisterRequest), HttpStatus.CREATED);
    }

    @PostMapping("/user/login")
    public ResponseEntity<UserResponse> loginUser(@RequestBody UserLoginRequest userLoginRequest) {
        return new ResponseEntity<>(userService.loginUser(userLoginRequest), HttpStatus.OK);
    }


}
