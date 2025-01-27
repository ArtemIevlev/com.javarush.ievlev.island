package entity;

import entity.units.Unit;
import util.Config;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Класс описывающий сущность одной локации острова
 */
public class Tile  {
    private final int high;
    private final int wight;
    private List<Unit> unitList = new CopyOnWriteArrayList<>();
    private Map<Class<? extends Unit>, Integer> countsOfUnits = new ConcurrentHashMap<>();
    private ThreadLocalRandom random = ThreadLocalRandom.current();

    public Tile(int high, int wight) {
        this.high = high;
        this.wight = wight;
    }

    /**
     *  Метод добавляет нового юнита на локацию
     * @param unit - юнит для добавления на локацию
     * @return true - если юнит успешно добавлен, false - если их количество переполнено
     */
    public boolean addUnit(Unit unit){
        if (countsOfUnits.containsKey(unit.getClass())){
            countsOfUnits.put(unit.getClass(), countsOfUnits.get(unit.getClass()) + 1);
        }else {
            countsOfUnits.put(unit.getClass(), 1);
        }
        unitList.add(unit);
        unit.setCurrentTile(this);
        return true;
    }
    public boolean deleteUnit(Unit unit){
        unitList.remove(unit);
        countsOfUnits.put(unit.getClass(), countsOfUnits.get(unit.getClass())-1);
        return true;
    }

    public Map<Class<? extends Unit>, Integer> getCountsOfUnits() {
        return countsOfUnits;
    }

    public List<Unit> getUnitList() {
        return unitList;
    }

    public ThreadLocalRandom getRandom() {
        return random;
    }

    @Override
    public String toString() {
        return "Tile{" +
                "high=" + high +
                ", wight=" + wight +
                ", unitList=" + unitList +
                '}';
    }
}
