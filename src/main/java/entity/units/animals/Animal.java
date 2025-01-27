package entity.units.animals;
import entity.units.Unit;
import interfeces.Eatable;
import interfeces.Movable;

public abstract class Animal extends Unit implements Eatable, Movable {
    private double satiety;
    private int currentSpeed;

    public Animal() {
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void reduceSatiety(){}

    @Override
    public void multiply() {
       if (getCurrentTile().getRandom().nextInt(10) >= 5){
           super.multiply();
       }
    }

}
