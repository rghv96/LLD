package services.impl;

import enums.ActionType;
import models.Resource;
import models.Role;
import models.User;
import services.AccessManager;
import services.UserManager;

public class AccessManagerImpl implements AccessManager {

    private UserManager userManager;

    public AccessManagerImpl(UserManager userManager) {
        this.userManager = userManager;
    }

    @Override
    public void grant(User user, Resource resource, ActionType actionType) {
        Role role = new Role(resource, actionType);
//        UserManager userManager = new UserManagerImpl();
        userManager.addRole(user, role);
    }

    @Override
    public void revoke(User user, Resource resource, ActionType actionType) {
        Role role = new Role(resource, actionType);
        userManager.removeRole(user, role);
    }

    @Override
    public boolean checkAccess(User user, Resource resource, ActionType actionType) {
        Role role = new Role(resource, actionType);
        return userManager.checkAccess(user, role);

    }
}
