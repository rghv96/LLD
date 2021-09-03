package services;

import enums.ActionType;
import models.Resource;
import models.User;

public interface AccessManager {
    public void grant(User user, Resource resource, ActionType actionType);

    public void revoke(User user, Resource resource, ActionType actionType);

    public boolean checkAccess(User user, Resource resource, ActionType actionType);
}
