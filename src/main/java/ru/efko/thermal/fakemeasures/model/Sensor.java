package ru.efko.thermal.fakemeasures.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "sensor", schema = "sensor")
@Data
@NoArgsConstructor
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sensor_seq")
    @SequenceGenerator(name = "sensor_seq", sequenceName = "sensor_id_seq", allocationSize = 1)
    private Long id;
    @JoinColumn(name = "station_id", foreignKey = @ForeignKey(name = "sensor_station_id_fkey"))
    private Long stationId;
    @Column(name = "item_name")
    private String itemName;
    private Boolean active;
    private String comment;
    @Column(name = "channel_id")
    private Integer channelId;
    @Column(name = "measure_type")
    private String measureType;
    private Boolean fake;
    @Column(name = "min_value", precision = 16, scale = 2)
    private Double minValue;
    @Column(name = "max_value", precision = 16, scale = 2)
    private Double maxValue;
    @JoinColumn(name = "sensor_group_id", foreignKey = @ForeignKey(name = "sensor_sensor_group_id_fkey"))
    private Long sensorGroup;
    @Column(name = "absolute_deviation", precision = 8)
    private Double absoluteDeviation;
    @Column(name = "min_input_threshold", precision = 8)
    private Double minInputThreshold;
    @Column(name = "max_input_threshold", precision = 8)
    private Double maxInputThreshold;
}
