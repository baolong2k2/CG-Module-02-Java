package model.builder;

import model.entity.Planet;

public interface PlanetBuilder {
    PlanetBuilder setId(int id);
    PlanetBuilder setName(String name);
    PlanetBuilder setNamePlanet(String namePlanet);
    PlanetBuilder setDetail(String detail);
    PlanetBuilder setGalaxyName(String galaxyName);
    PlanetBuilder setMultiverseId(int multiverseId);
    PlanetBuilder setTypeOfCreature(String typeOfCreature);
    PlanetBuilder setEnvironment(String environment);
    PlanetBuilder setCivilization(String civilization);
    Planet build(); //phải có build để tạo constructor và đối tượng

}
