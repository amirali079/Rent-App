package ui.adb.rent.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ui.adb.rent.model.DTO.RentAddResponse;
import ui.adb.rent.model.DTO.RentRequest;
import ui.adb.rent.model.DTO.RentResponse;
import ui.adb.rent.service.RentService;

import java.util.List;

@AllArgsConstructor
@RestController
public class RentController {

    private final RentService rentService;

    @PostMapping("/rent")
    public ResponseEntity<RentAddResponse> rentCar(@RequestBody RentRequest rentRequest) {
        return new ResponseEntity<>(rentService.rentCar(rentRequest), HttpStatus.CREATED);
    }

    @GetMapping("/rents")
    public ResponseEntity<List<RentResponse>> getRentList() {
        return new ResponseEntity<>(rentService.getRentList(), HttpStatus.OK);
    }

}
