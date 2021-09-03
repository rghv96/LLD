package models;

import lombok.Data;

@Data
public class Ticket {
    Vehicle v;
    Integer timeIN;
    Integer timeOUT;

    public Ticket(Vehicle v, Integer timeIN) {
        this.v = v;
        this.timeIN = timeIN;
    }


}
