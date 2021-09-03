package models;

import lombok.Data;

import java.util.HashSet;

@Data
public class Buyer {
    private String buyerID;
    private HashSet<String> participatedAuctions;

    public Buyer(String buyerID) {
        this.buyerID = buyerID;
        this.participatedAuctions = new HashSet<String>();
    }

    public void addAuction(String auction) {
        participatedAuctions.add(auction);
    }

    public void removeAuction(String auction) {
        participatedAuctions.remove(auction);
    }


}
