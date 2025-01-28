import entity.Island;
import service.IslandManager;
import settings.Config;

import java.util.concurrent.Executors;

public class App {

    public static void main(String[] args) {
        Island island = new Island(Config.ISLAND_WIDTH, Config.ISLAND_HIGH);
        island.initial();
        IslandManager islandManager = new IslandManager(island, 4, Executors.newFixedThreadPool(4));
        islandManager.live();
    }
}
