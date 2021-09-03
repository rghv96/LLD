package services.impl;

import enums.SplitType;
import models.Expense;
import models.LedgerEntry;
import models.User;
import services.ExpenseManager;
import services.UserManager;

import java.util.HashMap;

public class ExpenseManagerImpl implements ExpenseManager {

    private UserManager userManager;

    public ExpenseManagerImpl(UserManager userManager) {
        this.userManager = userManager;
    }

    @Override
    public void addExpense(Expense expense) {

        if(expense.getSplitType() == null) {
            System.out.println("[ERROR]: Invalid split type");
            return;
        }

        Double currAmount = 0.0;
        for(Double d : expense.getSplitMap().values()) {
            if(expense.getSplitType().equals(SplitType.PERCENTAGE)) {
                d = d/100;
                d = d*expense.getTotalAmount();
            }
            currAmount += d;
        }

        if(!expense.getTotalAmount().equals(currAmount)) {
            System.out.println("[ERROR]: Amount mismatch");
            return;
        }

        User payee = userManager.getUser(expense.getPayerID());
        for(Integer userID: expense.getSplitMap().keySet()) {
            if(userID.equals(expense.getPayerID())) {
                continue;
            }

            Double amt = expense.getSplitMap().get(userID);
            if(expense.getSplitType().equals(SplitType.PERCENTAGE)) {
                amt = amt/100;
                amt = amt*expense.getTotalAmount();
            }

            User user = userManager.getUser(userID);
            LedgerEntry e1 = new LedgerEntry(userID, -1*amt);
            LedgerEntry e2 = new LedgerEntry(expense.getPayerID(), amt);
            payee.addLedgerEntry(e1);
            user.addLedgerEntry(e2);
        }

        return;

    }
}
