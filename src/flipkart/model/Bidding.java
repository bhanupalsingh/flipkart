package flipkart.model;

public class Bidding {
	private Buyer buyer;
	private Auction auction;
	private double cost;
	
	public Bidding(Buyer buyer, Auction auction, double cost) {
		this.buyer = buyer;
		this.auction = auction;
		this.cost = cost;
	}
	
	
	public Buyer getBuyer() {
		return buyer;
	}
	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}
	public Auction getAuction() {
		return auction;
	}
	public void setAuction(Auction auction) {
		this.auction = auction;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	
	
}
