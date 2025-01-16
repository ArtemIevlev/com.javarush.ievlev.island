package entity.abstract_classes;

import entity.Tile;
import entity.interfeces.Multiplying;

public abstract class GameObject implements Multiplying {
    public int getMaxOnTile() {
        return maxOnTile;
    }

    public int getWeight() {
        return weight;
    }

    public GameObject(int weight, int maxOnTile, Tile currentTile) {
        this.weight = weight;
        this.maxOnTile = maxOnTile;
        this.currentTile = currentTile;
    }

    //private final char image;
    private int maxOnTile;
    private int weight;
    private Tile currentTile;

    public Tile getCurrentTile() {
        return currentTile;
    }

    public void setCurrentTile(Tile currentTile) {
        this.currentTile = currentTile;
    }
}
