package tech.getarrays.garageApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarrays.garageApp.model.Car;

import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {

    void deleteCarById(Long id);

    Optional<Car> findCarById(Long id);
}
