import services.UserManagerImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {
        UserManagerImpl userManager = new UserManagerImpl();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input1 = bufferedReader.readLine();
        String input2 = bufferedReader.readLine();

        do {
            String method = input1.trim();
            String[] arguments = input2.trim().split(" ");
            try {
                if("addSlots".equals(method)) {
                    Integer userID = Integer.parseInt(arguments[0]);
                    Integer numSlots = Integer.parseInt(arguments[1]);
                    List<Integer> times = new ArrayList<Integer>();
                    Integer i = 0;
                    while(i < numSlots) {
                        Integer st = Integer.parseInt(arguments[2 + i]);
                        i++;
                        times.add(st);
                    }
                    userManager.addSlots(userID, times);
                }
                else if("availableSlots".equals(method)) {
                    Integer userID = Integer.parseInt(arguments[0]);
                    Integer time = Integer.parseInt(arguments[1]);
                    userManager.getAvailableSlots(userID, time);
                }
//                else if(method.equals("bookSlot")) {
//                    Integer userID = Integer.parseInt(args[0]);
//                    Integer requestorID = Integer.parseInt(args[1]);
//                    Integer time = Integer.parseInt(args[2]);
//                    userManager.bookSlot(userID, requestorID, time);
//                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            input1 = bufferedReader.readLine();
            input2 = bufferedReader.readLine();
        } while(input1 != null && !input1.isEmpty() && input2 != null && !input2.isEmpty());
        bufferedReader.close();
    }
}


/*
addSlots
1 3 10 20 30
availableSlots
1 0
 */
