package models;

import enums.VehicleType;
import lombok.Data;

import java.util.List;

@Data
public class Vehicle {
    private Integer id;
    private VehicleType vehicleType;
    private Ticket ticket;
    private List<VehicleHistory> history;

    public Vehicle(Integer id, VehicleType vehicleType) {
        this.id = id;
        this.vehicleType = vehicleType;
    }

}
