package ship_project.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import ship_project.entity.Ship;
import ship_project.service.ShipService;

import java.util.List;
import java.util.Map;



@RestController
@RequestMapping(value = "/ships")
public class ShipRestController {
    private final ShipService shipService;


    @Autowired
    public ShipRestController(ShipService shipService) {
        this.shipService = shipService;

    }

    @GetMapping("/{id}")
    public ResponseEntity<Ship> getById(@PathVariable("id") Integer id){
        Ship result = shipService.getById(id);
        if (id == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        if (result == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<Ship>(result, HttpStatus.OK);


    }

    @GetMapping()
    public ResponseEntity<List<Ship>> getAllShips(){
        List<Ship> result = shipService.getAll();
        return new ResponseEntity<List<Ship>>(result, HttpStatus.OK);
    }
    @GetMapping("/count")
    public ResponseEntity<List<Ship>> getByCount(@RequestParam Map<String, String> allParam){
        List<Ship> resultList = shipService.getCountBy(allParam);
        if (resultList == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(resultList, HttpStatus.OK);
    }


    @PostMapping()
    public ResponseEntity<Ship> add(@RequestBody Ship ship){
        Ship result = shipService.add(ship);
        System.out.println(ship);
        return new ResponseEntity<Ship>(result, HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Ship> update(@PathVariable("id") Integer id, @RequestBody Ship ship){
        Ship result = shipService.updateById(id, ship);
        //System.out.println(shipStr);
        if (result == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<Ship>(result, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    //@RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Ship> delete(@PathVariable("id") Integer id){
        if (id == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        try {
            Ship ship = shipService.deleteById(id);
        }catch (IllegalArgumentException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
