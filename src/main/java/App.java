import entity.Island;
import service.IslandManager;
import util.Config;

import java.util.Arrays;
import java.util.concurrent.Executors;

public class App {

    public static void main(String[] args) {
        Island island = new Island(Config.ISLAND_WIDTH, Config.ISLAND_HIGH);
        island.initial();
        IslandManager islandManager = new IslandManager(island, 15, Executors.newFixedThreadPool(4));
        try {
            islandManager.live();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
