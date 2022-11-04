package RentApp.controller;

import RentApp.model.DTO.CarAddResponse;
import RentApp.model.DTO.CarModel;
import RentApp.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class CarController {

    private final CarService carService;

    @PostMapping("/car")
    public ResponseEntity<CarAddResponse> addCar(@RequestBody CarModel carModel) {
        return new ResponseEntity<>(carService.addCar(carModel), HttpStatus.OK);
    }

    @GetMapping("/car/{id}")
    public ResponseEntity<CarModel> getCar(@PathVariable Integer id) {
        return new ResponseEntity<>(carService.getCar(id), HttpStatus.OK);
    }

    @GetMapping("/cars")
    public ResponseEntity<List<CarModel>> getCarList() {
        return new ResponseEntity<>(carService.getCarList(), HttpStatus.OK);
    }

}
