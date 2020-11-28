package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

/**
 * This is out main class wich will run the program.
 * This class is vital as it will call the FXML GUI and display the interface to the user. 
 * @author David Testa & Gabriel Marques-Zacarias
 */
public class Main extends Application {

	@Override
	public void start( Stage primaryStage ) {
		try {
            Parent root = FXMLLoader.load( getClass().getResource( "/application/SandwichStore.fxml" ) );
			Scene scene = new Scene(root, 609, 540);
			scene.getStylesheets().add(getClass().getResource( "application.css" ).toExternalForm() );
			primaryStage.setTitle( "My Sandwich Store" );
            primaryStage.setResizable( false );
			primaryStage.setScene( scene );
	
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch( args );
	}
}
