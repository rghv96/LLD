package models;

import lombok.Data;

@Data
public class VehicleHistory {
    ParkingLot parkingLot;
    Integer duration;
    Double amount;
}
