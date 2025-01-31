package entity;

import entity.units.Unit;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Класс описывающий сущность одной локации острова
 */
public class Tile  {
    private final int high;
    private final int wight;
    private final Island island;
    private final List<Unit> unitList = new CopyOnWriteArrayList<>();
    private final Map<Class<? extends Unit>, Integer> countsOfUnits = new ConcurrentHashMap<>();
    private ThreadLocalRandom random = ThreadLocalRandom.current();
    private Lock lock = new ReentrantLock();

    public Tile(int high, int wight, Island island) {
        this.high = high;
        this.wight = wight;
        this.island = island;
    }

    /**
     *  Метод добавляет нового юнита на локацию
     * @param unit - юнит для добавления на локацию
     * @return true - если юнит успешно добавлен, false - если их количество переполнено
     */
    public boolean addUnit(Unit unit){
        lock.lock();
        try {
            if (countsOfUnits.containsKey(unit.getClass())) {
                if (countsOfUnits.get(unit.getClass()) >= unit.getSettings().getMaxOnTile()) return false;
                countsOfUnits.put(unit.getClass(), countsOfUnits.get(unit.getClass()) + 1);
            } else {
                countsOfUnits.put(unit.getClass(), 1);
            }
            unitList.add(unit);
            unit.setCurrentTile(this);
            return true;
        }finally {
            lock.unlock();
        }
    }
    public Unit getRandomUnit(){
        lock.lock();
        try {
            return unitList.get(random.nextInt(unitList.size()));
        } finally {
            lock.unlock();
        }
    }
    public boolean deleteUnit(Unit unit){
        lock.lock();
        try {
            boolean remove = unitList.remove(unit);
            if (remove) countsOfUnits.put(unit.getClass(), countsOfUnits.get(unit.getClass())-1);
            return true;
        }finally {
            lock.unlock();
        }

    }

    public Map<Class<? extends Unit>, Integer> getCountsOfUnits() {
        lock.lock();
        try {
            return countsOfUnits;
        }finally {
            lock.unlock();
        }
    }

    public List<Unit> getUnitList() {
        lock.lock();
        try {
            return unitList;
        }finally {
            lock.unlock();
        }
    }

    public ThreadLocalRandom getRandom() {
        return random;
    }

    public int getHigh() {
        return high;
    }

    public int getWight() {
        return wight;
    }

    public Island getIsland() {
        return island;
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
