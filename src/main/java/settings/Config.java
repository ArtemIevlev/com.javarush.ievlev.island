package settings;

import entity.units.Unit;
import entity.units.animals.herebivores.Rabbit;
import entity.units.animals.predators.Fox;
import entity.units.plants.Grass;
import util.Parser;

import java.util.ArrayList;
import java.util.List;

public class Config {
    public static final int ISLAND_WIDTH = 5;
    public static final int ISLAND_HIGH = 5;
    public static final int TRYING_TO_FIND_FOOD = 5;
    public static final int MAX_OBJECTS_FOR_INITIAL = 10;
    /**
     * Лист хранящий в себе список классов юнитов участвующих в симуляции
     */
    public static final List<Class<? extends Unit>> LIST_OF_GAME_UNITS_TYPE = new ArrayList<>();

    static {
        LIST_OF_GAME_UNITS_TYPE.add(Grass.class);
        LIST_OF_GAME_UNITS_TYPE.add(Rabbit.class);
        LIST_OF_GAME_UNITS_TYPE.add(Fox.class);
    }
}
