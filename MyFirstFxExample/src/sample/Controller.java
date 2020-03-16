package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller
{

/*	@FXML
	private Label myDummyLabel;
	@FXML
	private TextField inputTextField;

	public void changeLabelText(ActionEvent event)
	{
		String input = inputTextField.getText();
		if(input != null && input.length() > 0)
		{
			myDummyLabel.setText(input);
			inputTextField.setText("");
		}
		else
		{
			myDummyLabel.setText("This label changed!!! :)");
		}
	}*/

	@FXML
	private Label emptyLabel;
	@FXML
	private TextField nameTextField;
	@FXML
	private TextField lastnameTextField;

	public void sayHello(ActionEvent event) {
		String name = nameTextField.getText();
		String lastName = lastnameTextField.getText();
		if(isNotBlank(name) && isNotBlank(lastName)) {
			emptyLabel.setText(String.format("Hello %s %s", name, lastName));
			nameTextField.setText("");
			lastnameTextField.setText("");
		}
	}

	private boolean isNotBlank(String value) {
		return value != null && value.length() > 0;
	}
}
