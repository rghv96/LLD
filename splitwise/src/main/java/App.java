import enums.SplitType;
import models.Expense;
import services.BalanceManager;
import services.ExpenseManager;
import services.SettlementManager;
import services.UserManager;
import services.impl.BalanceManagerImpl;
import services.impl.ExpenseManagerImpl;
import services.impl.SettlementManagerImpl;
import services.impl.UserManagerImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class App {

    public static void main(String[] args) throws IOException {

        UserManager userManager = new UserManagerImpl();
        BalanceManager balanceManager = new BalanceManagerImpl(userManager);
        ExpenseManager expenseManager = new ExpenseManagerImpl(userManager);
        SettlementManager settlementManager = new SettlementManagerImpl(balanceManager, userManager);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input1 = bufferedReader.readLine();
        String input2 = bufferedReader.readLine();

        do {
            String methodName = input1.trim();
            String[] arguments = input2.trim().split(" ");

            try {
                if(methodName.equals("printBalance")) {
                    balanceManager.printBalance(Integer.parseInt(arguments[0]));
                } else if(methodName.equals("settle")) {
                    settlementManager.settle(Integer.parseInt(arguments[0]), Integer.parseInt(arguments[1]));
                } else if(methodName.equals("addExpense")){
                    Integer payerID = Integer.parseInt(arguments[0]);
                    Double totalAmt = Double.parseDouble(arguments[1]);
                    SplitType splitType = SplitType.valueOf(arguments[2]);
                    Integer numSplits = Integer.parseInt(arguments[3]);
                    HashMap<Integer, Double> hm = new HashMap<Integer, Double>();
                    Integer i = 0;
                    while(i < numSplits) {
                        Integer userID = Integer.parseInt(arguments[4 + i]);
                        i++;
                        Double split = Double.parseDouble(arguments[4 + i]);
                        i++;
                        hm.put(userID, split);
                    }
                    Expense e = new Expense(payerID, totalAmt, splitType, hm);
                    expenseManager.addExpense(e);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            input1 = bufferedReader.readLine();
            input2 = bufferedReader.readLine();

        } while(input1 != null && !input1.isEmpty() && input2 != null && !input2.isEmpty());
        bufferedReader.close();
    }
}