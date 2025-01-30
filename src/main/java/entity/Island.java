package entity;

import settings.Config;
import entity.units.Unit;
import service.UnitFactory;
import settings.UnitSettings;

import java.util.Arrays;

public class Island {
    private final int islandHigh;
    private final int islandWidth;
    public final Tile[][] map;

    public Island(int islandWidth, int islandHigh) {
        this.islandWidth = islandWidth;
        this.islandHigh = islandHigh;
        map = new Tile[islandHigh][islandWidth];
    }

    /**
     * Метод инициализации острова
     */
    public void initial(){
        for (int high = 0; high < map.length; high++) {
            for (int width = 0; width < map[high].length; width++) {
                map[high][width] = new Tile(high,width, this);
                initialUnits(map[high][width]);
            }
        }
    }

    private void initialUnits(Tile current){
        for (Class<? extends Unit> unitClass : Config.LIST_OF_GAME_UNITS_TYPE) {
            int maxOnTile = (int) (UnitSettings.UNIT_SETTINGS.get(unitClass).getMaxOnTile()  * 0.4d);
            for (int i = 0; i < maxOnTile; i++){
                Unit unit = UnitFactory.buildUnit(unitClass);
                if (!current.addUnit(unit)) {
                    break;
                }
            }
        }
    }

    public int getIslandHigh() {
        return islandHigh;
    }

    public int getIslandWidth() {
        return islandWidth;
    }

    @Override
    public String toString() {
        return "Island{" +
                "islandHigh=" + islandHigh +
                ", islandWidth=" + islandWidth +
                ", map=" + Arrays.deepToString(map) +
                '}';
    }
}
