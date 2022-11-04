package RentApp.model.DTO;

import lombok.Value;

@Value
public class UserLoginRequest {
    String username;
    String password;
}
