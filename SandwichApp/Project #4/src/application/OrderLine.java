package application;

/**
 * This class is used to interface with the Order class.
 * This class is vital as it helps set up the order array.
 * @author David Testa & Gabriel Marques-Zacarias
 *
 */
public class OrderLine {
	private int lineNumber; //a serial number created when a sandwich is added to the order
	private Sandwich sandwich;
	private double price;
	

	/**
	 * Constructor needed to initiate and setup params for;
	 * @param lineNumber
	 * @param sandwich
	 * @param price
	 */
	public OrderLine( int lineNumber, Sandwich sandwich, double price ) {
		this.lineNumber = lineNumber;
		this.sandwich = sandwich;
		this.price = price;
	}

	/**
	 * ToString Method to output the human readable text to the order.
	 */
	@Override 
	public String toString() {

        return lineNumber + " " + sandwich.toString() + String.format( "%.2f", price );

    }
	
	/**
	 * Method used to set the price.
	 * @param price
	 * @return price
	 */
	public double setPrice( double price ) {
		
		this.price = price;
		
		return this.price;
	}
	
	/**
	 * Getter method used to get the price.
	 * @return price
	 */
	public double getPrice() {
		return this.price;
	}
	
	/**
	 * Getter method used to get the line number.
	 * @return lineNumber
	 */
	public int getLine() {
		return lineNumber;
	}
	
	/**
	 * Method used to set the line number. 
	 * @param line
	 * @return lineNumber
	 */
	public int setLine(int line) {
		Order.lineNumber = line;
		return lineNumber;
	}

	/**
	 * Method used to return the sandwich object. 
	 * @return sandwich
	 */
	public Sandwich getSandwich() {
		return sandwich;
	}

}
