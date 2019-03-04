package model;



abstract public class Car {
	private int carId;
	private String modelNumber;
	private Double price;
	
	abstract public double resaleValue(); 
	abstract public void printCarDetails();
	/**
	 * 
	 * @param carId is a parameter which stores car id of all the cars.
	 * @param modelNumber is parameter which stores model number of all the cars.
	 * @param price is parameter which stores price of all the cars.
	 */
	
	Car(int carId,String modelNumber,Double price){
		this.carId=carId;
		this.modelNumber=modelNumber;
		this.price=price;
	}
	/**
	 * 
	 * @return carId is to get the car id in child classes.
	 */
	public int getCarId() {
		return carId;
	}
	/**
	 * 
	 * @return modelNumber is to get the model number in child classes.
	 */
	public String getModelNumber() {
		return modelNumber;
	}
	/**
	 * 
	 * @return price is to get the price of the cars in child classes.
	 */
	public Double getPrice() {
		return price;
	}
	/**
	 * 
	 * @return resalePrice is to get the resell value of the cars.
	 */
	
	
}
