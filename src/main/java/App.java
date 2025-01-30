import entity.Island;
import service.IslandManager;
import settings.Config;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

    public static void main(String[] args) {
        Island island = new Island(Config.ISLAND_WIDTH, Config.ISLAND_HIGH);
        island.initial();
        ExecutorService  service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        IslandManager islandManager = new IslandManager(island, Config.COUNT_OF_ROUNDS, service);
        islandManager.live();
    }
}
