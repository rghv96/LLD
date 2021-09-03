package models;

import lombok.Data;

@Data
public class Seller {
    String sellerID;

    public Seller(String sellerID) {
        this.sellerID = sellerID;
    }
}
