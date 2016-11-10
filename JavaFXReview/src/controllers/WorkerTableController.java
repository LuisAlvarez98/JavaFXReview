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
import application.Workers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * WorkerTableController
 *
 * Is in charge of the WorkerTableController actions
 *
 * @author Luis Alvarez
 * @since 10/27/2016
 * @version 1.0
 *
 */
public class WorkerTableController implements Initializable {

	@FXML private Button backButton;
	@FXML private Button refreshButton;
	@FXML private Button deleteButton;
	@FXML private TextField idField;
	//Table
	@FXML private TableView<Workers> dataTable;
	@FXML private TableColumn<Workers, String> firstNameCol;
	@FXML private TableColumn<Workers, String> lastNameCol;
	@FXML private TableColumn<Workers, String> idCol;
	@FXML private TableColumn<Workers, String> educationCol;
	@FXML private TableColumn<Workers, String> ageCol;
	@FXML private TableColumn<Workers, String> incomeCol;
	@FXML private Button registerButton;


	private ObjectInputStream loadFile;
	private String fileLocation = System.getProperty("user.dir")+ "/table.dat";
	private ObjectOutputStream saveFile;
	int flag;

	private ObservableList<Workers> data =  FXCollections.observableArrayList();


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		try{
			loadFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileLocation)));
			try{
				Main.names = (List<String[]>) loadFile.readObject();
				firstNameCol.setCellValueFactory(new PropertyValueFactory<Workers, String>("firstName"));
				lastNameCol.setCellValueFactory(new PropertyValueFactory<Workers, String>("lastName"));
				idCol.setCellValueFactory(new PropertyValueFactory<Workers, String>("id"));
				educationCol.setCellValueFactory(new PropertyValueFactory<Workers, String>("education"));
				incomeCol.setCellValueFactory(new PropertyValueFactory<Workers, String>("income"));
				ageCol.setCellValueFactory(new PropertyValueFactory<Workers, String>("age"));
				dataTable.setEditable(true);
				for(int i = 0; i < Main.names.size(); i++){
					data.add(new Workers(Main.names.get(i)[0],Main.names.get(i)[1],Main.names.get(i)[2],Main.names.get(i)[3],Main.names.get(i)[4],Main.names.get(i)[5]));
				}
				dataTable.setItems(data);
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
	 * refreshButtonPressed
	 * in charge of refreshing the table
	 *
	 * @param e
	 */
	@SuppressWarnings("unchecked")
	@FXML
	public void refreshButtonPressed(ActionEvent e){
		data.clear();
		try{
			loadFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileLocation)));
			try{
				Main.names = (List<String[]>) loadFile.readObject();
				firstNameCol.setCellValueFactory(new PropertyValueFactory<Workers, String>("firstName"));
				lastNameCol.setCellValueFactory(new PropertyValueFactory<Workers, String>("lastName"));
				idCol.setCellValueFactory(new PropertyValueFactory<Workers, String>("id"));
				educationCol.setCellValueFactory(new PropertyValueFactory<Workers, String>("education"));
				incomeCol.setCellValueFactory(new PropertyValueFactory<Workers, String>("income"));
				ageCol.setCellValueFactory(new PropertyValueFactory<Workers, String>("age"));
				dataTable.setEditable(true);
				for(int i = 0; i < Main.names.size(); i++){
					data.add(new Workers(Main.names.get(i)[0],Main.names.get(i)[1],Main.names.get(i)[2],Main.names.get(i)[3],Main.names.get(i)[4],Main.names.get(i)[5]));
				}
				dataTable.setItems(data);
				loadFile.close();
		}catch(ClassNotFoundException ep)
			{

			}
		}catch(FileNotFoundException ep)
			{

			}catch(IOException ep)
			{

			}


	}
	/**
	 * backButtonPressed
	 *
	 * in charge of going back to scene 2
	 * @param e
	 */
	@FXML
	public void backButtonPressed(ActionEvent e){

		application.Main.mainStage.setScene(application.Main.scene2);
	}
	/**
	 *deleteButtonPressed
	 *in charge of deleting workers from the table
	 */
	@FXML
	public void deleteButtonPressed(){
		String name = idField.getText();
		flag = -1;
		for(int i = 0; i <Main.names.size(); i++){
			if(Main.names.get(i)[2].equals(name)){
				flag = i;
			}
		}
		if(flag != -1){
			Main.names.remove(flag);

			ObjectOutputStream saveFile;
			String fileLocation = System.getProperty("user.dir") + "/table.dat";
			try{
				saveFile = new ObjectOutputStream(new BufferedOutputStream(
						new FileOutputStream(fileLocation)));
				saveFile.writeObject(Main.names);
				saveFile.flush();
				saveFile.close();
			} catch(FileNotFoundException e){
				e.printStackTrace();
			} catch(IOException e){
				e.printStackTrace();
			}

		}


	}



}
