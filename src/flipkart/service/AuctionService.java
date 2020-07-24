package flipkart.service;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import flipkart.manager.Manager;
import flipkart.model.Auction;
import flipkart.model.AuctionStatus;
import flipkart.model.Bidding;
import flipkart.model.Buyer;
import flipkart.model.Seller;

public class AuctionService {
	private Manager manager;

    public AuctionService(Manager manager) {
        this.manager = manager;
    }

    public Boolean createAuction(String aid , double llimit , double hlimit , double cost , String s) {
    	Seller seller = this.manager.getSeller(s);
    	Auction auction = this.manager.getAuction(aid);
    	if(auction == null) {
    		auction = new Auction(aid , llimit , hlimit , cost , seller);
            this.manager.addAuction(auction);
        	System.out.println("Auction added");
            return true;
    	}
    	
    	System.out.println("Auction exists");
		return false;
    }
    
    
   public Boolean createBid(String bid , String aid , double budget) {
    	Buyer b = this.manager.getBuyer(bid);
    	Auction a = this.manager.getAuction(aid);
    	
    	if(a.getAuctionStatus().equals(AuctionStatus.COMPLETE)) {
    		System.out.println("Auciton closed");
    		return false;
    	}
    	
	    List<Bidding> bidding = (List<Bidding>) this.manager.getBidding(aid);	
    	if(budget >= a.getLlimit() && budget <= a.getHlimit()) {
    		boolean match = false;
    		for(Bidding bidd : bidding) {
    			if(bidd.getBuyer().getId().equals(bid)) {
    				match = true;
    				bidd.setCost(budget);
    				this.manager.updateBidding(bidd);
    			}
    		}
    		
    		if(match == false) {
    			Bidding biddingNew = new Bidding(b,a,budget);
    			this.manager.addBilling(biddingNew);
    		}
    		
    		
    		System.out.println("Bid created");
    		return true;
    		
    	}else {
    		System.out.println("Bid amount wrong");
    		return false;
    	}
    	
    	
    	
    }
   
   
   public void closeAuction(String aid) {
	   Auction a = this.manager.getAuction(aid);
	   a.setAuctionStatus(AuctionStatus.COMPLETE);
	   this.manager.updateAuction(a);
	   System.out.println("Auciton closed");
   
	   List<Bidding> biddings = (List<Bidding>) this.manager.getBidding(aid);
	   
	   HashMap<Double , Bidding> bMap = new HashMap<>();
	   HashMap<Double , Integer> bMapCount = new HashMap<>();
	   String bwp = null;
	   String bp = null;
	   double bwpcost = -1;
	   double bpcost = -1;
	   double pwp = 0;
	   double pp = 0;
	   Seller s = null;
	   
	   
	   for(Bidding b : biddings) {
		   if(bMapCount.containsKey(b.getCost())) {
			   bMapCount.put(b.getCost(), bMapCount.get(b.getCost())+1);
		   }else {
			   bMapCount.put(b.getCost(), 1);
		   }
	   }
	   
	   
	   for(Bidding b : biddings) {
		   if(bMapCount.get(b.getCost()) > 1) {
			   if(b.getCost() > bpcost) {
				   bp = b.getBuyer().getId();
				   bpcost = b.getCost();
				   pp = b.getCost() + (b.getAuction().getPcost() * biddings.size() * 0.2) - ( (b.getAuction().getHlimit() + b.getAuction().getLlimit())/2);
			   }
		   }else {
			   bMap.put(b.getCost(), b);
			   if(b.getCost() > bwpcost) {
				   bwp = b.getBuyer().getId();
				   bwpcost = b.getCost();
				   pwp = b.getCost() + (b.getAuction().getPcost() * biddings.size() * 0.2) - ( (b.getAuction().getHlimit() + b.getAuction().getLlimit())/2);
			   }
			   
			   s = b.getAuction().getSeller();
		   }
	   }
	   
	   
	   
	   
	   if(bwpcost > bpcost) {
		   System.out.println("winner:-"+bwp);
		   s.addProfit(aid, pwp);
	   }else if(bpcost > bwpcost) {
		   System.out.println("winner:-"+bp);
		   s.addProfit(aid, pp);
	   }else {
		   System.out.println("No winner");
	   }
   
   
   }
   
   
   public void getProfit(String s ) {
	 	 Seller seller = this.manager.getSeller(s);
	 	 Hashtable <String , Double > profit = seller.getProfit();
	 	double total = 0; 
	 	Set<String> keys = profit.keySet();
	 	Iterator<String> itr = keys.iterator();
	 
	    while (itr.hasNext()) { 
	       String str = itr.next();
	       total += profit.get(str);
	    } 
	    
	    System.out.println("total"+total);
	   
   }	
   
   
    
    
    
}
