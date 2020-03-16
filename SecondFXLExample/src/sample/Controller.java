package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Random;

public class Controller
{

	@FXML
	private TextField insertedNumberTextField;
	@FXML
	private Label successMsgLabel;
	@FXML
	private Label successNumbLabel;
	@FXML
	private Label warningMsgLabel;
	@FXML
	private Label warningNumbLabel;

	public void guessLuckyNumber(ActionEvent actionEvent)
	{
		cleanUp();

		Random random = new Random();
		int numb = random.nextInt(10) + 1;

		try
		{
			int guessNumb = Integer.parseInt(insertedNumberTextField.getText());

			if(numb == guessNumb)
			{
				successMsgLabel.setText("You a lucky today :)");
				successNumbLabel.setText(String.valueOf(numb));
			}
			else
			{
				warningMsgLabel.setText("Dam try again");
				warningNumbLabel.setText(String.valueOf(numb));
			}
		}
		catch(NumberFormatException e)
		{
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setContentText("This is not a number, please try again");
			alert.show();
		}
		insertedNumberTextField.setText("");
	}

	private void cleanUp()
	{
		successNumbLabel.setText("");
		successMsgLabel.setText("");
		warningMsgLabel.setText("");
		warningNumbLabel.setText("");
	}

}
