package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Controller
{
	@FXML
	private TextField ltTextField;
	@FXML
	private TextField enTextField;

	Map<String, String> translations = new HashMap<>();

	public void translate(ActionEvent event)
	{
		if(translations.isEmpty())
		{
			readTranslations();
		}

		if(ltTextField.getText().length() > 0)
		{
			Map.Entry<String, String> lt = translations.entrySet()
					.stream()
					.filter(v -> v.getValue().equals(ltTextField.getText()))
					.findFirst()
					.orElse(null);

			if(lt != null){
				enTextField.setText(lt.getKey());
			}else {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setContentText("Nera anglisko vertimo");
				alert.show();
			}
		}
		else if(enTextField.getText().length() > 0)
		{
			String en = translations.get(enTextField.getText());
			if(en != null)
			{
				ltTextField.setText(en);
			}
		}
	}

	private void readTranslations()
	{
		try(BufferedReader bf = new BufferedReader(new FileReader("translations.txt")))
		{
			String line;
			while((line = bf.readLine()) != null)
			{
				String[] split = line.split("-");
				if(split.length == 2)
				{
					translations.put(split[0], split[1]);
				}
			}
		}
		catch(IOException e)
		{
			//TODO show alert
		}
	}

}
