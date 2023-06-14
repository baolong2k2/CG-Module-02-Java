package model.builder;

import model.entity.Planet;

public class PlanetConcreteBuilder implements PlanetBuilder{
    private String name;
    private String namePlanet;
    private String  detail;
    private String galaxyName;
    private int multiverseId;
    private String typeOfCreature;
    private String environment;
    private String civilization;
    @Override
    public PlanetBuilder setId(int id) {
        return this;
    }

    @Override
    public PlanetBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public PlanetBuilder setNamePlanet(String namePlanet) {
        this.namePlanet = namePlanet;
        return this;
    }

    @Override
    public PlanetBuilder setDetail(String detail) {
        this.detail = detail;
        return this;
    }

    @Override
    public PlanetBuilder setGalaxyName(String galaxyName) {
        this.galaxyName = galaxyName;
        return this;
    }

    @Override
    public PlanetBuilder setMultiverseId(int multiverseId) {
        this.multiverseId = multiverseId;
        return this;
    }

    @Override
    public PlanetBuilder setTypeOfCreature(String typeOfCreature) {
        this.typeOfCreature = typeOfCreature;
        return this;
    }

    @Override
    public PlanetBuilder setEnvironment(String environment) {
        this.environment = environment;
        return this;
    }

    @Override
    public PlanetBuilder setCivilization(String civilization) {
        this.civilization = civilization;
        return this;
    }

    @Override
    public Planet build() {
        return new Planet(name, detail, galaxyName, multiverseId, typeOfCreature, environment, civilization, namePlanet);
    }
}
