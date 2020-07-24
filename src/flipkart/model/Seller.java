package flipkart.model;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Seller extends Person {
	List<Auction> auctions;
	private Hashtable<String,Double> profit;
	
	
	public Seller(String id) {
		super(id);
		this.auctions = new ArrayList<>();
		this.profit = new Hashtable<>();
	}


	public List<Auction> getAuctions() {
		return auctions;
	}


	public void setAuctions(List<Auction> auctions) {
		this.auctions = auctions;
	}
	
	
	public void addProfit(String aid , double amount) {
		this.profit.put(aid, amount);
	}
	
	public Hashtable<String, Double > getProfit(){
		return this.profit;
	}

	
	
	
	
}
