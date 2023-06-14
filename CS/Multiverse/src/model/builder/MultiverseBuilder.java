package model.builder;

import model.entity.Multiverse;

public interface MultiverseBuilder {
    MultiverseBuilder setID(int id);
    MultiverseBuilder setNameMultiverse(String nameMultiverse);
    MultiverseBuilder setDetail(String detail);
    Multiverse build();
}
