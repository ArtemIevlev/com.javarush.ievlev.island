package entity.units;

import entity.Tile;
import interfeces.Multiplying;
import service.UnitFactory;

public abstract class Unit implements Multiplying {
    private int weight;
    private Tile currentTile;
    private boolean isAlive = true;

    public Unit() {
    }

    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Tile getCurrentTile() {
        return currentTile;
    }

    public void setCurrentTile(Tile currentTile) {
        this.currentTile = currentTile;
    }

    @Override
    public void multiply() {
        if (isAlive) {
            getCurrentTile()
                    .addUnit(UnitFactory.buildUnit(this.getClass()));
        }
    }
    public void die(){
        isAlive = false;
        currentTile.deleteUnit(this);
    }
    public void live(){
        multiply();
    }
}
