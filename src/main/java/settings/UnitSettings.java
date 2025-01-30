package settings;

import entity.units.Unit;
import entity.units.animals.herebivores.*;
import entity.units.animals.predators.*;
import entity.units.plants.Grass;

import java.util.HashMap;
import java.util.Map;

public class UnitSettings {


    public final static Settings GRASS_SETTINGS = new Settings(0, 1, 0, 200, "\uD83C\uDF31");
    public final static Settings RABBIT_SETTINGS = new Settings(0.45, 2, 2, 150, "\uD83D\uDC30");
    public final static Settings FOX_SETTINGS = new Settings(2, 8, 2, 30, "\uD83E\uDD8A");
    public final static Settings WOLF_SETTINGS = new Settings(8,50, 3, 30, "\uD83D\uDC3A");
    public final static Settings EAGLE_SETTINGS = new Settings(1, 6, 3, 20, "\uD83E\uDD85");
    public final static Settings HORSE_SETTINGS = new Settings(60, 400, 4, 20, "\uD83D\uDC34");
    public final static Settings SHEEP_SETTINGS = new Settings(15, 70, 3, 140, "\uD83D\uDC11");
    public final static Settings SNAKE_SETTINGS = new Settings(3, 15, 1, 30, "\uD83D\uDC0D");
    public final static Settings BEAR_SETTINGS = new Settings(80, 500, 2, 5, "\uD83D\uDC3B");
    public final static Settings DEER_SETTINGS = new Settings(50, 300, 4, 20, "\uD83E\uDD8C");
    public final static Settings MOUSE_SETTINGS = new Settings(0.01, 0.05, 1, 500, "\uD83D\uDC2D");

    static {
        // Шансы охоты лисы
        FOX_SETTINGS.addEaten(Rabbit.class, 70);
        FOX_SETTINGS.addEaten(Eagle.class, 10);
        FOX_SETTINGS.addEaten(Mouse.class, 90);
        //Шансы охоты волка
        WOLF_SETTINGS.addEaten(Rabbit.class, 60);
        WOLF_SETTINGS.addEaten(Horse.class, 10);
        WOLF_SETTINGS.addEaten(Sheep.class, 70);
        WOLF_SETTINGS.addEaten(Deer.class, 15);
        WOLF_SETTINGS.addEaten(Mouse.class, 80);
        //
        EAGLE_SETTINGS.addEaten(Rabbit.class, 90);
        EAGLE_SETTINGS.addEaten(Mouse.class, 90);
        //Шансы охоты змеи
        SNAKE_SETTINGS.addEaten(Fox.class, 15);
        SNAKE_SETTINGS.addEaten(Rabbit.class, 20);
        SNAKE_SETTINGS.addEaten(Mouse.class, 40);
        //Шансы охоты медведя
        BEAR_SETTINGS.addEaten(Snake.class, 80);
        BEAR_SETTINGS.addEaten(Snake.class, 80);
        BEAR_SETTINGS.addEaten(Horse.class, 40);
        BEAR_SETTINGS.addEaten(Rabbit.class, 80);
        BEAR_SETTINGS.addEaten(Sheep.class, 70);
        BEAR_SETTINGS.addEaten(Deer.class, 80);
        BEAR_SETTINGS.addEaten(Mouse.class, 90);
    }

    public final static Map<Class<? extends Unit>, Settings> UNIT_SETTINGS = new HashMap<>();
    static {
        UNIT_SETTINGS.put(Grass.class, GRASS_SETTINGS);
        UNIT_SETTINGS.put(Rabbit.class, RABBIT_SETTINGS);
        UNIT_SETTINGS.put(Fox.class, FOX_SETTINGS);
        UNIT_SETTINGS.put(Wolf.class, WOLF_SETTINGS);
        UNIT_SETTINGS.put(Eagle.class, EAGLE_SETTINGS);
        UNIT_SETTINGS.put(Horse.class,HORSE_SETTINGS);
        UNIT_SETTINGS.put(Sheep.class,SHEEP_SETTINGS);
        UNIT_SETTINGS.put(Snake.class, SNAKE_SETTINGS);
        UNIT_SETTINGS.put(Bear.class, BEAR_SETTINGS);
        UNIT_SETTINGS.put(Deer.class, DEER_SETTINGS);
        UNIT_SETTINGS.put(Mouse.class, MOUSE_SETTINGS);
    }
}
