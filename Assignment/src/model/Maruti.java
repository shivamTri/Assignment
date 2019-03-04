package model;
public class Maruti extends Car{
	private Double resalePrice;

	/**
	 * 
	 * @param carId is parameter of integer type which stores car id.
	 * @param modelNumber is parameter of String type which stores modelNumber of the car.
	 * @param price is parameter of double type which stores price of the car.
	 */
	Maruti(int carId, String modelNumber, double price) {
		super(carId, modelNumber, price);
		
	}
	/**
	 * @return resalePrice of type double which stores the calculated resale value of the car's price.
	 */
	@Override
	public double resaleValue() {
		
		resalePrice=0.6*getPrice();
		return resalePrice;
		
	}
	/**
	 * this method is to print the details of the maruti cars.
	 */

	@Override
	public void printCarDetails() {
		System.out.println("\ncar details are"
				+ "\n\nCar name is Maruti"
				+ "\n\ncar Id="+getCarId()+""
						+ "\n\ncar model number="+getModelNumber()+""
								+ "\n\ncar price="+getPrice()+""
										+ "\n\ncare resale value="+resaleValue()); 
		
	}

	


}
