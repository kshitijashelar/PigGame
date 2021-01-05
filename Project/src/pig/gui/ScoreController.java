package pig.gui;

/**
 * @author kshit
 *
 */
import java.io.File;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class ScoreController {

	/**
	 * text area displaying the scores of all the winners from text file
	 */
	@FXML
	TextArea scoreList;

	/**
	 * initializes score board screen but setting the background color and read the file contents and putting it in the text area 
	 */
	@FXML
	public void initialize() {
		scoreList.setBackground(new Background(new BackgroundFill(Color.LIGHTPINK, null, null)));
		try {
			int lineCount=0;
			Scanner in = new Scanner(new File("score.txt"));
			while(in.hasNextLine()) {
				scoreList.setText(lineCount==0 ? in.nextLine() : scoreList.getText()+"\n"+in.nextLine());
				lineCount++;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
