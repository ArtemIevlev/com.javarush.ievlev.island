package entity.units.plants;

import settings.UnitSettings;

public class Rice extends Plant{
    public Rice() {
        setSettings(UnitSettings.UNIT_SETTINGS.get(Rice.class));
        setWeight(getSettings().getWeight());
    }
}
