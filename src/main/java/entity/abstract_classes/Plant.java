package entity.abstract_classes;

import entity.Tile;
import service.GameObjectFactory;

import java.util.List;
import java.util.Map;

public class Plant extends GameObject{
    public Plant(int weight, int maxOnTile, Tile currentTile) {
        super(weight, maxOnTile, currentTile);
    }

    /**
     * Метод размножения у растений
     */
    @Override
    public void multiply() {
        Tile currentTile = this.getCurrentTile();
        List<GameObject> objectList = currentTile.getObjectList();
        Map<Class<? extends GameObject>, Integer> counts = currentTile.getCounts();
        Class<? extends Plant> aClass = this.getClass();
        if (counts.containsKey(aClass) && counts.get(aClass) < this.getMaxOnTile()){
            counts.put(aClass, 1 + counts.get(aClass));
            objectList.add(GameObjectFactory.build(aClass, currentTile));
        }

    }
}
