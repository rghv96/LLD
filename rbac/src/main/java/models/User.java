package models;

import enums.UserType;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String email;
    private UserType userType;
    private List<Role> roles;

    public User(String email, UserType userType) {
        this.email = email;
        this.userType = userType;
        this.roles = new ArrayList<Role>();
    }
    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void printDetails() {
        System.out.println("Email: " + email);
        System.out.println("Type: " + userType);
        if(roles.size() > 0) {
            System.out.println("Roles:");
            for(Role role:roles) {
                System.out.println(role.getResource().getName() + " " + role.getActionType());
            }
        }
        System.out.println("");
    }
}
