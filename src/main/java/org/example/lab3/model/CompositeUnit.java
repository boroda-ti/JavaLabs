package org.example.lab3.model;

import org.example.lab3.model.Human;
import org.example.lab3.model.StructuralUnit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public abstract class CompositeUnit<T> extends StructuralUnit {

    private List<T> subunits = new ArrayList<>();

    protected CompositeUnit(String name, Human head) {
        super(name, head);
    }

    public void addSubunit(T subunit) {
        subunits.add(subunit);
    }

    public List<T> getSubunits() {
        return Collections.unmodifiableList(subunits);
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        CompositeUnit<?> that = (CompositeUnit<?>) o;
        return Objects.equals(subunits, that.subunits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), subunits);
    }
}