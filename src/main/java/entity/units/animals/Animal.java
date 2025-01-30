package entity.units.animals;
import entity.Direction;
import entity.Island;
import entity.Tile;
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
            move();
            multiply();
            reduceSatiety();
            if (satiety < getSettings().getMaxSatiety() / 4) die();
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

    @Override
    public void move() {
        if (isAlive()) {
            for (int i = 0; i < currentSpeed; i++) {
                moveToDirection(choseDirection());
            }
        }
    }
    private void moveToDirection(Direction direction){
        Island currentIsland = getCurrentTile().getIsland();
        Tile currentTile = getCurrentTile();
        Tile newTile;
        switch (direction){
            case DOWN -> {
                if (currentTile.getHigh() + 1 < currentIsland.getIslandHigh()){
                    newTile = currentIsland.map[currentTile.getHigh()+1][currentTile.getWight()];
                    currentTile.deleteUnit(this);
                    newTile.addUnit(this);
                }
            }
            case LEFT -> {
                if (currentTile.getWight() - 1 >= 0){
                    newTile = currentIsland.map[currentTile.getHigh()][currentTile.getWight()-1];
                    currentTile.deleteUnit(this);
                    newTile.addUnit(this);
                }
            }
            case RIGHT -> {
                if (currentTile.getWight() + 1 < currentIsland.getIslandWidth()){
                    newTile = currentIsland.map[currentTile.getHigh()][currentTile.getWight()+ 1];
                    currentTile.deleteUnit(this);
                    newTile.addUnit(this);
                }
            }
            case UP -> {
                if (currentTile.getHigh() - 1 >= 0){
                    newTile = currentIsland.map[currentTile.getHigh()-1][currentTile.getWight()];
                    currentTile.deleteUnit(this);
                    newTile.addUnit(this);
                }
            }
        }
    }
    private Direction choseDirection(){
        int i = getCurrentTile().getRandom().nextInt(4);
        return switch (i){
            case 0 -> Direction.UP;
            case 1 -> Direction.RIGHT;
            case 2 -> Direction.DOWN;
            default -> Direction.LEFT;
        };
    }
}
