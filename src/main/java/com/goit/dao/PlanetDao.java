package com.goit.dao;

import com.goit.entity.Planet;

import java.util.List;

public interface PlanetDao {


     boolean createPlanet(Planet planet);

     Planet getPlanetById(Long id);

     boolean deletePlanetById(Long id);

     boolean updatePlanet(Planet planet);

     List<Planet> getAllPlanets();
}
