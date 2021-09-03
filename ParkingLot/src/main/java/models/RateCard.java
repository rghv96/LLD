package models;

import lombok.Data;

import java.util.HashMap;

@Data
public class RateCard {
    HashMap<Integer, Double> priceList;
    Double finalPrice;

    public RateCard(HashMap<Integer, Double> priceList, Double finalPrice) {
        this.finalPrice = finalPrice;
        this.priceList = priceList;
    }
}
