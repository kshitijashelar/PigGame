package pig.gui;

/**
 * Date 18-Dec-2020 
 * This is the main controller which starts the application and launches the first screen
 * @author kshitija
 * @version 1.0
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PigApp extends Application {
	/**
	 * Starts the first stage
	 */
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			Parent root = FXMLLoader.load(getClass().getResource("/pig/gui/Login.fxml"));
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
			root.requestFocus();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}