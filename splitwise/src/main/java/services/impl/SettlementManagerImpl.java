package services.impl;

import models.LedgerEntry;
import models.User;
import services.BalanceManager;
import services.SettlementManager;
import services.UserManager;

import java.util.HashMap;

public class SettlementManagerImpl implements SettlementManager {

    private UserManager userManager;
    private BalanceManager balanceManager;

    public SettlementManagerImpl(BalanceManager balanceManager, UserManager userManager) {
        this.balanceManager = balanceManager;
        this.userManager = userManager;
    }

    @Override
    public void settle(Integer senderID, Integer receiverID) {
        HashMap<Integer, Double> hm = balanceManager.getBalance(senderID);

        Double amt = hm.get(receiverID);
        if(amt > 0.0) {
            User sender = userManager.getUser(senderID);
            User receiver = userManager.getUser(receiverID);
            LedgerEntry e1 = new LedgerEntry(receiverID, -1*amt);
            LedgerEntry e2 = new LedgerEntry(senderID, amt);
            sender.addLedgerEntry(e1);
            receiver.addLedgerEntry(e2);
        }
    }
}
