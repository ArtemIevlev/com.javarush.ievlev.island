package entity;

import controllers.Config;
import entity.abstract_classes.GameObject;
import service.GameObjectFactory;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Island {
    public final Tile[][] map = new Tile[Config.ISLAND_HIGH][Config.ISLAND_WIDTH];
    public final ThreadLocalRandom random = ThreadLocalRandom.current();

    public Island() {
        this.initial();
    }

    /**
     * Метод инициализации острова
     */
    public void initial(){
        for (int high = 0; high < map.length; high++) {
            for (int width = 0; width < map[high].length; width++) {
                map[high][width] = new Tile(high,width);
                initialObjects(map[high][width]);
            }
        }
    }
    private void initialObjects(Tile current){
        Map<Class<? extends GameObject>, Integer> counts = current.getCounts();
        List<GameObject> objectList = current.getObjectList();
        for (Class<? extends GameObject> aClass : Config.LIST_OF_GAME_OBJECT_TYPE) {
            int i = random.nextInt(Config.MAX_OBJECTS_FOR_INITIAL);
            for (int j = 0; j<i; j++){
                GameObject object = GameObjectFactory.build(aClass, current);
                if (counts.containsKey(aClass)){
                    if (counts.get(aClass) > object.getMaxOnTile()){
                        break;
                    }
                    counts.put(aClass, counts.get(aClass) + 1);
                }else {
                    counts.put(aClass, 1);
                }
                objectList.add(object);
            }
        }
    }
}
