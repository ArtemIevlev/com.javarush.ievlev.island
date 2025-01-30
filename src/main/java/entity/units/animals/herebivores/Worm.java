package entity.units.animals.herebivores;

import entity.units.Unit;
import entity.units.animals.Animal;

public class Worm extends Herbivore {
    public Worm() {
        super(Worm.class);
    }

    @Override
    public void live() {
        if (isAlive()) {
            multiply();
        }
    }
}
