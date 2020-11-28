package application;

/**
 * This class is one of the three selections in the sandwich builder class.
 * This class contains the basic ingredients as well as the base price for a chicken sandwich.
 * @author David Testa & Gabriel Marques-Zacarias
 */
public class Chicken extends Sandwich {
    
    /**
     * Constructor to pass through basic ingredients.
     */
    public Chicken() {

        add( Extra.FRIED_CHICKEN );
        add( Extra.SPICY_SAUCE );
        add( Extra.PICKLES );
    }

	/**
     * Price method which returns the price of a chicken sandwich.
     */
	@Override
	public double price() {

	    if ( extras.size() <= MagicNumbers.BASIC_INGREDIENTS ) {
	        
	        return MagicNumbers.CHICKEN_PRICE;
	        
	    }
	    
	    else {      
	        
	        return ( ( extras.size() - MagicNumbers.BASIC_INGREDIENTS ) * PER_EXTRA ) + MagicNumbers.CHICKEN_PRICE;
	        
	    }
 
	}
	
	/**
	 * ToString Method to output the human readable text to the order. 
	 */
	@Override
	public String toString() {
	    
		return "Chicken Sandwich: " + super.toString();
		
	}

}
