package application;

import java.util.ArrayList;

/**
 * This class is used to contain the logic for the order GUI.
 * This class will be able to store the sandwich built in an array and add or remove an order.
 * @author David Testa & Gabriel Marques-Zacarias
 */
public class Order implements Customizable{
	public static int lineNumber; //reset for each new order;
	private ArrayList<OrderLine> orderlines;

	/**
	 * Constructor used to pass through the array. 
	 * initiate the lineNumber to zero. 
	 */
    public Order () {
        this.orderlines = new ArrayList<>();
        lineNumber = 0; 
    }

    /**
     * This method is used to add an order to the array orderlines. 
     */
    @Override
    public boolean add( Object obj ) {
    	
        if ( obj instanceof OrderLine ) 
        { 
            orderlines.add( ( OrderLine )obj );
            return true;
        }
        
        return false;
    }
	
    /**
     * This method is used to remove an order from the array orderlines. 
     */
	@Override
	public boolean remove( Object obj ) {
		
		if( obj instanceof OrderLine )
		{
			orderlines.remove( ( OrderLine ) obj );
		
			return true;
		}
		
		return false;
	}
	
}
