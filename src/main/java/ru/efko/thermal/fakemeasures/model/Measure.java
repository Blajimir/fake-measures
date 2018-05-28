package ru.efko.thermal.fakemeasures.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
//@Table(name = "measure", indexes = @Index(name = "measure_idx_by_dev_date", columnList = "date,device_id"))
@Table(name = "measure", schema = "sensor", indexes = @Index(name = "measure_idx_by_dev_date", columnList = "date,device_id"))
@Data
@NoArgsConstructor
public class Measure {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "measure_seq")
    @SequenceGenerator(name = "measure_seq", sequenceName = "measure_id_seq", allocationSize = 1)
    private Long id;
    @Column(name = "device_id")
    private Long deviceId;
    @Column(precision = 16, scale = 2)
    private Double value;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(precision = 16, scale = 2)
    private Double fakeValue;
}
