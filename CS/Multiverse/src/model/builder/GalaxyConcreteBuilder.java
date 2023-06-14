package model.builder;

import model.entity.Galaxy;

public class GalaxyConcreteBuilder implements GalaxyBuilder{
    private String nameMultiverse;
    private String detail;
    private String galaxyName;
    private Integer multiverseId;
    @Override
    public GalaxyBuilder setId(int id) {
        return this;
    }

    @Override
    public GalaxyBuilder setName(String name) {
        this.nameMultiverse = name;
        return this;
    }

    @Override
    public GalaxyBuilder setDetail(String detail) {
        this.detail = detail;
        return this;
    }

    @Override
    public GalaxyBuilder setGalaxyName(String galaxyName) {
        this.galaxyName = galaxyName;
        return this;
    }



    @Override
    public GalaxyBuilder setMultiverseId(Integer multiverseId) {
        this.multiverseId = multiverseId;
        return this;
    }

    @Override
    public Galaxy build() {
        return new Galaxy(nameMultiverse, detail, galaxyName, multiverseId);
    }
}
