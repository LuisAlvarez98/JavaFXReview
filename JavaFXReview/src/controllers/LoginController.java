package controllers;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * LoginController
 *
 * Is in charge of the LoginGUI Actions
 *
 * @author Luis Alvarez
 * @since 10/27/2016
 * @version 1.0
 *
 */
public class LoginController implements Initializable {

	@FXML private TextField firstNameField;
	@FXML private TextField idField;
	@FXML private RadioButton showPassword;
	@FXML private Button submitButton;
	@FXML private Button logout;
	@FXML private Label statusLabel;



	private ObjectInputStream loadFile;
	private String fileLocation = System.getProperty("user.dir")+ "/table.dat";


	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		// TODO Auto-generated method stub

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
	 * submitButtonPressed
	 * in charge of validating the user and id
	 * @param e
	 */
	public void submitButtonPressed(ActionEvent e)
	{
		try
		{
			loadFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileLocation)));
			Main.names = (List<String[]>) loadFile.readObject();
			for(int i = 0; i  < Main.names.size();i++)
			{
			if(firstNameField.getText().isEmpty() && idField.getText().isEmpty()){
				statusLabel.setText("Please input a Name and ID!");
			}else if(firstNameField.getText().isEmpty()){
				statusLabel.setText("Please input a Name!");
			}else if(idField.getText().isEmpty()){
				statusLabel.setText("Please input an ID!");
			}else if(!firstNameField.getText().equals(Main.names.get(i)[0]) && !idField.getText().equals(Main.names.get(i)[2])){
				statusLabel.setText("Wrong Credentials");


			}else if (firstNameField.getText().equals(Main.names.get(i)[0]) && idField.getText().equals(Main.names.get(i)[2])){
				statusLabel.setText("");

				application.Main.mainStage = (Stage) submitButton.getScene().getWindow();
				application.Main.mainStage.setScene(application.Main.scene2);
			}else{

			}


		}





			loadFile.close();
		} catch(FileNotFoundException ep){

		}catch(IOException ep){

		}catch(ClassNotFoundException ep){

		}
		firstNameField.clear();
		idField.clear();
	}




}
