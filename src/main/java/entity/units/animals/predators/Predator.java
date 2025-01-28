package entity.units.animals.predators;

import entity.units.animals.Animal;

public abstract class Predator extends Animal {

    public Predator(Class<? extends Animal> clazz) {
        super(clazz);
    }
}
