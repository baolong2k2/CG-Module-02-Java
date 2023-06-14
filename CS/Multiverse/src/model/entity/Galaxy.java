package model.entity;

public class Galaxy extends Multiverse{
    private String galaxyName;
    private int multiverseId;


    public Galaxy(int id, String name, String detail) {
        super(id, name, detail);
    }

    public Galaxy(String name, String detail) {
        super(name, detail);
    }

    public Galaxy(int id, String name, String detail, String galaxyName, int multiverseId) {
        super(id, name, detail);
        this.galaxyName = galaxyName;
        this.multiverseId = multiverseId;
    }

    public Galaxy(String name, String detail, String galaxyName, int multiverseId) {
        super(name, detail);
        this.galaxyName = galaxyName;
        this.multiverseId = multiverseId;
    }

    public String getGalaxyName() {
        return galaxyName;
    }

    public void setGalaxyName(String galaxyName) {
        this.galaxyName = galaxyName;
    }

    public int getMultiverseId() {
        return multiverseId;
    }

    public void setMultiverseId(int multiverseId) {
        this.multiverseId = multiverseId;
    }

    @Override
    public String toString() {
        return String.format("""
                🌌 GALAXY 🌌
                Galaxy id: %s
                Multiverse name: %s
                Galaxy name: %s
                """,getId(),getName(),getGalaxyName());
    }
}
