package controllers;

import entity.abstract_classes.GameObject;
import entity.abstract_classes.Plant;
import entity.plants.Grass;
import service.GameObjectFactory;

import java.util.ArrayList;
import java.util.List;

public class Config {
    public static final int ISLAND_WIDTH = 2;
    public static final int ISLAND_HIGH = 2;
    public static final int MAX_OBJECTS_FOR_INITIAL = 10;
    public static final List<Class<? extends GameObject>> LIST_OF_GAME_OBJECT_TYPE = new ArrayList<>();

    static {
        LIST_OF_GAME_OBJECT_TYPE.add(Grass.class);
    }
}
