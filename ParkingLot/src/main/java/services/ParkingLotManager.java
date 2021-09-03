package services;

import enums.VehicleType;

import java.util.HashMap;

public interface ParkingLotManager {

    void createParkingLot(Integer id, Integer bikeSpots, Integer carSpots);

    void addRateCard(Integer id, VehicleType vehicleType, HashMap<Integer, Double> priceList, Double finalPrice);

    void parkVehicle(Integer vehicleID, Integer parkingLotID, Integer timeIN);
}
