package application;

/**
 * This class is used to hold all of the enum values for basic and extra ingredients.
 * @author David Testa & Gabriel Marques-Zacarias
 */
public enum Extra {

	//Chicken Basic Ingredients 
	FRIED_CHICKEN, SPICY_SAUCE, PICKLES,
	

	//Beef Basic Ingredients 
	BEEF_PATTY, PROVOLONE_CHEESE, MUSTARD,
	

	//Fish Basic Ingredients 
	FRIED_FISH, CILANTRO, SPECIAL,
	
	//Extras
	LETTUCE, TOMATOES, BACON, MUSHROOMS, AVOCADO, SPINACH, HAM, BASIL, SWEET_PEPPERS, ONIONS;

	/**
	 * ToString Method to output the human readable text to the order.  
	 */
	//TODO should these be override?
	@Override
	public String toString() {
		
		switch(this) {
		
			case FRIED_CHICKEN:
				return "Fried Chicken ";
			
			case SPICY_SAUCE:
				return "Spicy Sauce ";
				
			case PICKLES:
				return "Pickles";
				
			case BEEF_PATTY:
				return "Beef Patty";
				
			case PROVOLONE_CHEESE:
				return "Provolone Cheese";
				
			case MUSTARD:
				return "Mustard";
				
			case FRIED_FISH:
				return "Fried Fish ";
				
			case CILANTRO:
				return "Cilantro";
			
			case SPECIAL:
				return "Special Sauce ";
				
			case LETTUCE:
				return "Lettuce";
				
			case TOMATOES:
				return "Tomatoes";
				
			case BACON:
				return "Bacon";
				
			case MUSHROOMS:
				return "Mushrooms";
				
			case AVOCADO:
				return "Avocado";
				
			case SPINACH:
				return "Spinach";
				
			case HAM:
				return "Ham";
				
			case BASIL:
				return "Basil";
				
			case SWEET_PEPPERS:
				return "Sweet Peppers";
				
			case ONIONS:
				return "Onions";
				
			default:
				return null;
		}
	}

}

