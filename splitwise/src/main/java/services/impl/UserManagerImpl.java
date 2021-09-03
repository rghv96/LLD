package services.impl;

import models.User;
import services.UserManager;

import java.util.HashMap;

public class UserManagerImpl implements UserManager {

    private HashMap<Integer, User> userMap;

    public UserManagerImpl() {
        userMap = new HashMap<Integer, User>();
    }

    @Override
    public User getUser(Integer userID) {
        if(!userMap.containsKey(userID)) {
            User user = new User(userID);
            userMap.put(userID, user);
        }
        return userMap.get(userID);
    }
}
