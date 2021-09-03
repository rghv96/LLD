package services;

import models.Buyer;

import java.util.HashMap;

// should implement interface
public class BuyerManagerImpl {

    private HashMap<String, Buyer> buyerHashMap;

    public BuyerManagerImpl() {
        buyerHashMap = new HashMap<String, Buyer>();
    }

    public void createBuyer(String buyerID) {
        if(!buyerHashMap.containsKey(buyerID)) {
            Buyer s = new Buyer(buyerID);
            buyerHashMap.put(buyerID, s);
        }
    }

    public Buyer getBuyer(String buyerID) {
        if(!buyerHashMap.containsKey(buyerID)) {
            Buyer s = new Buyer(buyerID);
            buyerHashMap.put(buyerID, s);
        }
        return buyerHashMap.get(buyerID);
    }
}
