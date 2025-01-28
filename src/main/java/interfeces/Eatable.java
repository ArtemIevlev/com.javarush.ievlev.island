package interfeces;

import entity.units.Unit;

public interface Eatable {
    public default void eat(Unit unit){}
}
