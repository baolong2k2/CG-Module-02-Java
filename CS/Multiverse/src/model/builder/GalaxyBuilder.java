package model.builder;

import model.entity.Galaxy;

public interface GalaxyBuilder {
    GalaxyBuilder setId (int id);
    GalaxyBuilder setName (String name);
    GalaxyBuilder setDetail (String detail);
    GalaxyBuilder setGalaxyName (String galaxyName);
    GalaxyBuilder setMultiverseId (Integer multiverseId);
    Galaxy build ();

}
