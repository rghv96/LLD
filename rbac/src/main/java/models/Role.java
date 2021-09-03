package models;

import enums.ActionType;

public class Role {

    private Resource resource;

    private ActionType actionType;

    public Role(Resource resource, ActionType actionType) {
        this.resource = resource;
        this.actionType = actionType;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public Resource getResource() {
        return resource;
    }
}
