package services.impl;

import services.UserManager;
import models.Role;
import models.User;

import java.util.List;

public class UserManagerImpl implements UserManager {

    @Override
    public void addRole(User user, Role role) {
        List<Role> roles = user.getRoles();
        if(roles.contains(role)) {
            return;
        }
        roles.add(role);
        user.setRoles(roles);
    }

    @Override
    public void removeRole(User user, Role role) {
        List<Role> roles = user.getRoles();
        roles.remove(role);
    }

    @Override
    public boolean checkAccess(User user, Role role) {
        List<Role> roles = user.getRoles();
        return roles.contains(role);
    }
}
