package models;

import enums.SplitType;
import lombok.Data;
import java.util.HashMap;


@Data
public class Expense {
    Integer payerID;
    Double totalAmount;
    SplitType splitType;
    HashMap<Integer, Double> splitMap;

    public Expense(Integer payerID, Double totalAmount, SplitType splitType, HashMap<Integer, Double> splitMap) {
        this.payerID = payerID;
        this.totalAmount = totalAmount;
        this.splitMap = splitMap;
        this.splitType = splitType;
    }
}
