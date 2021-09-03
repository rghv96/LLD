package services.impl;

import enums.VehicleType;
import models.*;
import services.ParkingLotManager;
import services.VehicleManager;

import java.util.HashMap;

public class ParkingLotManagerImpl implements ParkingLotManager {

    private HashMap<Integer, ParkingLot> parkingLotHashMap;

    private VehicleManager vehicleManager;

    public ParkingLotManagerImpl(VehicleManager vehicleManager) {
        parkingLotHashMap = new HashMap<Integer, ParkingLot>();
        this.vehicleManager = vehicleManager;
    }

    @Override
    public void createParkingLot(Integer id, Integer bikeSpots, Integer carSpots) {
        HashMap<Integer, BikeSpot> bikeSpotHashMap = new HashMap<Integer, BikeSpot>();
        for(Integer i=1;i<=bikeSpots;i++) {
            bikeSpotHashMap.put(i, new BikeSpot());
        }
        HashMap<Integer, CarSpot> carSpotHashMap = new HashMap<Integer, CarSpot>();
        for(Integer i=1;i<=carSpots;i++) {
            carSpotHashMap.put(i, new CarSpot());
        }

        ParkingLot p = new ParkingLot(id, bikeSpotHashMap, carSpotHashMap);
        parkingLotHashMap.put(id, p);
    }

    @Override
    public void addRateCard(Integer id, VehicleType vehicleType, HashMap<Integer, Double> priceList, Double finalPrice) {
        ParkingLot p = parkingLotHashMap.get(id);
        RateCard rc = new RateCard(priceList, finalPrice);
        if(vehicleType.equals(VehicleType.BIKE)) {
            p.setBikeRateCard(rc);
        }
        else if(vehicleType.equals(VehicleType.CAR)) {
            p.setCarRateCard(rc);
        }
    }

    @Override
    public void parkVehicle(Integer vehicleID, Integer parkingLotID, Integer timeIN) {
        ParkingLot p = parkingLotHashMap.get(parkingLotID);
        Vehicle v = vehicleManager.getVehicle(vehicleID);

        if(v.getVehicleType().equals(VehicleType.BIKE)) {
            for(BikeSpot spot : p.getBikeSpotHashMap().values()) {
                if(spot.isFree()) {
                    spot.setVehicle(v);
                    Ticket t = p.createTicket(v, timeIN);
                    v.setTicket(t);
                    spot.setFree(false);
                    return;
                }
            }
        }
        else if(v.getVehicleType().equals(VehicleType.CAR)) {
            for(CarSpot spot : p.getCarSpotHashMap().values()) {
                if(spot.isFree()) {
                    spot.setVehicle(v);
                    Ticket t = p.createTicket(v, timeIN);
                    v.setTicket(t);
                    spot.setFree(false);
                    return;
                }
            }
        }

        System.out.println("Parking lot full");
    }
}
