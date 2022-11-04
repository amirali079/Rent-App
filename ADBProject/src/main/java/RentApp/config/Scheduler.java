package RentApp.config;

import RentApp.model.Car;
import RentApp.repository.CarRepository;
import RentApp.repository.RentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Configuration
@EnableScheduling
@AllArgsConstructor
@Slf4j
public class Scheduler {

    private final CarRepository carRepository;
    private final RentRepository rentRepository;

    @Scheduled(cron = "0 1 0 * * *") // this means cronJobSch function run every day at 00:01
    public void cronJobSch() {

        Date now = new Date();
        rentRepository.findAll().forEach(rent ->
        {
            log.info("rent: "+rent.toString() +" checked!");
            if (rent.getEndDate().before(now)) {
                Car car = carRepository.findById(rent.getCar().getId()).get();
                car.setIsRented(false);
                log.info("date: "+rent.getEndDate()+" ---now: "+now+" __car: "+car.toString());
                carRepository.save(car);

            }
        });

    }
}