package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * This class is used to perform unit testing on the Order class.
 * This is required to ensure the Order methods add and remove are functioning properly. 
 * @author David Testa & Gabriel Marques-Zacarias
 *
 */
class OrderTest {
    
    Order testOrder = new Order();
    OrderLine orderLine;
    
    Sandwich chickenTest = new Chicken();
    Sandwich fishTest = new Fish();
    Sandwich beefTest = new Beef();

    /**
     * Method used to test the add functionality in the Order class.
     */
    @Test
    void addTest() {
        
        //Testing add for chickenTest and if line Number is equal
    	Order.lineNumber = 1;
        orderLine = new OrderLine(Order.lineNumber, chickenTest, 8.99);
        assertTrue(testOrder.add(orderLine));
        
        assertEquals(1, Order.lineNumber);
        
        
        //Testing add for beefTest and if line Number equals
        Order.lineNumber++;
        orderLine = new OrderLine(Order.lineNumber, beefTest, 10.99);
        assertTrue(testOrder.add(orderLine));
        
        assertEquals(2, Order.lineNumber);
        
        //Testing add for fishTest and if line Number equals
        Order.lineNumber++;
        orderLine = new OrderLine(Order.lineNumber, fishTest, 12.99);
        assertTrue(testOrder.add(orderLine));
        
        assertEquals(3, Order.lineNumber);
      
    }
    
    /**
     * Method used to test the remove functionality in the Order class.
     */
    @Test
    void removeTest() {

        //Testing remove for chickenTest and if it equals
    	Order.lineNumber = 3;
        orderLine = new OrderLine(Order.lineNumber, chickenTest, 8.99);
        testOrder.add(orderLine);
        assertTrue(testOrder.remove(orderLine));
        
        assertEquals(3, Order.lineNumber);
        
        //Testing remove for beefTest and if line number equals
        Order.lineNumber--;
        orderLine = new OrderLine(Order.lineNumber, beefTest, 10.99);
        testOrder.add(orderLine);
        assertTrue(testOrder.remove(orderLine));
        
        assertEquals(2, Order.lineNumber);       

        //Testing remove for fishTest and if it equals of base fish sandwich
        Order.lineNumber--;
        orderLine = new OrderLine(Order.lineNumber, fishTest, 12.99);
        testOrder.add(orderLine);
        assertTrue(testOrder.remove(orderLine));
        
        assertEquals(1, Order.lineNumber);
    }
}