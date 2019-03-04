package model;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Customer {
	private String customerName;
	private int customerId;
	private final static int Hyundai=1;
	private final static int Toyota=2;
	private final static int Maruti=3;
	/**
	 * car is an arrayList which is storing all the cars objects.
	 */
	
	private ArrayList<Car> car=new ArrayList<>();
	/**
	 * 
	 * @param customerId2 is constructor parameter which will store the id of the customers.
	 * @param customerName2 is constructor parameter which will store the names of the customers.
	 */
	public Customer(final int customerId2,final String customerName2) {
		
		this.customerId=customerId2;
		this.customerName=customerName2;
	}
	
	public void printCarDetailsWithCustomer() {
		for(Car carDetail:car) {
			carDetail.printCarDetails();
		}
	}
	
	/**
	 * 
	 * @throws IOException this exception is occurring because of bufferReader class.
	 * this method is holding switch cases for calling the methods of car's class.
	 * objects of cars are being added one by one in the car arrayList defined above 
	 */
	public void addCar() throws IOException {
		int choice;
		int carId;
		String modelNumber;
		double price;
		BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));
		System.out.println("which car you want to add"
				+ "\n1-hyundai"
				+ "\n2-toyota"
				+ "\n3-maruti");
		
		choice=Integer.parseInt(inp.readLine());
	
		switch(choice) {
		case Hyundai:
			System.out.println("\n\nenter carid ,model number and price ");
			carId=Integer.parseInt(inp.readLine());
			modelNumber=inp.readLine();
			price=Double.parseDouble(inp.readLine());
			Hyundai hyundai=new Hyundai(carId,modelNumber,price);
			car.add(hyundai);
			break;
			
		case Toyota:
			
			System.out.println("\nenter carid ,model number and price ");
			carId=Integer.parseInt(inp.readLine());
			modelNumber=inp.readLine();
			price=Double.parseDouble(inp.readLine());
			Toyota toyota=new Toyota(carId,modelNumber,price);
			car.add(toyota);
			break;
		
		case Maruti:
			
			System.out.println("\n\nenter carid ,model number and price ");
			carId=Integer.parseInt(inp.readLine());
			modelNumber=inp.readLine();
			price=Double.parseDouble(inp.readLine());
			Maruti maruti=new Maruti(carId,modelNumber,price);
			car.add(maruti);
			break;
			
		default: 
			System.out.println("\n\nplease enter valid choice");
			
		}
		
	}
	/**
	 * 
	 * @return customerId which will return the id of the customer.
	 */

	public int getId() {
		
		return customerId;
	}
	/**
	 * 
	 * @return customerName which will return the name of the customer.
	 */
	public String getName() {
		return customerName;
	}
}
	

	


