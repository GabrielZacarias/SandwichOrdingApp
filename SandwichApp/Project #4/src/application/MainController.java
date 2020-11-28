package application;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * This is our main controller class.
 * This class is vital as it connects the back-end code with the front end actions.
 * This class will allow the actions performed in the GUI to interface with the code written.
 * @author David Testa & Gabriel Marques-Zacarias
 */
public class MainController implements Initializable {
    

	@FXML
	public ComboBox<String> combobox;

	@FXML
	private ImageView imageViewer;

	@FXML
	private ListView<Extra> IncludedList, IngredientsList, extraIngredientsList;

	@FXML
	private Button addButton, removeButton, clearButton, addOrderButton, showOrderButton, exportButton;

	@FXML
	private TextField sandwichPrice;

	ObservableList<String> list = FXCollections.observableArrayList("Chicken", "Beef", "Fish");
	ObservableList<Extra> include = FXCollections.observableArrayList();
	ObservableList<Extra> ingredients = FXCollections.observableArrayList(Extra.LETTUCE, Extra.TOMATOES, Extra.ONIONS, Extra.BACON, Extra.HAM, Extra.AVOCADO, Extra.SPINACH, Extra.MUSHROOMS, Extra.BASIL, Extra.SWEET_PEPPERS);

    Sandwich chickenSandwich = new Chicken();
    Sandwich beefSandwich = new Beef();
    Sandwich fishSandwich = new Fish();    
    OrderLine orderLine = null;
    OrderController control;

    /**
     * This method initializes the combobox for human readable text.
     */
	@Override
	public void initialize(URL location, ResourceBundle resources) {  	
		combobox.setValue("Chicken");
		combobox.setItems(list);
		IngredientsList.getItems().addAll(ingredients);
		comboChanged(null);
	}

	/**
	 * This method is used to display the basic ingredients for each sandwich.
	 * @param event
	 */
	@FXML
	void comboChanged (ActionEvent event) {
		Image image = null;	
		Extra ingred1 = null;
		Extra ingred2 = null;
		Extra ingred3 = null;
		
		String cost = "";

		extraIngredientsList.getItems().removeAll(ingredients);
		IngredientsList.getItems().setAll(ingredients);
		chickenSandwich = new Chicken();
		beefSandwich = new Beef();
		fishSandwich = new Fish();

		if (combobox.getValue().equals( "Chicken" )) 
		{    	   
			image = new Image("/chicken.jpg");		
			ingred1 = Extra.FRIED_CHICKEN;
			ingred2 = Extra.SPICY_SAUCE;
			ingred3 = Extra.PICKLES;
			cost = String.valueOf(chickenSandwich.price());
		}

		else if(combobox.getValue().equals("Beef")) 
		{    	    
			image = new Image("/beef.jpg");
			ingred1 = Extra.BEEF_PATTY;
			ingred2 = Extra.PROVOLONE_CHEESE;
			ingred3 = Extra.MUSTARD;
			cost = String.valueOf(beefSandwich.price());
		}
		else if(combobox.getValue().equals("Fish"))
		{
			image = new Image("/fish.jpg");
			ingred1 = Extra.FRIED_FISH;
			ingred2 = Extra.CILANTRO;
			ingred3 = Extra.SPECIAL;
			cost = String.valueOf(fishSandwich.price());
		}

		sandwichPrice.setText("$" + cost);
		imageViewer.setImage(image);
		include.setAll(ingred1, ingred2, ingred3);
		IncludedList.getItems().setAll(include);
		IncludedList.setDisable(true);
	}

	/**
	 * This method is used to add an ingredient to the order.
	 * @param event
	 */
	@FXML
	void addIngredient(ActionEvent event) {

		Extra item = IngredientsList.getSelectionModel().getSelectedItem();

		String cost = "";

		if(item != null && extraIngredientsList.getItems().size() != Sandwich.MAX_EXTRAS) 
		{
			IngredientsList.getItems().remove(item);
			extraIngredientsList.getItems().add(item);

			if(combobox.getValue().equals("Chicken"))
			{
				chickenSandwich.extras.add(item);
				cost = String.valueOf(String.format("%.2f", chickenSandwich.price()));
			}

			else if(combobox.getValue().equals("Beef"))
			{
				beefSandwich.extras.add(item);
				cost = String.valueOf(String.format("%.2f", beefSandwich.price()));
			}

			else if(combobox.getValue().equals("Fish"))
			{
				fishSandwich.extras.add(item);
				cost = String.valueOf(String.format("%.2f", fishSandwich.price()));
			}

			sandwichPrice.setText("$" + cost);
		}
		
		else if (extraIngredientsList.getItems().size() == Sandwich.MAX_EXTRAS)
		{
			Alert warns = new Alert(Alert.AlertType.INFORMATION);
			warns.setTitle("Maximum Extras!");
			warns.setHeaderText("Toppings Capacity Reached!");
			warns.setContentText("You cannot have more than 6 extras on a sandwich.");
			warns.showAndWait();
		}

	}

