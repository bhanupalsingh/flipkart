package flipkart.model;

public class Auction {
	private String id;
	private double llimit;
	private double hlimit;
	private double pcost;
	private Seller seller;
	private AuctionStatus auctionStatus;
	
	
	public Auction(String id, double llimit, double hlimit, double pcost, Seller seller) {
		this.id = id;
		this.llimit = llimit;
		this.hlimit = hlimit;
		this.pcost = pcost;
		this.seller = seller;
		this.auctionStatus = AuctionStatus.ACTIVE;
	}
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getLlimit() {
		return llimit;
	}

	public void setLlimit(double llimit) {
		this.llimit = llimit;
	}

	public double getHlimit() {
		return hlimit;
	}

	public void setHlimit(double hlimit) {
		this.hlimit = hlimit;
	}

	public double getPcost() {
		return pcost;
	}

	public void setPcost(double pcost) {
		this.pcost = pcost;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public AuctionStatus getAuctionStatus() {
		return auctionStatus;
	}

	public void setAuctionStatus(AuctionStatus auctionStatus) {
		this.auctionStatus = auctionStatus;
	}
	
	
	
	
	
	
	
	
	
	
}
