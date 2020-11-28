package application;

/**
 * This class is one of the three selections in the sandwich builder class.
 * This class contains the basic ingredients as well as the base price for a beef sandwich.
 * @author David Testa & Gabriel Marques-Zacarias
 */
public class Beef extends Sandwich {

    /**
     * Constructor to pass through basic ingredients.
     */
    public Beef() {

        add( Extra.BEEF_PATTY );
        add( Extra.PROVOLONE_CHEESE );
        add( Extra.MUSTARD );
    }

    /**
     * Price method which returns the price of a beef sandwich.
     */
    @Override
    public double price() {

        if ( extras.size() <= MagicNumbers.BASIC_INGREDIENTS ) {
            
            return MagicNumbers.BEEF_PRICE;
        
        }
        
        else {
            
            return ( ( extras.size() - MagicNumbers.BASIC_INGREDIENTS ) * PER_EXTRA ) + MagicNumbers.BEEF_PRICE;
            
        }

    }
    
    /**
     * ToString Method to output the human readable text to the order. 
     */   
    @Override
    public String toString() {
        
    	 return "Beef Sandwich: " + super.toString();

    }
}
