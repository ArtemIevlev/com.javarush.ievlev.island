package entity.plants;

import entity.Tile;
import entity.abstract_classes.Plant;

public class Grass extends Plant {
    public Grass(Tile currentTile) {
        super(1, 100, currentTile);
    }
}
