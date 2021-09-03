package models;

import lombok.Data;

@Data
public class Bidder {
    private Buyer buyer;
    private Double bidAmount;
    private Boolean inGame;

    public Bidder(Buyer buyer, Double bidAmount) {
        this.bidAmount = bidAmount;
        this.buyer = buyer;
        this.inGame = true;
    }

    public void withdraw() {
        this.inGame = false;
    }

}
