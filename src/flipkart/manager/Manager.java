package flipkart.manager;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import flipkart.model.Auction;
import flipkart.model.Bidding;
import flipkart.model.Buyer;
import flipkart.model.Seller;

public class Manager {
	private Hashtable<String,Buyer> buyers;
	private Hashtable<String,Seller> sellers;
	private Hashtable<String, Auction> auctions;
	private List<Bidding> biddings;
	
	
	public Manager() {
		buyers = new Hashtable<>();
		sellers = new Hashtable<>();
		auctions = new Hashtable<>();
		biddings = new ArrayList<Bidding>();
	}


	public Hashtable<String, Buyer> getBuyers() {
		return buyers;
	}
	
	
	public void setBuyers(Hashtable<String, Buyer> buyers) {
		this.buyers = buyers;
	}


	public Hashtable<String, Seller> getSellers() {
		return sellers;
	}


	public void setSellers(Hashtable<String, Seller> sellers) {
		this.sellers = sellers;
	}


	public Hashtable<String, Auction> getAuction() {
		return auctions;
	}


	public void setAuction(Hashtable<String, Auction> auction) {
		this.auctions = auction;
	}


	public List<Bidding> getBidding() {
		return biddings;
	}


	
	
	
	public Buyer getBuyer(String id) {
		if(buyers.containsKey(id)) {
			return buyers.get(id);
		}
		
		return null;
	}
	
	public Seller getSeller(String id) {
		if(sellers.containsKey(id)) {
			return sellers.get(id);
		}
		
		return null;
	}
	
	public Auction getAuction(String id) {
		if(auctions.containsKey(id)) {
			return auctions.get(id);
		}
		
		return null;
	}
	
	public List<Bidding>  getBidding(String id) {
		List<Bidding> bidding = new ArrayList<>();
		for(Bidding b : biddings) {
			if(b.getAuction().getId().equals(id)){
				bidding.add(b);
			}
		}
		return bidding;
	}
	
	
	
	
	public void addBuyer(Buyer b) {
		buyers.put(b.getId(), b);
	}
	
	public void addSeller(Seller b) {
		sellers.put(b.getId(), b);
	}
	
	public void addBilling(Bidding b) {
		biddings.add(b);
	}
	
	public void addAuction(Auction b) {
		auctions.put(b.getId(), b);
	}
	
	public void updateBidding(Bidding bidding) {
		for(Bidding b : biddings) {
			if(b.getAuction().getId().equals(bidding.getAuction().getId()) && b.getAuction().getId().equals(bidding.getAuction().getId())){
				b.setCost(bidding.getCost());
			}
		}
	}
	
	
	public void updateAuction(Auction a) {
		auctions.put(a.getId(), a);
	}
	
	
	
	
	
	
}
