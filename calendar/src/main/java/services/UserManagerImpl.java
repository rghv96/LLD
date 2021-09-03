package services;

import enums.SlotStatus;
import models.Slot;
import models.User;

import java.util.HashMap;
import java.util.List;

public class UserManagerImpl {
    private HashMap<Integer, User> userHashMap;

    public UserManagerImpl() {
        userHashMap = new HashMap<Integer, User>();
    }

    public User getUser(Integer userID) {
        if(!userHashMap.containsKey(userID)) {
            User u = new User(userID);
            userHashMap.put(userID, u);
        }
        return userHashMap.get(userID);
    }

    public void addSlots(Integer userID, List<Integer> times) {
        User u = getUser(userID);
        for(Integer i : times) {
            Slot s = new Slot(userID, i, SlotStatus.AVAILABLE);
            u.slotHashMap.put(i, s);
        }
    }

    public void getAvailableSlots(Integer userID, Integer time) {
        System.out.println("The available slots are: ");
        User u = getUser(userID);
        for(Integer i:u.slotHashMap.keySet()) {
            Slot s = u.slotHashMap.get(i);
            if(i < time || s.slotStatus.equals(SlotStatus.BOOKED)) {
                continue;
            }
            System.out.println(i);
        }
    }

    public void bookSlot(Integer userID, Integer requestorID, Integer time) {
        User u = getUser(userID);
        User r = getUser(requestorID);

    }

}
