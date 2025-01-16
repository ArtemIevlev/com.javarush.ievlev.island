package service;

import entity.Tile;
import entity.abstract_classes.GameObject;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class GameObjectFactory {
    public static <T extends GameObject> T build(Class<T> tClass, Tile currentTile){

        try {
            Constructor<T> constructor = tClass.getConstructor(Tile.class);
            T t = constructor.newInstance(currentTile);
            System.out.println("На свет появился " + tClass + " На клетке " + currentTile);
            return t;
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Не найден конструктор с параметром Tile", e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
