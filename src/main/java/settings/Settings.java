package settings;

import entity.units.Unit;

import java.util.HashMap;
import java.util.Map;

public class Settings {
    private final double maxSatiety;
    private final double weight;
    private final int maxSpeed;
    private final int maxOnTile;
    private final Map<Class<? extends Unit>, Integer> canEat = new HashMap<>();
    private final String img;

    public Settings(double maxSatiety, double weight, int maxSpeed, int maxOnTile, String img) {
        this.maxSatiety = maxSatiety;
        this.weight = weight;
        this.maxSpeed = maxSpeed;
        this.maxOnTile = maxOnTile;
        this.img = img;
    }
    public void addEaten (Class<? extends Unit> eaten, int chance){
        canEat.put(eaten, chance);
    }
    public boolean canEat(Class<? extends Unit> eaten){
        return canEat.containsKey(eaten);
    }
    public int chanceToEat(Class<? extends Unit> eaten){
     return canEat.get(eaten);
    }
    public double getWeight() {
        return weight;
    }

    public double getMaxSatiety() {
        return maxSatiety;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getMaxOnTile() {
        return maxOnTile;
    }

    public String getImg() {
        return img;
    }
}
