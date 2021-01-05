package pig.gui;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pig.model.Game;

/**
 * Date 18-Dec-2020
 * This is a controller class which is used for login.fxml 
 * It takes name of players, target score and the action ie
 *  if the user wants to start the game of view the score board
 * @author kshitija
 * @version 1.0
 *
 */
public class LoginController {

	/**
	 * Image view to show the image on UI
	 */
	@FXML 
	ImageView pigImage;
	/**
	 * Next button which opens the game on next screen
	 */
	@FXML
	Button nextButton;
	/**
	 * Radio button to select 50 as target score
	 */
	@FXML
	RadioButton radio50;
	/**
	 * Radio button to select 100 as target score 
	 */
	@FXML
	RadioButton radio100;
	/**
	 * Status label to show errors 
	 */
	@FXML
	Label l1;
	/**
	 * Player 1 can enter name in this field 
	 */
	@FXML
	TextField p1Name;
	/**
	 * Player 2 can enter name in this field 
	 */
	@FXML
	TextField p2Name;
	
	/**
	 * box 1 to set background color to display player 1's turn
	 */
	@FXML
	VBox p1Box;
	/**
	 * box 2 to set background color to display player 2's turn
	 */
	@FXML
	VBox p2Box;
	/**
	 * Button to take the players to score board screen
	 */
	@FXML
	Button scoreboardButton;
	
	/**
	 * sets image on UI from a location 
	 */
	public void setPigImage() {
		pigImage.setImage(new Image(getClass().getResource("/pig/resources/Pig1.png").toExternalForm()));
	}
	/**
	 * Initializes the first screen
	 */
	@FXML
	public void initialize() {
		setPigImage();
		l1.setVisible(false);
		System.out.println("test");
	}
	/** This method checks if the players have entered their name and target score. 
	 * Sets the status as the error in case they haven't entered any fields 
	 * Starts the game on next screen if all conditions are fulfilled by initializing a new game 
	 * @param event on click of Start Game button
	 */
	public void NextAction(ActionEvent event) {
		try{
			if(p1Name.getText().equals("")  ) {
				l1.setVisible(true);
				l1.setText("Enter Player name"); 
			} else if(p2Name.getText().equals("")  ) {
				l1.setVisible(true);
				l1.setText("Enter Player name");
			}else if(!radio100.isSelected() && !radio50.isSelected()) {
				l1.setVisible(true);
				l1.setText("Enter target score");
			}
			else {
			PigData.pig= new Game(p1Name.getText(), p2Name.getText());
			
			if(radio100.isSelected()) {
				PigData.pig.setTargetScore(100);
			} else {
				PigData.pig.setTargetScore(50);
			}
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
		      Parent root = FXMLLoader.load(getClass().getResource("/pig/gui/test.fxml"));
		      primaryStage.setScene(new Scene(root));
		      primaryStage.show();
		      root.requestFocus();			
		     ((Stage)pigImage.getScene().getWindow()).close();
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	/** This method open s a new screen which displays a score board 
	 * @param event click of score board button
	 * @throws IOException throws error if the source of fxml is not found
	 */
	public void scoreAction(ActionEvent event) throws IOException {
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
	      Parent root = FXMLLoader.load(getClass().getResource("/pig/gui/Score.fxml"));
	      primaryStage.setScene(new Scene(root));
	      primaryStage.show();
	      root.requestFocus();			
	}
	
}
