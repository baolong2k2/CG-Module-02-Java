package model.entity;

public class Planet extends Galaxy{
    private String typeOfCreature;
    private String environment;
    private String civilization;
    private String namePlanet;
    public Planet(int id, String name, String detail) {
        super(id, name, detail);
    }

    public Planet(String name, String detail) {
        super(name, detail);
    }

    public Planet(int id, String name, String detail, String galaxyName, int multiverseId) {
        super(id, name, detail, galaxyName, multiverseId);
    }

    public Planet(String name, String detail, String galaxyName, int multiverseId) {
        super(name, detail, galaxyName, multiverseId);
    }

    public Planet(int id, String name, String detail, String typeOfCreature, String environment, String civilization) {
        super(id, name, detail);
        this.typeOfCreature = typeOfCreature;
        this.environment = environment;
        this.civilization = civilization;
    }

    public Planet(String name, String detail, String typeOfCreature, String environment, String civilization) {
        super(name, detail);
        this.typeOfCreature = typeOfCreature;
        this.environment = environment;
        this.civilization = civilization;
    }

    public Planet(int id, String name, String detail, String galaxyName, int multiverseId, String typeOfCreature, String environment, String civilization) {
        super(id, name, detail, galaxyName, multiverseId);
        this.typeOfCreature = typeOfCreature;
        this.environment = environment;
        this.civilization = civilization;
    }

    public Planet(String name, String detail, String galaxyName, int multiverseId, String typeOfCreature, String environment, String civilization) {
        super(name, detail, galaxyName, multiverseId);
        this.typeOfCreature = typeOfCreature;
        this.environment = environment;
        this.civilization = civilization;
    }

    public Planet(int id, String name, String detail, String galaxyName, int multiverseId, String typeOfCreature, String environment, String civilization, String namePlanet) {
        super(id, name, detail, galaxyName, multiverseId);
        this.typeOfCreature = typeOfCreature;
        this.environment = environment;
        this.civilization = civilization;
        this.namePlanet = namePlanet;
    }

    public Planet(String name, String detail, String galaxyName, int multiverseId, String typeOfCreature, String environment, String civilization, String namePlanet) {
        super(name, detail, galaxyName, multiverseId);
        this.typeOfCreature = typeOfCreature;
        this.environment = environment;
        this.civilization = civilization;
        this.namePlanet = namePlanet;
    }

    public String getTypeOfCreature() {
        return typeOfCreature;
    }

    public void setTypeOfCreature(String typeOfCreature) {
        this.typeOfCreature = typeOfCreature;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getCivilization() {
        return civilization;
    }

    public void setCivilization(String civilization) {
        this.civilization = civilization;
    }

    public String getNamePlanet() {
        return namePlanet;
    }

    public void setNamePlanet(String namePlanet) {
        this.namePlanet = namePlanet;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "typeOfCreature='" + typeOfCreature + '\'' +
                ", environment='" + environment + '\'' +
                ", civilization='" + civilization + '\'' +
                '}';
    }
}
