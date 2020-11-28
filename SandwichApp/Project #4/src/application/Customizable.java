package application;

/**
 * This class is used as a blueprint for the classes that extend the Customizable class.
 * This class sets up the need for the two methods add and remove.
 * @author David Testa & Gabriel Marques-Zacarias
 */
public interface Customizable {
	boolean add( Object obj );
	boolean remove( Object obj );
}
