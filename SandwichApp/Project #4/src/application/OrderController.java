package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * This class is used to perform the actions on the second GUI.
 * This class is vital as it will be able to connect the code in Order and perform the actions to the user.
 * @author David Testa & Gabriel Marques-Zacarias
 */
public class OrderController {

    @FXML
    private Button backButton, clearOrderButton, exportButton;
    
    @FXML
    private TextField totalPrice;
    
    @FXML
    private ListView<OrderLine> summaryText;
    
    
	private MainController controller;
    
    public void init(ObservableList<OrderLine> tempList) {
    	summaryText.getItems().clear();
    	
    	String priceFormat = String.format("$%.2f", getTotal());
    	
    	summaryText.getItems().addAll(tempList);
    	totalPrice.setText(priceFormat);
    }
    
    /**
     * This method is used to get the total. 
     * @return total
     */
    public double getTotal() {
    	
    	double total = 0;
    	
    	for(int i = 0; i < controller.tempList.size(); i++)
    		total += controller.tempList.get(i).getPrice();
    	
    	return total;
    }

    /**
     * This method is used to close the second GUI screen on button press.
     * @param event 
     */
    @FXML
    void closeScreen(ActionEvent event) {
    	Stage stage = (Stage) backButton.getScene().getWindow();
    	stage.close();
    }
    
    /**
     * This method is used to duplicate the item selected in the order.
     */
    @FXML
    void duplicateItem() {
    	
    	try {
    		OrderLine itemSelected = summaryText.getSelectionModel().getSelectedItem();

    		int newLine = controller.tempList.size();

    		Sandwich newSandwich = itemSelected.getSandwich();

    		double sandwichPrice = itemSelected.getPrice();

    		OrderLine newOrder = new OrderLine(++newLine, newSandwich, sandwichPrice);

    		controller.tempList.add(newOrder);
    		
    		Order.lineNumber = newLine;
    		
    	} catch(NullPointerException e) {
    		
    	}finally {
    		summaryText.getItems().clear();
    		init(controller.tempList);
    	}
    }

    /**
     * This method is used to remove a selected order from the total order list.
     */
    @FXML
    void removeOrder() {

      OrderLine index = summaryText.getSelectionModel().getSelectedItem();
      
      controller.tempList.remove(index);
      
      int mainLine = 0;
            
      for(int i = 0; i < controller.tempList.size(); i++)
      {

    	  int newLine = i + MagicNumbers.INCREMENT;
    	  
    	  OrderLine temp = controller.tempList.get(i);

    	  Sandwich newSandwich = temp.getSandwich();

    	  double sandwichPrice = temp.getPrice();

    	  OrderLine newOrder = new OrderLine(newLine, newSandwich, sandwichPrice);
    	  
    	  controller.tempList.set(i, newOrder);
    	  
    	  mainLine = newLine;

      }
      
      Order.lineNumber = mainLine;
      summaryText.getItems().clear();
      init(controller.tempList);

    }
    
    /**
     * This method is used to clear the entire order and empty the orderlines array.
     */
    @FXML
    void clearOrder() {
    	
    	summaryText.getItems().clear();
    	
    	controller.tempList.clear();
    	Order.lineNumber = 0;
    	
    	totalPrice.setText("$0.00");
    }

	public void MainController(MainController control) {
		this.controller = control;
	}
	
	/**
	 * This method is used to export the final order to a .txt file via file explorer. 
	 * @param event
	 */
	@FXML
	void exportFile (ActionEvent event) {
		FileChooser chooser = new FileChooser();
		chooser.setTitle("Save Order to File.");
		chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"), new FileChooser.ExtensionFilter("All Files", "*"));
		Stage saveStage = new Stage();
		File targetFile = chooser.showSaveDialog(saveStage);
		
		FileWriter fileStream = null;
		
		try {
			
			fileStream = new FileWriter(targetFile);
			Writer output = new BufferedWriter(fileStream);
			
			int size = controller.tempList.size();
			
			for(int i = 0; i < size; i++) {
				output.write(controller.tempList.get(i).toString() + "\n");
			}
			
			output.close();
			
		}catch(IOException ioe) {
			return;
		}
		catch (NullPointerException e) {
			return;
		}
	}

}
