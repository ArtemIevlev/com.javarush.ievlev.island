package settings;

import entity.units.Unit;
import entity.units.animals.herebivores.Rabbit;
import entity.units.animals.predators.Fox;
import entity.units.plants.Grass;

import java.util.HashMap;
import java.util.Map;

public class UnitSettings {


    public final static Settings GRASS_SETTINGS = new Settings(0, 1, 0, 200, "\uD83C\uDF31");
    public final static Settings RABBIT_SETTINGS = new Settings(0.45, 2, 2, 150, "\uD83D\uDC30");
    public final static Settings FOX_SETTINGS = new Settings(2, 8, 2, 30, "\uD83E\uDD8A");
    public final static Settings WOLF_SETTINGS = new Settings(8,50, 3, 30, "\uD83D\uDC3A");
    static {
        FOX_SETTINGS.addEaten(Rabbit.class, 70);
    }

    public final static Map<Class<? extends Unit>, Settings> UNIT_SETTINGS = new HashMap<>();
    static {
        UNIT_SETTINGS.put(Grass.class, GRASS_SETTINGS);
        UNIT_SETTINGS.put(Rabbit.class, RABBIT_SETTINGS);
        UNIT_SETTINGS.put(Fox.class, FOX_SETTINGS);
    }
}
