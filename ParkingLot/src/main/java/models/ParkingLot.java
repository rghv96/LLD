package models;

import lombok.Data;

import java.util.HashMap;

@Data
public class ParkingLot {
    private Integer id;
    private HashMap<Integer, BikeSpot> bikeSpotHashMap;
    private HashMap<Integer, CarSpot> carSpotHashMap;
//    private HashMap<Integer, Spot> vehicleMap;
    private RateCard bikeRateCard;
    private RateCard carRateCard;
    private HashMap<Integer, Ticket> ticketHashMap;
    private static Integer ticketCounter = 1;


    public ParkingLot(Integer id, HashMap<Integer, BikeSpot> bikeSpotHashMap, HashMap<Integer, CarSpot> carSpotHashMap) {
        this.id = id;
        this.bikeSpotHashMap = bikeSpotHashMap;
        this.carSpotHashMap = carSpotHashMap;
        this.ticketHashMap = new HashMap<Integer, Ticket>();
    }

    public Ticket createTicket(Vehicle v, Integer timeIN) {
        Ticket t = new Ticket(v, timeIN);
        ticketHashMap.put(ticketCounter, t);
        ticketCounter++;
        return t;
    }

}
