package ru.efko.thermal.fakemeasures.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;
import ru.efko.thermal.fakemeasures.model.Sensor;

import java.util.List;

public interface SensorRepository  extends JpaRepository<Sensor, Long> {//extends Repository<Sensor,Long> {
   //List<Sensor> findAll();
   //Sensor findOne(Long id);
}
