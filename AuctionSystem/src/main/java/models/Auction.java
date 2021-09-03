package models;

import lombok.Data;

import java.util.HashMap;

@Data
public class Auction {
    private String auctionID;
    private Double lowestBid;
    private Double highestBid;
    private Double sellingBid;
    private Double participationCost;
    private HashMap<String, Bidder> bidderMap;
    private Seller seller;
    private Boolean closed;


    public Auction(String auctionID, Double lowestBid, Double highestBid, Double participationCost, Seller seller) {
        this.auctionID = auctionID;
        this.lowestBid = lowestBid;
        this.highestBid = highestBid;
        this.participationCost = participationCost;
        this.seller = seller;
        this.closed = false;
        this.bidderMap = new HashMap<String, Bidder>();
    }

    public void addBidder(String bidderID, Bidder bidder) {
        if(bidder.getBidAmount() < lowestBid || bidder.getBidAmount() > highestBid) {
            System.out.println("bid out of permissible range");
            return;
        }
        if(bidderMap.containsKey(bidderID)) {
            System.out.println("bidder already present");
            return;
        }
        bidderMap.put(bidderID, bidder);
    }

    public void updateBid(String bidderID, Double bid) {
        if(bid < lowestBid || bid > highestBid) {
            System.out.println("bid out of permissible range");
            return;
        }
        if(!bidderMap.containsKey(bidderID)) {
            System.out.println("bidder not present, create a new bid first");
            return;
        }
        Bidder bidder = bidderMap.get(bidderID);
        bidder.setBidAmount(bid);
    }

    public void withdrawBid(String bidderID) {
        bidderMap.remove(bidderID);
    }

    public void findWinner() {
        HashMap<Double, String> bidMap = new HashMap<Double, String>();
        HashMap<Double, Integer> freqMap = new HashMap<Double, Integer>();

        for(String bidderID : bidderMap.keySet()) {
            Bidder bidder = bidderMap.get(bidderID);
            Double bid = bidder.getBidAmount();
            Integer f = freqMap.get(bid);
            if(f == null) {
                f = Integer.valueOf(0);
            }
            freqMap.put(bid, f + 1);
            bidMap.put(bid, bidderID);
        }

        Double winnerBid = 0.0;
        String winnerID = "";
        for(Double bid : freqMap.keySet()) {
            if(freqMap.get(bid) > 1) {
                continue;
            }
            if(bid > winnerBid) {
                winnerBid = bid;
                winnerID = bidMap.get(bid);
            }
        }
        this.sellingBid = winnerBid;
        if(winnerID != "") {
            System.out.println("Winner is " + winnerID);
        }
        else {
            System.out.println("No winner");
        }
    }

    public void getSellerProfit() {
        Double profit = sellingBid + participationCost;
        profit -= (0.2) * participationCost*bidderMap.keySet().size();
        profit -= (lowestBid + highestBid)/2;
        System.out.println("Profit: " + profit);
    }

}
