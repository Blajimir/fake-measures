package ru.efko.thermal.fakemeasures.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "measure", indexes = @Index(name = "measure_idx_by_dev_date", columnList = "date,device"))
@Data
@NoArgsConstructor
public class Measure {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "measure_seq")
    @SequenceGenerator(name = "measure_seq", sequenceName = "measure_id_seq", allocationSize = 1)
    private Long id;
    @JoinColumn(name = "device_id", foreignKey = @ForeignKey(name = "none"))
    private Long device_id;
    @Column(precision = 16, scale = 2)
    private Double value;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(precision = 16, scale = 2)
    private Double fakeValue;
}
