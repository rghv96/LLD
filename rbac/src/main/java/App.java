import enums.ActionType;
import enums.UserType;
import models.Resource;
import models.User;
import services.AccessManager;
import services.UserManager;
import services.impl.AccessManagerImpl;
import services.impl.UserManagerImpl;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        //create resources
        Resource r1 = new Resource("AWS");
        Resource r2 = new Resource("GCP");
        Resource r3 = new Resource("Azure");

        //create users
        User u1 = new User("e1", UserType.EMPLOYEE);
        User u2 = new User("e2", UserType.EMPLOYEE);

        UserManager userManager = new UserManagerImpl();
        AccessManager accessManager = new AccessManagerImpl(userManager);
        accessManager.grant(u1, r1, ActionType.READ);
        accessManager.revoke(u1, r3, ActionType.DELETE);
        accessManager.grant(u2, r2, ActionType.WRITE);
        u1.printDetails();
        u2.printDetails();
    }
}
