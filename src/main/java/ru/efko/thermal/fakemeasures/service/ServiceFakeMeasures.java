package ru.efko.thermal.fakemeasures.service;

import ru.efko.thermal.fakemeasures.model.Measure;
import ru.efko.thermal.fakemeasures.model.Sensor;

public interface ServiceFakeMeasures {
    void saveFakeMeasures();
    Measure generateMeasure(Sensor sensor);
}
