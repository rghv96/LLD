package services.impl;

import enums.VehicleType;
import lombok.Data;
import models.ParkingLot;
import models.Vehicle;
import models.VehicleHistory;
import services.VehicleManager;

import java.util.HashMap;
import java.util.List;

@Data
public class VehicleManagerImpl implements VehicleManager {

    private HashMap<Integer, Vehicle> vehicleMap;

    public VehicleManagerImpl() {
        vehicleMap = new HashMap<Integer, Vehicle>();
    }

    @Override
    public void createVehicle(Integer id, VehicleType vehicleType) {
        Vehicle v = new Vehicle(id, vehicleType);
        vehicleMap.put(id, v);
    }

    @Override
    public void getHistory(Integer id) {
        if(!vehicleMap.containsKey(id)) {
            Vehicle v = new Vehicle(id, VehicleType.BIKE);
            vehicleMap.put(id, v);
        }

        Vehicle vehicle = vehicleMap.get(id);
        List<VehicleHistory> vehicleHistoryList = vehicle.getHistory();
        if(vehicleHistoryList.size() > 0) {
            System.out.println("History for vehicle: " + id);
        }
        for(VehicleHistory history : vehicleHistoryList) {
            System.out.println("parkinglot id: " + history.getParkingLot().getId());
            System.out.println("duration: " + history.getDuration());
            System.out.println("amount: " + history.getAmount());
        }
    }

    @Override
    public Vehicle getVehicle(Integer id) {
        if(!vehicleMap.containsKey(id)) {
            Vehicle v = new Vehicle(id, VehicleType.BIKE);
            vehicleMap.put(id, v);
        }
        return vehicleMap.get(id);
    }
}
