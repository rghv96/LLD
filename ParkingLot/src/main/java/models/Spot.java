package models;

import enums.SpotType;
import lombok.Data;

@Data
public abstract class Spot {
    private Integer number;
    private boolean free;
    private SpotType spotType;
    private Vehicle vehicle;

    public Spot(SpotType spotType) {
        this.free = true;
        this.spotType = spotType;
    }
}
