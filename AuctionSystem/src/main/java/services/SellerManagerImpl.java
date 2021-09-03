package services;

import models.Seller;

import java.util.HashMap;

// should implement interface
public class SellerManagerImpl {

    private HashMap<String, Seller> sellerHashMap;

    public SellerManagerImpl() {
        sellerHashMap = new HashMap<String, Seller>();
    }
    public void createSeller(String sellerID) {
        if(!sellerHashMap.containsKey(sellerID)) {
            Seller s = new Seller(sellerID);
            sellerHashMap.put(sellerID, s);
        }
    }

    public Seller getSeller(String sellerID) {
        if(!sellerHashMap.containsKey(sellerID)) {
            Seller s = new Seller(sellerID);
            sellerHashMap.put(sellerID, s);
        }
        return sellerHashMap.get(sellerID);
    }
}
