package services;

import models.Auction;
import models.Bidder;
import models.Buyer;
import models.Seller;

import java.util.HashMap;


// should implement interface
public class AuctionManagerImpl {
    private SellerManagerImpl sellerManager;
    private BuyerManagerImpl buyerManager;
    private HashMap<String, Auction> auctionHashMap;

    public AuctionManagerImpl(SellerManagerImpl sellerManager, BuyerManagerImpl buyerManager) {
        this.sellerManager = sellerManager;
        this.buyerManager = buyerManager;
        this.auctionHashMap = new HashMap<String, Auction>();
    }

    public void createAuction(String auctionID, Double lowBidLimit, Double highBidLimit, Double pc, String sellerID) {
        Seller seller = sellerManager.getSeller(sellerID);
        Auction auction = new Auction(auctionID, lowBidLimit, highBidLimit, pc, seller);
        if(!auctionHashMap.containsKey(auctionID)) {
            auctionHashMap.put(auctionID, auction);
        }
        else {
            System.out.println("[ERROR] auctionID already in use");
        }
    }

    public Auction getAuction(String auctionID) {
        if(!auctionHashMap.containsKey(auctionID)) {
            System.out.println("[ERROR] auctionID not present");
        }
        return auctionHashMap.get(auctionID);
    }

    public void createBid(String buyerID, String auctionID, Double bid) {
        Buyer buyer = buyerManager.getBuyer(buyerID);
        if (buyer == null) {
            System.out.println("[ERROR] buyer not exist");
            return;
        }
        Auction auction = getAuction(auctionID);
        if(auction == null) {
            System.out.println("[ERROR] auction not exist");
            return;
        }
        buyer.addAuction(auction.getAuctionID());
        Bidder bidder = new Bidder(buyer, bid);
        auction.addBidder(buyerID, bidder);
    }

    public void updateBid(String buyerID, String auctionID, Double bid)  {
        Buyer buyer = buyerManager.getBuyer(buyerID);
        if (buyer == null) {
            System.out.println("[ERROR] buyer not exist");
            return;
        }
        Auction auction = getAuction(auctionID);
        if(auction == null) {
            System.out.println("[ERROR] auction not exist");
            return;
        }
        auction.updateBid(buyerID, bid);
    }

    public void closeAuction(String auctionID) {
        Auction auction = getAuction(auctionID);
        if(auction == null) {
            System.out.println("[ERROR] auction not exist");
            return;
        }
        auction.setClosed(true);
        auction.findWinner();
    }

    public void withdrawBid(String buyerID, String auctionID) {
        Buyer buyer = buyerManager.getBuyer(buyerID);
        if (buyer == null) {
            System.out.println("[ERROR] buyer not exist");
            return;
        }
        Auction auction = getAuction(auctionID);
        if(auction == null) {
            System.out.println("[ERROR] auction not exist");
            return;
        }
        buyer.removeAuction(auction.getAuctionID());
        auction.withdrawBid(buyerID);
    }

    public void getSellerProfit(String sellerID, String auctionID) {

        Seller seller = sellerManager.getSeller(sellerID);
        if (seller == null) {
            System.out.println("[ERROR] seller not exist");
            return;
        }
        Auction auction = getAuction(auctionID);
        if(auction == null) {
            System.out.println("[ERROR] auction not exist");
            return;
        }
        if(!auction.getSeller().getSellerID().equals(sellerID)) {
            System.out.println("[ERROR] seller not associated to auction");
            return;
        }
        if(!auction.getClosed()) {
            System.out.println("[ERROR] auction not closed");
            return;
        }
        auction.getSellerProfit();
    }


}
