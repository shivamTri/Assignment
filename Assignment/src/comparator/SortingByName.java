package comparator;
import java.util.Comparator;

import model.Customer;


public class SortingByName implements Comparator<Customer> {
	
	/**
	 * this class is implementing Comparator class to get the names in orders.
	 * @return ordered names of the arrayList.
	 */
	@Override
	
	public int compare(Customer customerName1, Customer customerName2) {
		
		return customerName1.getName().compareTo(customerName2.getName());
	}
	
	

}
