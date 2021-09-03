package services;

import java.util.HashMap;

public interface BalanceManager {

    HashMap<Integer, Double> getBalance(Integer userID);

    void printBalance(Integer userID);
}
