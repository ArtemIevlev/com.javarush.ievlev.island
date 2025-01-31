package entity.units.plants;

import entity.units.Unit;
import service.UnitFactory;
import settings.UnitSettings;

public class Plant extends Unit {
    public Plant() {
        setSettings(UnitSettings.UNIT_SETTINGS.get(this.getClass()));
        setWeight(getSettings().getWeight());
    }
}
