package ru.efko.thermal.fakemeasures.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.efko.thermal.fakemeasures.model.Measure;

public interface MeasureRepository extends JpaRepository<Measure, Long> {
    Measure findByDevice_id(Long sensorId);
}
