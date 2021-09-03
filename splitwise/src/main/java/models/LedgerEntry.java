package models;

import lombok.Data;

@Data
public class LedgerEntry {
//    private Integer id;
    private Integer userID;
    private Double amount;
//    private Integer createdAt;

    public LedgerEntry(Integer userID, Double amount) {
        this.userID = userID;
        this.amount = amount;
    }
}
