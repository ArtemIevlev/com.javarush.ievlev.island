package service;

import entity.units.Unit;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactory {
    public static <T extends Unit> T buildUnit(Class<T> tClass){
        try {
            Constructor<T> constructor = tClass.getConstructor();
            T t = constructor.newInstance();
            return t;
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Не найден конструктор по умолчанию", e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
