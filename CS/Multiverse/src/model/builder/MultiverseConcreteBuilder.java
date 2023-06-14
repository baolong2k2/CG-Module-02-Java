package model.builder;

import model.entity.Multiverse;

public class MultiverseConcreteBuilder implements MultiverseBuilder{
    private String nameMultiverse;
    private String detail;
    @Override
    public MultiverseBuilder setID(int id) {
        return this;
    }

    @Override
    public MultiverseBuilder setNameMultiverse(String nameMultiverse) {
        this.nameMultiverse = nameMultiverse;
        return this;
    }

    @Override
    public MultiverseBuilder setDetail(String detail) {
        this.detail = detail;
        return this;
    }

    @Override
    public Multiverse build() {
        return new Multiverse(nameMultiverse,detail);
    }
}
