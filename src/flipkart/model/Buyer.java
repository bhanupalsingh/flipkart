package flipkart.model;

import java.util.ArrayList;
import java.util.List;

public class Buyer extends Person {
	List<Auction> auctions;
	private boolean preferred;
	
	public Buyer(String id) {
		super(id);
		this.auctions = new ArrayList<>();
		this.preferred = false;
	}

	public List<Auction> getAuctions() {
		return auctions;
	}

	public void setAuctions(List<Auction> auctions) {
		this.auctions = auctions;
	}
	
	public void setPreferred(boolean value) {
		this.preferred = value;
	}

	

	
}
