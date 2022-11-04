package RentApp.config;

import RentApp.model.Car;
import RentApp.repository.CarRepository;
import RentApp.repository.RentRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Configuration
@EnableScheduling
@AllArgsConstructor
public class Scheduler {

    private final CarRepository carRepository;
    private final RentRepository rentRepository;

    @Scheduled(cron = "1 0 0 * * ?")
    public void cronJobSch() {

        Date now = new Date();
        rentRepository.findAll().forEach(rent ->
        {
            if (rent.getEndDate().before(now)) {
                Car car = carRepository.findById(rent.getCar().getId()).get();
                car.setIsRented(false);
                carRepository.save(car);
            }
        });

    }
}