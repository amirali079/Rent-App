package RentApp.model.DTO;

import lombok.Value;

@Value
public class UserRegisterRequest {

     String username;
     String password;
     String name;
     String phoneNumber;


}
