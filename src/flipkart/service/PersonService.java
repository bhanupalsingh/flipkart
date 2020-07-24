package flipkart.service;

import flipkart.manager.Manager;
import flipkart.model.Buyer;
import flipkart.model.Seller;

public class PersonService {
	private Manager manager;

    public PersonService(Manager manager) {
        this.manager = manager;
    }

	
	
	public Boolean addBuyer(String s) {
		Buyer b = this.manager.getBuyer(s);
		if(b == null) {
			b = new Buyer(s); 
			this.manager.addBuyer(b);
			System.out.println("Buyer added");

		    return true;
		}
		
		System.out.println("Buyer already there");
		return false;
    }
	
	public Boolean addSeller(String  s) {
		Seller b = this.manager.getSeller(s);
		if(b == null) {
			b = new Seller(s); 
			this.manager.addSeller(b);
			System.out.println("Seller added");

		    return true;
		}
		
		System.out.println("seller already there");
		return false;
    }
	
	
	
	
	
}
