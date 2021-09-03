package models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class User {
    private Integer id;
    private List<LedgerEntry> ledger;

    public User(Integer userID) {
        id = userID;
        ledger = new ArrayList<LedgerEntry>();
    }

    public void addLedgerEntry(LedgerEntry entry) {
        ledger.add(entry);
    }



}
