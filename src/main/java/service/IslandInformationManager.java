package service;

import entity.Island;
import entity.Tile;
import entity.units.Unit;
import settings.Config;
import settings.UnitSettings;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class IslandInformationManager {

    private final ExecutorService service;
    private final Island island;
    private final Map<Class<? extends Unit>, Future<Integer>> informationMap = new HashMap<>();
    private int counterDays = 1;

    public IslandInformationManager(ExecutorService service, Island island) {
        this.service = service;
        this.island = island;
        for (Class<? extends Unit> aClass : Config.LIST_OF_GAME_UNITS_TYPE) {
            informationMap.put(aClass, null);
        }
    }
    public void writeNewRoundInfo() throws ExecutionException, InterruptedException {
        for (Class<? extends Unit> aClass : informationMap.keySet()) {
            Future<Integer> future = service.submit(() -> {
                int result = 0;
                for (Tile[] tiles : island.map) {
                    for (Tile tile : tiles) {
                        result += tile.getCountsOfUnits().get(aClass);
                    }
                }
                return result;
            });
            informationMap.put(aClass, future);
        }
        System.out.print("День на острове: " + counterDays++ + "\nКоличество животных на нем:");
        for (Class<? extends Unit> aClass : informationMap.keySet()) {
            System.out.print(UnitSettings.UNIT_SETTINGS.get(aClass).getImg() + ":" + informationMap.get(aClass).get() + " ");
        }
        System.out.println();
    }
}
