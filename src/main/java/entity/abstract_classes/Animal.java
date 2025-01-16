package entity.abstract_classes;

import entity.Tile;
import entity.interfeces.Eatable;
import entity.interfeces.Movable;

public abstract class Animal extends GameObject implements Eatable, Movable {
//    private final int kgForSaturation;
//    private final int maxSpeed;
    private int currentSpeed;

    public Animal(int weight, int maxOnTile, Tile currentTile) {
        super(weight, maxOnTile, currentTile);
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }
}
