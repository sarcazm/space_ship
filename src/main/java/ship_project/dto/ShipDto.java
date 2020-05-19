package ship_project.dto;

import lombok.Data;
import ship_project.entity.Ship;
import ship_project.entity.ShipType;

import java.util.Date;

@Data
public class ShipDto {

    //private Long id;
    private String name;
    private String planet;
    private String type;
    private Long prodDate;
    private Boolean isUsed;
    private Double speed;
    private Integer crewSize;

    public Ship toShip(){
        Ship ship = new Ship();
        ship.setName(this.getName());
        ship.setPlanet(this.getPlanet());
        ship.setShip_type(ShipType.valueOf(this.getType()));
        ship.setProdDate(prodDate);
        ship.setIsUsed(this.getIsUsed());
        ship.setSpeed(this.getSpeed());
        ship.setCrewSize(this.getCrewSize());
        //ship.setRating(countRating());
        return ship;
    }



}
