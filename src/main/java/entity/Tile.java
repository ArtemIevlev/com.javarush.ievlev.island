package entity;

import entity.abstract_classes.GameObject;
import entity.abstract_classes.Herbivore;
import entity.abstract_classes.Predator;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Tile  {
    private List<GameObject> objectList = new CopyOnWriteArrayList<>();
    private Map<Class<? extends GameObject>, Integer> counts = new ConcurrentHashMap<>();

    public Map<Class<? extends GameObject>, Integer> getCounts() {
        return counts;
    }

    public List<GameObject> getObjectList() {
        return objectList;
    }

    private final int high;
    private final int wight;

    public Tile(int high, int wight) {
        this.high = high;
        this.wight = wight;
    }

    public Information live(){
        return null;
    }

    @Override
    public String toString() {
        return "Tile{" +
                "wight=" + wight +
                ", high=" + high +
                '}';
    }
}
