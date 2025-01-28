package service;

import entity.Island;
import entity.Tile;
import entity.units.Unit;
import settings.Config;
import settings.UnitSettings;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;

public class IslandManager {
    private Island island;
    private int countOfCycles;
    private ExecutorService executorService;
    public Queue<Task> taskQueue = new ConcurrentLinkedQueue<>();

    public IslandManager(Island island, int countOfCycles, ExecutorService executorService) {
        this.island = island;
        this.countOfCycles = countOfCycles;
        this.executorService = executorService;
    }

    public void live() {
        try {
            for (int i = 0; i < countOfCycles; i++) {
                addTasks();
                while (!taskQueue.isEmpty()){
                    executorService.execute(taskQueue.poll());
                }
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                taskQueue.clear();
                writeInfo();
            }
        } finally {
            executorService.shutdown();
        }

    }
    private void addTasks(){
        for (Tile[] tiles : island.map) {
            for (Tile tile : tiles) {
                taskQueue.add(new Task(tile));
            }
        }
    }
    private void writeInfo(){
        for (Class<? extends Unit> typeClass : Config.LIST_OF_GAME_UNITS_TYPE) {
            int result = 0;
            for (Tile[] tiles : island.map) {
                for (Tile tile : tiles) {
                    Map<Class<? extends Unit>, Integer> countsOfUnits = tile.getCountsOfUnits();
                    if (countsOfUnits.get(typeClass) != null) {
                        result += countsOfUnits.get(typeClass);
                    }
                }
            }
            System.out.print(UnitSettings.UNIT_SETTINGS.get(typeClass).getImg() + result + " ");
        }
        System.out.println();
    }
}
