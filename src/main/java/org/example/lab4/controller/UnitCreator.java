package org.example.lab4.controller;

import org.example.lab4.controller.Creator;
import org.example.lab4.controller.HumanCreator;
import org.example.lab4.model.CompositeUnit;
import org.example.lab4.model.Human;

public abstract class UnitCreator<T extends CompositeUnit<S>, S> implements Creator<T> {

    private final Creator<S> subunitCreator;
    private final HumanCreator humanCreator;
    private final String[] namePool;
    private final int subunitCount;
    private int nameCounter;

    protected UnitCreator(Creator<S> subunitCreator, HumanCreator humanCreator,
                          String[] namePool, int subunitCount) {
        this.subunitCreator = subunitCreator;
        this.humanCreator = humanCreator;
        this.namePool = namePool;
        this.subunitCount = subunitCount;
    }

    @Override
    public T create() {
        return create(nextName());
    }

    public T create(String name) {
        T unit = createUnit(name, humanCreator.create());
        for (int i = 0; i < subunitCount; i++) {
            unit.addSubunit(subunitCreator.create());
        }
        return unit;
    }

    protected abstract T createUnit(String name, Human head);

    private String nextName() {
        String name = namePool[nameCounter % namePool.length];
        int cycle = nameCounter / namePool.length;
        nameCounter++;
        return cycle == 0 ? name : name + " (" + (cycle + 1) + ")";
    }
}