	/**
	 * This method is used to remove an ingredient from the order. 
	 * @param event
	 */
	@FXML
	void removeIngredient(ActionEvent event) {
		Extra item = extraIngredientsList.getSelectionModel().getSelectedItem();
		String cost = "";

		if(item != null) 
		{
			extraIngredientsList.getItems().remove(item);
			IngredientsList.getItems().add(item);

			if(combobox.getValue().equals("Chicken"))
			{
				chickenSandwich.extras.remove(item);

				cost = String.valueOf(String.format("%.2f", chickenSandwich.price()));
			}

			else if(combobox.getValue().equals("Beef"))
			{
				beefSandwich.extras.remove(item);

				cost = String.valueOf(String.format("%.2f", beefSandwich.price()));
			}

			else if(combobox.getValue().equals("Fish"))
			{
				fishSandwich.extras.remove(item);

				cost = String.valueOf(String.format("%.2f", fishSandwich.price()));
			}

			sandwichPrice.setText("$" + cost);
		}
	}

	/**
	 * This method is used to clear all choices from the order.
	 * @param event
	 */
	@FXML
	void clearChoice( ActionEvent event ) {
		extraIngredientsList.getItems().removeAll(ingredients);
		IngredientsList.getItems().setAll(ingredients);
		chickenSandwich = new Chicken();
		beefSandwich = new Beef();
		fishSandwich = new Fish();

		combobox.setValue("Chicken");
		combobox.setItems(list);

		comboChanged(null);
	}


	ObservableList<OrderLine> tempList =  FXCollections.observableArrayList();
	
	/**
	 * This method is used to add the sandwich built to the order.
	 * @param event
	 */
	@FXML
	void addToOrder ( ActionEvent event ) {
		
		double price = 0;
		

		
		try {
			
			if(combobox.getValue().equals("Chicken"))
			{
				orderLine = new OrderLine( ++Order.lineNumber, chickenSandwich, chickenSandwich.price());
				price = chickenSandwich.price();
			}
			
			else if(combobox.getValue().equals("Beef"))
			{
				orderLine = new OrderLine( ++Order.lineNumber, beefSandwich, beefSandwich.price());
				price = beefSandwich.price();
			}
			
			else if(combobox.getValue().equals("Fish"))
			{
				orderLine = new OrderLine( ++Order.lineNumber, fishSandwich, fishSandwich.price());
				price = fishSandwich.price();
			}
		    
		    orderLine.setPrice(price);
		    
		    tempList.add(orderLine);
			
			update();	    
		    
			} catch(Exception e) {
				return;
			}finally {	
				clearChoice(null);
			}
	}

	/**
	 * This method is used to open the second GUI to view the order.
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void openOrderSummary(ActionEvent event) throws IOException {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/OrderSummary.fxml"));
			Parent root = loader.load();	
			OrderController secController = loader.getController();
			Stage secStage = new Stage();
			secStage.setScene(new Scene(root, 600, 410));
			secStage.setResizable( false );
			secStage.setTitle("Order Summary");
			
			showOrderButton.setDisable(true);
			setScreen(secController);
			secStage.showAndWait();
			showOrderButton.setDisable(false);
			
		} catch (Exception e) {
			return;
		}
	}
	
	/**
	 * This method will set the second gui controller and initialize it
	 * @param secController
	 */
	void setScreen(OrderController secController) {
		control = secController;
		control.MainController(this);
		control.init(tempList);
	}
	
	
	/**
	 * This method will be used to auto update the gui when both screens are open
	 */
	void update() {
		control.MainController(this);
		control.init(tempList);
	}
}
