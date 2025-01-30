package settings;

import entity.units.Unit;
import entity.units.animals.herebivores.*;
import entity.units.animals.predators.*;
import entity.units.plants.Grass;
import entity.units.plants.Rice;

import java.util.ArrayList;
import java.util.List;

public class Config {
    public static final int ISLAND_WIDTH = 5;
    public static final int ISLAND_HIGH = 5;
    public static final int TRYING_TO_FIND_FOOD = 7;
    public static final int SECONDS_PER_ROUND = 3;
    public static final int COUNT_OF_ROUNDS = 10;
    /**
     * Лист хранящий в себе список классов юнитов участвующих в симуляции
     */
    public static final List<Class<? extends Unit>> LIST_OF_GAME_UNITS_TYPE = new ArrayList<>();

    static {
        LIST_OF_GAME_UNITS_TYPE.add(Grass.class);
        LIST_OF_GAME_UNITS_TYPE.add(Rabbit.class);
        LIST_OF_GAME_UNITS_TYPE.add(Fox.class);
        LIST_OF_GAME_UNITS_TYPE.add(Wolf.class);
        LIST_OF_GAME_UNITS_TYPE.add(Eagle.class);
        LIST_OF_GAME_UNITS_TYPE.add(Horse.class);
        LIST_OF_GAME_UNITS_TYPE.add(Sheep.class);
        LIST_OF_GAME_UNITS_TYPE.add(Snake.class);
        LIST_OF_GAME_UNITS_TYPE.add(Bear.class);
        LIST_OF_GAME_UNITS_TYPE.add(Deer.class);
        LIST_OF_GAME_UNITS_TYPE.add(Mouse.class);
        LIST_OF_GAME_UNITS_TYPE.add(Hog.class);
        LIST_OF_GAME_UNITS_TYPE.add(Buffalo.class);
        LIST_OF_GAME_UNITS_TYPE.add(Duck.class);
        LIST_OF_GAME_UNITS_TYPE.add(Worm.class);
        LIST_OF_GAME_UNITS_TYPE.add(Rice.class);
    }
}
