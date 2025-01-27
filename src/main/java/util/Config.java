package util;

import entity.units.Unit;
import entity.units.plants.Grass;

import java.util.ArrayList;
import java.util.List;

public class Config {
    public static final int ISLAND_WIDTH = 2;
    public static final int ISLAND_HIGH = 2;
    public static final int MAX_OBJECTS_FOR_INITIAL = 10;
    /**
     * Лист хранящий в себе список классов юнитов участвующих в симуляции
     */
    public static final List<Class<? extends Unit>> LIST_OF_GAME_UNITS_TYPE = new ArrayList<>();
    public static final String[][] CHANCE_OF_ABSORPTION = Parser.makeTable(Config.class.getResourceAsStream("/chance_of_absorption.csv"),16);
    public static final String[][] CHARACTERISTICS = Parser.makeTable(Config.class.getResourceAsStream("/characteristic.csv"),17);

    static {
        LIST_OF_GAME_UNITS_TYPE.add(Grass.class);
    }
    public static int GRASS_MAX_COUNT = 200;
}
