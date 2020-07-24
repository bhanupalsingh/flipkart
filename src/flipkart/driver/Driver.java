package flipkart.driver;

import java.util.Scanner;

import flipkart.manager.Manager;
import flipkart.service.AuctionService;
import flipkart.service.PersonService;

public class Driver {
	public static void main(String[] args) {
		Manager manager = new Manager();
		AuctionService as = new AuctionService(manager);
		PersonService ps = new PersonService(manager);
		
		
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			try {
				String[] s = sc.nextLine().split(",");
				switch(s[0]) {
				case "ADD_BUYER":
					ps.addBuyer(s[1]);
					break;
				case "ADD_SELLER":
					ps.addSeller(s[1]);
					break;
				case "CREATE_AUCTION":
					as.createAuction(s[1],Double.parseDouble(s[2]),Double.parseDouble(s[3]),Double.parseDouble(s[4]),s[5]);
					break;
				case "CREATE_BID":
					as.createBid(s[1], s[2], Double.parseDouble(s[3]));
					break;
				case "CLOSE_AUCTION":
					as.closeAuction(s[1]);
					break;
				case "GET_PROFIT":
					as.getProfit(s[1]);
					break;
				default :
					System.out.println("Wrong input");
					
				}
			}catch(Exception e) {
				
			}
			
			
			
		}
	}
}
