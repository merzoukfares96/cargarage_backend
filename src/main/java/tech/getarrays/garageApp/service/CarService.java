package tech.getarrays.garageApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.garageApp.exception.UserNotFoundException;
import tech.getarrays.garageApp.model.Car;
import tech.getarrays.garageApp.repo.CarRepository;

import java.util.List;

@Service
public class CarService {
    private final CarRepository carRepo;

    @Autowired
    public CarService(CarRepository carRepo) {
        this.carRepo = carRepo;
    }

    public Car addCar(Car car) {
        return carRepo.save(car);
    }

    public List<Car> findAllCars() {
        return carRepo.findAll();
    }

    public Car updateCar(Car car) {
        return carRepo.save(car);
    }

    public Car findCarById(Long id) {
        return carRepo.findCarById(id).orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found !"));
    }

    public void deleteCar(Long id) {
        carRepo.deleteCarById(id);
    }
}
