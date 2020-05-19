package ship_project.entity;


import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

@Entity
@Table(name = "shipnew")
@Data
public class Ship {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name", length = 50)
    private String name;
    @Column(name = "planet", length = 50)
    private String planet;
    @Enumerated(EnumType.STRING)
    @Column(name = "ship_type")
    private ShipType ship_type;
    //2800-3019 date дата выпуска
    @Column(name = "prod_date")
    private Long prodDate;
    //used or new
    @Column(name = "is_used")
    private Boolean isUsed;
    //max speed ship 0.01...0.99
    @Column(name = "speed")
    private Double speed;
    //кол-во членов экипажа
    @Column(name = "crew_size")
    private Integer crewSize;
    @Column(name = "rating")
    private Double rating;

}
