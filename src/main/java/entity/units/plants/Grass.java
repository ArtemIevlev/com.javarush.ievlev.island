package entity.units.plants;

import entity.Tile;
import entity.units.animals.herebivores.Rabbit;
import settings.UnitSettings;

public class Grass extends Plant {

    public Grass() {
        setSettings(UnitSettings.UNIT_SETTINGS.get(Grass.class));
        setWeight(getSettings().getWeight());
    }
}
