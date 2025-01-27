package service;

import entity.Island;
import entity.Tile;
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
        for (int i = 0; i < countOfCycles; i++) {
            addTasks();
            while (!taskQueue.isEmpty()){
                executorService.execute(taskQueue.poll());
            }
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
