package services;

import enums.VehicleType;
import models.Vehicle;

public interface VehicleManager {

    void createVehicle(Integer id, VehicleType vehicleType);

    void getHistory(Integer id);

    Vehicle getVehicle(Integer id);
}
