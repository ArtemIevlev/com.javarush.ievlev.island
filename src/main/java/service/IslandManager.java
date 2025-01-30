package service;

import entity.Island;
import entity.Tile;
import entity.units.Unit;
import settings.Config;
import settings.UnitSettings;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;

public class IslandManager {
    private final Island island;
    private final int countOfCycles;
    private final ExecutorService executorService;
    private final Queue<Task> taskQueue = new ConcurrentLinkedQueue<>();
    private final IslandInformationManager informationManager;

    public IslandManager(Island island, int countOfCycles, ExecutorService executorService) {
        this.island = island;
        this.countOfCycles = countOfCycles;
        this.executorService = executorService;
        informationManager = new IslandInformationManager(this.executorService, this.island);
    }

    public void live() {
        try {
            for (int i = 0; i < countOfCycles; i++) {
                addTasks();
                while (!taskQueue.isEmpty()){
                    executorService.execute(taskQueue.poll());
                }
                try {
                    Thread.sleep(1000 * Config.SECONDS_PER_ROUND);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                taskQueue.clear();
                informationManager.writeNewRoundInfo();
            }
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
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
}
