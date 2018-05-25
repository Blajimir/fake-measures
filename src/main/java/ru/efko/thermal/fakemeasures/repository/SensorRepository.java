package ru.efko.thermal.fakemeasures.repository;

import org.springframework.data.repository.Repository;
import ru.efko.thermal.fakemeasures.model.Sensor;

import java.util.List;

public interface SensorRepository extends Repository<Sensor,Long> {
   List<Sensor> findAll();
   Sensor findOne(Long id);
}
