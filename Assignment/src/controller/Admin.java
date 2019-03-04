package controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import comparator.SortingByName;
import model.Customer;

public class Admin {
	
	private ArrayList<Customer> customerArray=new ArrayList<>();
	private final static int ADD_CCUSTOMER=1;
	private final static int ADD_CAR=2;
	private final static int PRINT_CUSTOMERS_SORTED_NAMES=3;
	private final static int PRINT_CUSTOMER=4;
	private final static int GENERATE_PRIZE=5;
	private final static int EXIT=6;
	
	
	
	/**
	 * 
	 * @throws IOException handles the exception thrown by bufferReader.
	 * in this method customer details will be added in the customer ArrayList.
	 * validateId is boolean variable which is being used to bound the code not having same id of two customers.
	  
	**/
		
		
	
	public void addCustomer() throws  IOException {
		String customerName;
		int customerId=-1;
		boolean validateId=true;
		Scanner scan=new Scanner(System.in);
		do {
		    System.out.println("enter the id of the customer");
		    if(scan.hasNextInt()){
				
				customerId=scan.nextInt();
				validateId=false;
				
			}
		else {
			scan.next();
			System.out.println("enter id in numbers only");
			}
		    
		}while(validateId);
	
		System.out.println("\n enter the name of the customer");
		customerName=scan.next();
		
		for(Customer custom:customerArray) {
			
		if(custom.getId()==customerId) {
			
				System.out.println("no two customers can have same ids");
				validateId=true;
				break;
			}
		
		}
		if(validateId==false)
		{
			Customer customer=new Customer(customerId,customerName);
			customerArray.add(customer);
			System.out.println("\n customer added successfully");
		}
	}
	
		
	
		
		
		
	
	/**
	 * 
	 * @throws IOException handles exception thrown by bufferReader.
	 * in this method customer is being assigned cars by the admin.
	 * addCar() is method defined in Customer class which has functionality of adding cars in the arraylist.
	 */
	public void addCarToCustomer() throws IOException {
		int customerAddId;
		Scanner scan=new Scanner(System.in);
		System.out.println("\nEnter the id of customer");
		customerAddId=scan.nextInt();
		for(Customer custom:customerArray) {
			if(custom.getId()==customerAddId)
			 custom.addCar();
		}
		
		
	}
	/**
	 * in this method a particular customer is searched by giving the id as in input.
	 * if non existing id is given in the input it will give a message to the user to enter valid id or to add new customer.
	 */
	public void printCustomerIds() {
		 int searchId;
		System.out.println("\nenter the id of the Customer you want to search");
		Scanner scan=new Scanner(System.in);
		searchId=scan.nextInt();
		
		for(Customer printCustomer:customerArray ){
			if(printCustomer.getId()==searchId){
				
				System.out.println("\ncustomer id="+printCustomer.getId()+"\ncustomer name= "+printCustomer.getName());
				printCustomer.printCarDetailsWithCustomer();
			}
			else {
				System.out.println("\nId does not exist "
						+ "\n please enter valid id or add new customer");
				
			}
			
			
		}
	}
	/**
	 * in this method details of all the customers will be printed sorted by their names .
	 * Collections has been used to sort the names of the customers in ascending orders.
	 * sorting mechanism has been performed in SortingByName class.
	 */
	public void printAllCustomers() {
		Collections.sort(customerArray,new SortingByName());
		if(customerArray.size()!=0)
		for(Customer custom:customerArray)
		{
			System.out.println("Customer id is="+custom.getId()+""
					+ "customer name is="+custom.getName());
			custom.printCarDetailsWithCustomer();
		}
		else {
			System.out.println("\nthere is no customer added till now");
		}
		
		
	}
	public static void main(String [] args) throws IOException {
		/**
		 * in the main function all the methods are being called as switch case is given.
		 * admin will be given choices as he needs to enter one.
		 * choice selected by the admin will be passed to switch statement and particular task will be performed.
		 */
		int choice;
		boolean condition=true;
		Admin admin=new Admin();
		Scanner scan=new Scanner(System.in);
		do {
		System.out.println("enter your choice:"
				+ "\n1-Add new Customer"
				+ "\n2-Add new car to Customer"
				+ "\n3-List all Customers with their cars sorted by name"
				+ "\n4-List individual Customers based on ID"
				+ "\n5-Generate prizes for the Customers"
				+ "\n6-exit");
		choice=scan.nextInt();
		
			
		
		switch(choice) {
		case ADD_CCUSTOMER:
			admin.addCustomer();
			break;
		
		case ADD_CAR:
			admin.addCarToCustomer();
			break;
			
		case PRINT_CUSTOMERS_SORTED_NAMES:
			admin.printAllCustomers();
		
			break;
			
			
		case PRINT_CUSTOMER:
			admin.printCustomerIds();
			break;
			
		case GENERATE_PRIZE:
			admin.generatePrizes();
			break;
		
		case EXIT:
			condition=false;
			break;
		default:
			System.out.println("\nplease enter valid entry");
			break;
			
			
		
		}
		
	}
		while(condition);
	}






/**
 * 
 * @throws IOException to handle the bufferaReader 
 * in this method one arrayList is given to store the choices of admin as he will enter 3 random ids of the customer (existing or non existing)
 * random class has been instantiated to generate 6 random ids will be checked is any one of them matches with the ids given by admin.
 * 
 */
	private void generatePrizes() throws IOException {
		ArrayList<Integer> takeId=new ArrayList<>();
		Scanner scan=new Scanner(System.in);
		System.out.println("please enter 3 random ids");
		for(int counter=0;counter<3;counter++) {
			takeId.add(scan.nextInt());
			
		}
		
		if(customerArray.size()==0) {
			System.out.println("\nThere is no customer till now");
			return;
			}
			else {
				    Random generate=new Random();
					for(int counter=0;counter<6;counter++) {
						int compare=generate.nextInt(customerArray.size());
						//System.out.println(compare);
					
					if(takeId.contains(customerArray.get(compare).getId())&& takeId.size()!=0) {
						System.out.println(customerArray.get(compare).getId()+"has won the prize");
						takeId.remove(new Integer(customerArray.get(compare).getId()));
						
					}
					else {
						return;
					}
					
					}
				
				 
			}
					
		
		
		
	}
	
		

}

