package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * MenuController
 *
 * Is in charge of the MenuGUI  actions
 *
 * @author Luis Alvarez
 * @since 10/27/2016
 * @version 1.0
 *
 */
public class MenuController implements Initializable {


	@FXML private Button logout;
	@FXML private Button workerTableButton;
	@FXML private Button graphButton;
	@FXML private Button registerButton;


	/**
	 * logoutButtonPressed
	 * in charge of logging off the user
	 * @param e
	 */
	public void logoutButtonPressed(ActionEvent e){
		application.Main.mainStage.setScene(application.Main.scene1);
	}
	/**
	 * workerTableButtonPressed
	 * in charge of taking the user to the scene 4
	 * @param e
	 */
	public void workerTableButtonPressed(ActionEvent e){
		application.Main.mainStage.setScene(application.Main.scene4);
	}
	/**
	 * graphButtonPressed
	 * in charge of taking the user to the scene5
	 *
	 * @param e
	 */
	public void graphButtonPressed(ActionEvent e){
		application.Main.mainStage.setScene(application.Main.scene5);
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stu



	}
	/**
	 * registerButtonPressed
	 * in charge of taking the user to the scene 6
	 * @param e
	 */
	public void registerButtonPressed(ActionEvent e)
	{

		application.Main.mainStage.setScene(application.Main.scene6);
	}

}
