package entity.units.animals.herebivores;

import entity.units.Unit;
import entity.units.animals.Animal;
import entity.units.plants.Plant;

public abstract class Herbivore extends Animal {

    public Herbivore(Class<? extends Animal> clazz) {
        super(clazz);
    }

    @Override
    public void move() {
        super.move();
    }

    @Override
    protected boolean canEat(Unit unit) {
        if (unit.getClass(). getSuperclass() == Plant.class) return true;
        else return super.canEat(unit);
    }

    @Override
    public void eat(Unit unit) {
        if (isAlive()){
            if (unit.getClass(). getSuperclass() == Plant.class){
                setSatiety(unit.getWeight() + getSatiety());
                unit.die();
                if (getSatiety() > getSettings().getMaxSatiety()) setSatiety(getSettings().getMaxSatiety());
            }
            super.eat(unit);
        }
    }
}
