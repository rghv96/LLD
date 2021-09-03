import services.AuctionManagerImpl;
import services.BuyerManagerImpl;
import services.SellerManagerImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws IOException {
        BuyerManagerImpl buyerManager = new BuyerManagerImpl();
        SellerManagerImpl sellerManager = new SellerManagerImpl();
        AuctionManagerImpl auctionManager = new AuctionManagerImpl(sellerManager, buyerManager);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input1 = bufferedReader.readLine();
        String input2 = bufferedReader.readLine();

        do {
            String methodName = input1.trim();
            String[] arguments = input2.trim().split(" ");

            try {
                if(methodName.equals("addBuyer")) {
                    buyerManager.createBuyer(arguments[0]);
                } else if(methodName.equals("addSeller")) {
                    sellerManager.createSeller(arguments[0]);
                } else if(methodName.equals("createAuction")) {
                    String auctionID = arguments[0];
                    Double lowBid = Double.parseDouble(arguments[1]);
                    Double highBid = Double.parseDouble(arguments[2]);
                    Double pc = Double.parseDouble(arguments[3]);
                    String sellerID = arguments[4];
                    auctionManager.createAuction(auctionID, lowBid, highBid, pc, sellerID);
                } else if(methodName.equals("createBid")) {
                    String buyerID = arguments[0];
                    String auctionID = arguments[1];
                    Double bid = Double.parseDouble(arguments[2]);
                    auctionManager.createBid(buyerID, auctionID, bid);
                } else if(methodName.equals("updateBid")) {
                    String buyerID = arguments[0];
                    String auctionID = arguments[1];
                    Double bid = Double.parseDouble(arguments[2]);
                    auctionManager.updateBid(buyerID, auctionID, bid);
                } else if(methodName.equals("withdrawBid")) {
                    String buyerID = arguments[0];
                    String auctionID = arguments[1];
                    auctionManager.withdrawBid(buyerID, auctionID);
                } else if(methodName.equals("closeAuction")) {
                    String auctionID = arguments[0];
                    auctionManager.closeAuction(auctionID);
                } else if(methodName.equals("getProfit")) {
                    String sellerID = arguments[0];
                    String auctionID = arguments[1];
                    auctionManager.getSellerProfit(sellerID, auctionID);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            input1 = bufferedReader.readLine();
            input2 = bufferedReader.readLine();

        } while(input1 != null && !input1.isEmpty() && input2 != null && !input2.isEmpty());
        bufferedReader.close();
    }
}

// test cases
/*
addBuyer
buyer1
addBuyer
buyer2
addBuyer
buyer3
addSeller
seller1
createAuction
A1 10 50 1 seller1
createBid
buyer1 A1 17
createBid
buyer2 A1 15
updateBid
buyer2 A1 19
createBid
buyer3 A1 19
closeAuction
A1
getProfit
seller1 A1
 */

/*
addSeller
seller2
createAuction
A2 5 20 2 seller2
createBid
buyer3 A2 25
createBid
buyer2 A2 5
withdrawBid
buyer2 A2
closeAuction
A2
getProfit
seller2 A2
 */