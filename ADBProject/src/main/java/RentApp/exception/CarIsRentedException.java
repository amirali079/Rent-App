package RentApp.exception;

public class CarIsRentedException extends RuntimeException {
    public  CarIsRentedException(){super("this car is already rented!");}
}
