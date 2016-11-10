package controllers;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

/**
 * @author Luis Alvarez
 * @since 10/27/2016
 * @version 1.0
 *
 */
public class RegisterController implements Initializable {


	@FXML private TextField firstNameField;
	@FXML private TextField idField;
	@FXML private TextField lastNameField;
	@FXML private TextField incomeField;

	@FXML private Button registerButton;
	@FXML private Button cancelButton;
	ObservableList<String> educationList = FXCollections.observableArrayList("Junior High", "HighSchool", "Profesional");
	ObservableList<String> ages = FXCollections.observableArrayList("18","19","20","21","22","23","24","25","26","27","28","29","30");



	@FXML private ChoiceBox educationField;

	@FXML private ChoiceBox ageField;



	private ObjectInputStream loadFile;
	private ObjectOutputStream saveFile;
	private String fileLocation = System.getProperty("user.dir")+ "/table.dat";
	@FXML private Label statusLabel;

	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		educationField.setValue("Preschool");
		ageField.setValue("17");
		educationField.setItems(educationList);
		ageField.setItems(ages);
		try{
			loadFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileLocation)));
			try{
				Main.names = (List<String[]>) loadFile.readObject();
				loadFile.close();
		}catch(ClassNotFoundException e)
			{

			}
		}catch(FileNotFoundException e)
			{

			}catch(IOException e)
			{

			}

	}
	/**
	 * @param e
	 */
	@FXML
	public void registerButtonPressed(ActionEvent e)
	{

		if(firstNameField.getText().isEmpty() && idField.getText().isEmpty() && incomeField.getText().isEmpty() && lastNameField.getText().isEmpty())
		{
			statusLabel.setText("Please input: Name, Id, LastName and Income!");

		}else if(firstNameField.getText().isEmpty()){
			statusLabel.setText("Please input a Name!");
		}else if( idField.getText().isEmpty()){
			statusLabel.setText("Please input an ID!");
		}else if(lastNameField.getText().isEmpty()){
			statusLabel.setText("Please input a Last Name");
		}else if(incomeField.getText().isEmpty()){
			statusLabel.setText("Please input an Income");
		}
		else{
			application.Main.mainStage.setScene(application.Main.scene2);
			String[]aName = {firstNameField.getText(),lastNameField.getText(), idField.getText()
					,incomeField.getText(),""+ educationField.getValue(),""+ageField.getValue()};
			Main.names.add(aName);

			try{
				saveFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileLocation)));
				saveFile.writeObject(Main.names);
				saveFile.flush();
				saveFile.close();
			}catch(FileNotFoundException ep){
				statusLabel.setText("No name or ID");
				statusLabel.setTextFill(Color.web("red"));
			}catch(IOException ep){
				statusLabel.setText("IO ERROR");
				statusLabel.setTextFill(Color.web("red"));
			}


		}
		//Clean Everything
		firstNameField.clear();
		idField.clear();
		lastNameField.clear();
		incomeField.clear();


	}
	/**
	 * @param e
	 */
	@FXML
	public void cancelButtonPressed(ActionEvent e)
	{
		application.Main.mainStage.setScene(application.Main.scene2);
	}

}
