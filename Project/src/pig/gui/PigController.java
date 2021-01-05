package pig.gui;

/**
 * @author kshit
 *
 */
import java.io.FileWriter;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PigController {
	/**
	 * image view for die1
	 */
	@FXML
	ImageView dieImage;
	/**
	 * image view for die 2
	 */
	@FXML
	ImageView die2Image;
	/**
	 * button to hold the score 
	 */
	@FXML
	Button holdButton;
	/**
	 * button to roll the die
	 */
	@FXML
	Button rollButton;
	/**
	 * for player 1 turn score 
	 */
	@FXML
	TextField player1Turn;
	/**
	 * for player 2 turn score 
	 */
	@FXML
	TextField player2Turn;
	/**
	 * for player 1 total score 
	 */
	@FXML
	TextField player1Total;
	/**
	 * for player 1 total score 
	 */
	@FXML
	TextField player2Total;

	/**
	 * box for player 1
	 */
	@FXML
	VBox p1Box;
	/**
	 * box for player 2
	 */
	@FXML
	VBox p2Box;
	/**
	 * status label to display messages 
	 */
	@FXML
	Label statusLbl;
	/**
	 * Label displaying player 1 name
	 */
	@FXML
	Label pl1Name;
	/**
	 * Label displaying player 2 name
	 */
	@FXML
	Label pl2Name;

	/**
	 * initializes 2nd screen i.e the game screen
	 */
	@FXML
	public void initialize() {
		System.out.println("test");
		statusLbl.setVisible(false);
		updateViewOnUI();
	}

	
	/** This method is used to set die 1 image on screen
	 * @param top sets the die with top as parameter
	 */
	public void setDieImage(int top) {
		dieImage.setImage(new Image(getClass().getResource("/pig/resources/Dice" + top + ".png").toExternalForm()));
	}
	
	/** This method is used to set die 2 image on screen
	 * @param top sets the die with top as parameter
	 */
	public void setDie2Image(int top) {
		if(top==0)
			die2Image.setImage(new Image(getClass().getResource("/pig/resources/Dice1" + top + ".png").toExternalForm()));
		die2Image.setImage(new Image(getClass().getResource("/pig/resources/Dice" + top + ".png").toExternalForm()));
	}
	
	/**
	 * this method rolls the die and updates the view on UI
	 */
	public void roll() {
		PigData.pig.rollDie();
		updateViewOnUI();
	}
	/**
	 * this method holds the die and updates the view on UI
	 */
	public void hold() {
		PigData.pig.holdDie();
		updateViewOnUI();
	}

	/**
	 * sets the turn score for player 1 and player 2
	 * sets the total score for player 1 and player 2
	 * checks for player turns and sets the background accordingly 
	 * if the game is over then opens the score board to show the name of players won 
	 */
	public void updateViewOnUI() {

		pl1Name.setText((PigData.pig.getPlayer1().getName()));
		pl2Name.setText((PigData.pig.getPlayer2().getName()));

		setDieImage(PigData.pig.getDie1().getTop());
		setDie2Image(PigData.pig.getDie2().getTop());


		player1Turn.setText(PigData.pig.getPlayer1().getTurnScore() + "");
		player2Turn.setText(PigData.pig.getPlayer2().getTurnScore() + "");

		player1Total.setText(PigData.pig.getPlayer1().getTotalScore() + "");
		player2Total.setText(PigData.pig.getPlayer2().getTotalScore() + "");
		if (PigData.pig.isP1Turn()) {
			p1Box.setBackground(new Background(new BackgroundFill(Color.LIGHTPINK, null, null)));
			p2Box.setBackground(null);
		} else {
			p2Box.setBackground(new Background(new BackgroundFill(Color.LIGHTPINK, null, null)));
			p1Box.setBackground(null);
		}

		if (PigData.pig.gameOver()) {
			saveDataInFile();
			holdButton.setDisable(true);
			rollButton.setDisable(true);
			statusLbl.setText("Game over! " + PigData.pig.getCurrent().getName() + " Won!");
			statusLbl.setVisible(true);
			dieImage.setImage(new Image(getClass().getResource("/pig/resources/Dice7.png").toExternalForm()));
		
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
		    Parent root = null;
			try {
				root = FXMLLoader.load(getClass().getResource("/pig/gui/Score.fxml"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      primaryStage.setScene(new Scene(root));
		      primaryStage.show();
		      root.requestFocus();
		      }
					
	
	}

	/**
	 * this method appends winner details in a text file
	 */
	public void saveDataInFile() {

		FileWriter myWriter;
		try {
			myWriter = new FileWriter("score.txt",true);
			myWriter.write("\n"+PigData.pig.getCurrent().getName() + " : " + PigData.pig.getTargetScore());
			myWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
