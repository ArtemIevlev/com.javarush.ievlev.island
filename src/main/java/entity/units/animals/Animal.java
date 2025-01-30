package entity.units.animals;
import entity.units.Unit;
import interfeces.Eatable;
import interfeces.Movable;
import settings.Config;
import settings.UnitSettings;

import java.util.List;

public abstract class Animal extends Unit implements Eatable, Movable {

    private double satiety;
    private int currentSpeed;

    public Animal(Class<? extends Animal> clazz) {
        setSettings(UnitSettings.UNIT_SETTINGS.get(clazz));
        setWeight(getSettings().getWeight());
        setCurrentSpeed(getSettings().getMaxSpeed());
        setSatiety(getSettings().getMaxSatiety());
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void reduceSatiety(){ satiety -= getSettings().getMaxSatiety()/2;}

    @Override
    public void multiply() {
       if (isAlive()) {
           if (getCurrentTile().getRandom().nextInt(10) >= 5
                   && satiety > getSettings().getMaxSatiety()/2) {
               super.multiply();
           }
       }
    }

    @Override
    public void eat(Unit unit) {
        if (isAlive()) {
            int i = getCurrentTile().getRandom().nextInt(100);
            if (unit.isAlive() && i <= getSettings().chanceToEat(unit.getClass())) {
                satiety += unit.getWeight();
                unit.die();
                if (satiety > getSettings().getMaxSatiety()) satiety = getSettings().getMaxSatiety();
            }
        }
    }

    @Override
    public void live() {
        if(isAlive()) {
            for (int i = 0; i < Config.TRYING_TO_FIND_FOOD; i++) {
                List<Unit> unitList = getCurrentTile().getUnitList();
                int size = unitList.size();
                int unitToEat = getCurrentTile().getRandom().nextInt(size);
                if (canEat(unitList.get(unitToEat))) {
                    eat(unitList.get(unitToEat));
                    break;
                }
            }
            multiply();
            reduceSatiety();
            if (satiety < getSettings().getMaxSatiety() / 4) die();
        } else {
            getCurrentTile().deleteUnit(this);
        }
    }

    protected boolean canEat(Unit unit){
       return getSettings().canEat(unit.getClass());
    }

    public void setSatiety(double satiety) {
        this.satiety = satiety;
    }

    public double getSatiety() {
        return satiety;
    }
}
