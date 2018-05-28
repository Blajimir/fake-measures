package ru.efko.thermal.fakemeasures.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.efko.thermal.fakemeasures.model.Measure;
import ru.efko.thermal.fakemeasures.model.Sensor;
import ru.efko.thermal.fakemeasures.repository.MeasureRepository;
import ru.efko.thermal.fakemeasures.repository.SensorRepository;
import ru.efko.thermal.fakemeasures.service.ServiceFakeMeasures;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class ServiceFakeMeasuresImpl implements ServiceFakeMeasures {
    private final Random random = new Random();
    @Autowired
    private MeasureRepository measureRepository;
    @Autowired
    private SensorRepository sensorRepository;

    @Override
    public void saveFakeMeasures() {
        List<Measure> measureList = sensorRepository.findAll().stream()
                .filter(Sensor::getActive)
                .map(this::generateMeasure).collect(Collectors.toList());
        measureRepository.saveAll(measureList);
    }

    public Measure generateMeasure(Sensor sensor){
        Measure measure = new Measure();
        measure.setDeviceId(sensor.getId());
        measure.setFakeValue(0.0);
        measure.setDate(new Date());
        measure.setValue(this.generateRandomTemp(sensor));
        return measure;
    }

    private Double generateRandomTemp(Sensor sensor) {
        return sensor.getMinValue() + (sensor.getMaxValue() + sensor.getMinValue()) * random.nextDouble();
    }
}
