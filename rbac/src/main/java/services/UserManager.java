package services;

import models.Role;
import models.User;

public interface UserManager {

    public void addRole(User user, Role role);

    public void removeRole(User user, Role role);

    public boolean checkAccess(User user, Role role);
}
