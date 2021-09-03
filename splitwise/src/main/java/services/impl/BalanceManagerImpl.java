package services.impl;

import models.LedgerEntry;
import models.User;
import services.BalanceManager;
import services.UserManager;

import java.util.HashMap;

public class BalanceManagerImpl implements BalanceManager {

    private UserManager userManager;

    public BalanceManagerImpl(UserManager userManager) {
        this.userManager = userManager;
    }

    @Override
    public HashMap<Integer, Double> getBalance(Integer userID) {
        User user = userManager.getUser(userID);
        HashMap<Integer, Double> balanceMap = new HashMap<Integer, Double>();
        for(LedgerEntry entry : user.getLedger()) {
            if(!balanceMap.containsKey(entry.getUserID())) {
                balanceMap.put(entry.getUserID(), 0.0);
            }
            Double currValue = balanceMap.get(entry.getUserID());
            balanceMap.put(entry.getUserID(), currValue + entry.getAmount());
        }

        return balanceMap;
    }

    @Override
    public void printBalance(Integer userID) {
        HashMap<Integer, Double> balanceMap = getBalance(userID);
        System.out.println("Pending Balance for userID: " + userID);
        for(Integer key : balanceMap.keySet()) {
            System.out.println(key + ": " + balanceMap.get(key));
        }
    }


}
