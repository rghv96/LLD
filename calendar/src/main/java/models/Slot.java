package models;

import enums.SlotStatus;

public class Slot {
    public Integer userID;
    public Integer startTime;
//    private Integer endTime;
    public SlotStatus slotStatus;

    public Slot(Integer userID, Integer startTime, SlotStatus s) {
        this.userID = userID;
        this.startTime = startTime;
        this.slotStatus = s;
    }
}
