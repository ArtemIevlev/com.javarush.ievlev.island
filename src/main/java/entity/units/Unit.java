package entity.units;

import entity.Tile;
import interfeces.Multiplying;
import service.UnitFactory;
import settings.Settings;

public abstract class Unit implements Multiplying {
    private Settings settings;
    private double weight;
    private Tile currentTile;
    private boolean isAlive = true;

    public Unit() {
    }

    public double getWeight() {
        return weight;
    }
    protected void setWeight(double weight) {
        this.weight = weight;
    }
    public Tile getCurrentTile() {
        return currentTile;
    }
    public Settings getSettings() {
        return settings;
    }
    protected void setSettings(Settings settings) {
        this.settings = settings;
    }

    public boolean isAlive() {
        return isAlive;
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
