import enums.VehicleType;
import models.ParkingLot;
import models.Vehicle;
import services.ParkingLotManager;
import services.VehicleManager;
import services.impl.ParkingLotManagerImpl;
import services.impl.VehicleManagerImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class App {

    public static void main(String[] args) throws IOException {

        VehicleManager vehicleManager = new VehicleManagerImpl();
        ParkingLotManager parkingLotManager = new ParkingLotManagerImpl(vehicleManager);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input1 = bufferedReader.readLine();
        String input2 = bufferedReader.readLine();

        do {
            String methodName = input1.trim();
            String[] arguments = input2.trim().split(" ");

            try {
                if(methodName.equals("createVehicle")) {
                    Integer id = Integer.parseInt(arguments[0]);
                    VehicleType vehicleType = VehicleType.valueOf(arguments[1]);
                    vehicleManager.createVehicle(id, vehicleType);
                } else
                if(methodName.equals("createParkingLot")) {
                    Integer id = Integer.parseInt(arguments[0]);
                    Integer bikeSpots = Integer.parseInt(arguments[1]);
                    Integer carSpots = Integer.parseInt(arguments[2]);
                    parkingLotManager.createParkingLot(id, bikeSpots, carSpots);
                } else if(methodName.equals("addRateCard")) {
                    Integer id = Integer.parseInt(arguments[0]);
                    VehicleType vehicleType = VehicleType.valueOf(arguments[1]);
                    Integer numRecords = Integer.parseInt(arguments[2]);
                    Integer i = 0;
                    HashMap<Integer, Double> hm = new HashMap<Integer, Double>();
                    while(i < 2*numRecords) {
                        Integer time = Integer.parseInt(arguments[3 + i]);
                        i++;
                        Double price = Double.parseDouble(arguments[3 + i]);
                        i++;
                        hm.put(time, price);
                    }
                    Double finalPrice = Double.parseDouble(arguments[3 + i]);
                    parkingLotManager.addRateCard(id, vehicleType, hm, finalPrice);
                } else if(methodName.equals("getVehicleHistory")) {
                    Integer id = Integer.parseInt(arguments[0]);
                    vehicleManager.getHistory(id);
                } else if(methodName.equals("parkVehicle")) {
                    Integer vehicleId = Integer.parseInt(arguments[0]);
                    Integer parkingLotId = Integer.parseInt(arguments[1]);
                    Integer timeIN = Integer.parseInt(arguments[2]);
                    parkingLotManager.parkVehicle(vehicleId, parkingLotId, timeIN);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            input1 = bufferedReader.readLine();
            input2 = bufferedReader.readLine();

        } while(input1 != null && !input1.isEmpty() && input2 != null && !input2.isEmpty());
        bufferedReader.close();

    }
}
/*
createVehicle
1 BIKE
createVehicle
2 BIKE
createVehicle
3 BIKE
createVehicle
4 CAR
createParkingLot
1 2 2
addRateCard
1 CAR 2 1 50 2 100 200
addRateCard
1 BIKE 3 1 50 2 60 3 80 100
parkVehicle
1 1 1
parkVehicle
2 1 2
parkVehicle
3 1 3
parkVehicle
4 1 4
 */