package ship_project.service;





import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import ship_project.entity.Ship;

import ship_project.helper.ShipHelper;

import java.util.*;


@Service
//@Slf4j
public class ShipService {
    private final SessionFactory sessionFactory;

    @Autowired
    public ShipService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Ship getById(Integer id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Ship result = session.get(Ship.class, id);
        //log.info("IN findById - ship: {} found by id: {}", result, id);
        session.flush();
        session.close();

        return result;
    }

    public Ship add(Ship ship){
        try {
            if (!(ShipHelper.smthNotforAddMethod(ship).equals("")))
                throw new RuntimeException();
                //return "{\"Error\":\"" + ShipHelper.smthNotforAddMethod(ship) + "\"}";
        }catch (RuntimeException e){
            System.out.println("{\"Error\":\"" + ShipHelper.smthNotforAddMethod(ship) + "\"}");
            return null;
        }
        ship.setRating(ShipHelper.countRating(ship));
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        //log.info("IN add - ship: {}", ship);
        session.save(ship);
        session.flush();
        session.close();
        return ship;
    }

    public List<Ship> getAll(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Ship> result = session.createCriteria(Ship.class).list();
        //log.info("IN findById - ship: {} found by id: {}", result, id);
        session.flush();
        session.close();
        return result;
    }

    public Ship updateById(Integer id, Ship newDataShip){



        try {
            if (!(ShipHelper.smthNotforAddMethod(newDataShip).equals("")))
                throw new RuntimeException();
        }catch (RuntimeException e){
            System.out.println("{\"Error\":\"" + ShipHelper.smthNotforUpdateMethod(newDataShip) + "\"}");
            return null;
        }
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Ship result = session.get(Ship.class, id);
        result = ShipHelper.updateByFields(result, newDataShip);
        session.update(result);
        session.flush();
        session.close();
        return result;
    }



    public Ship deleteById(Integer id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Ship result = session.get(Ship.class, id);
        //log.info("IN findById - ship: {} found by id: {}", result, id);
        session.remove(result);
        session.flush();
        session.close();
        return result;
    }

    public List<Ship> getCountBy(Map<String, String> allParam) {
        String hql = ShipHelper.createHqlQuery(allParam.keySet(), new ArrayList<String>(allParam.values()));
        List<Ship> resultList;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery(hql);
        resultList = query.list();
        session.flush();
        session.close();
        return resultList;

    }






}
