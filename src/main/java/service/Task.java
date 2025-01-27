package service;

import entity.Tile;
import entity.units.Unit;

import java.util.List;
import java.util.Map;

public class Task implements Runnable{
    private Tile current;
    private List<Unit> unitList;
    private Map<Class<? extends Unit>, Integer> countsOfUnits;

    public Task(Tile current) {
        this.current = current;
        unitList = current.getUnitList();
        countsOfUnits = current.getCountsOfUnits();
    }

    @Override
    public void run() {
        for (Unit unit : unitList) {
            unit.live();
        }
    }
}
