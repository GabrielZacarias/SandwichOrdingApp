package application;

/**
 * This class is one of the three selections in the sandwich builder class.
 * This class contains the basic ingredients as well as the base price for a fish sandwich.
 * @author David Testa & Gabriel Marques-Zacarias
 */
public class Fish extends Sandwich{
    
    /**
     * Constructor to pass through basic ingredients.
     */
    public Fish() {
        
        add( Extra.FRIED_FISH );
        add( Extra.CILANTRO );
        add( Extra.SPECIAL );
    }

    /**
     * Price method which returns the price of a fish sandwich.
     */
    @Override
    public double price() {

        if ( extras.size() <= MagicNumbers.BASIC_INGREDIENTS ) {
            
            return MagicNumbers.FISH_PRICE;
        
        }
        
        else {
            
            return ( ( extras.size() - MagicNumbers.BASIC_INGREDIENTS ) * PER_EXTRA ) + MagicNumbers.FISH_PRICE;
            
        }
 
    }
    
    /**
     * ToString Method to output the human readable text to the order. 
     */
    @Override
    public String toString() {

        return "Fish Sandwich: " + super.toString();
        
    }

}
