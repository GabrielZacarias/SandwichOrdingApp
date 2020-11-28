package application;

import java.util.ArrayList;

/**
 * This class in the superclass and contains the logic for building a sandwich. 
 * This class is vital as it connects the three individual sandwich selections and stores the objects in an array.
 * This class will be used on the main GUI for building your selected sandwich. 
 * @author David Testa & Gabriel Marques-Zacarias
 */
public abstract class Sandwich implements Customizable {
	static final int MAX_EXTRAS = 6;
	static final double PER_EXTRA = 1.99;
	protected ArrayList<Extra> extras;
	

	/**
	 * Public abstract method for price
	 */
	public abstract double price();
	
	/**
	 * Constructor generates new array list "extras".
	 */
    public Sandwich () {
        
        this.extras = new ArrayList<>();
    }

    /**
     * Method adds an instance of Extra to the array list.
     */
	@Override
	public boolean add( Object obj ) {
	    
	    if ( obj instanceof Extra ) {
	        
	        extras.add( ( Extra )obj );
	        
	        return true;
	    }
	    
		return false;
	}

	/**
	 * Method removes instance of Extra in the array list.
	 */
	@Override
	public boolean remove( Object obj ) {
	    
	    if ( extras.contains( obj instanceof Extra ))
	    {	        
	       
            if ( obj instanceof Extra && extras.contains( ( Extra )obj ) ) {	        
            
                extras.remove( ( Extra )obj );
                
                return true;
            }
	    }
	    
		return false;
	}
	
	/**
	 * ToString Method to output the human readable text to the order. 
	 */
    @Override
    public String toString() {
    	
    	String extra = "";
    	
    	for(int i = 0; i < extras.size(); i++)
    		extra += extras.get(i) + ", ";
    	
    	if(extras.size() > MagicNumbers.BASIC_INGREDIENTS)
    		extra = extra.substring(0, MagicNumbers.EXTRA_INGREDS) + "\n   Extras: " + extra.substring(MagicNumbers.EXTRA_INGREDS, extra.length() - MagicNumbers.ENDING_COMMA) + "\n   Cost: $";
    	
    	else
    		extra = extra + "\n   Cost: $";
    	
        return extra; 
    }
}
