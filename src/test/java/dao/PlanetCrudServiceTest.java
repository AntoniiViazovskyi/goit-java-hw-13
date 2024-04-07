package dao;


import com.goit.dao.PlanetCrudService;
import com.goit.entity.Planet;
import com.goit.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PlanetCrudServiceTest {
    PlanetCrudService planetCrudService = new PlanetCrudService();
    Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
    Transaction transaction;

    @Test
    void addingNewPlanet(){
        transaction = session.beginTransaction();
        Assertions.assertTrue(planetCrudService.createPlanet(new Planet("JOE")));
        transaction.rollback();
    }

    @Test
    void gettingPlanetById(){
        transaction = session.beginTransaction();
        Planet planet = planetCrudService.getPlanetById(3L);
        Assertions.assertEquals("MOON",planet.getName());
        transaction.rollback();
    }

    @Test
    void updatingClient(){
        transaction = session.beginTransaction();
        Planet planet= planetCrudService.getPlanetById(1L);
        planet.setName("MARSO");
        planetCrudService.updatePlanet(planet);
        Assertions.assertEquals("MARSO",planetCrudService.getPlanetById(1L).getName());
        transaction.rollback();
    }

    @Test
    void gettingListOfPlanets(){
        transaction = session.beginTransaction();
        List<Planet> planets = planetCrudService.getAllPlanets();
        Assertions.assertNotEquals(null,planets);
        transaction.rollback();
    }
    @Test
    void deleteClient(){
        transaction = session.beginTransaction();
        Assertions.assertTrue(planetCrudService.deletePlanetById(7L));
        transaction.rollback();
    }
}
