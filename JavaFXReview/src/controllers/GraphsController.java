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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

/**
 * GraphsController
 *
 * In charge of the GraphsGUI and all its actions
 *
 * @author Luis Alvarez
 * @since 10/27/2016
 * @version 1.0
 *
 */
public class GraphsController implements Initializable {
	@FXML private Button backButton;

	@FXML private RadioButton ageEducation;
	@FXML private RadioButton ageIncome;
	@FXML private RadioButton educationIncome;

     @FXML private NumberAxis xAxis;
     @FXML private NumberAxis yAxis;
     @FXML private ScatterChart<Number, Number> xyChart;

     XYChart.Series<Number, Number> series1 = new XYChart.Series<>();
     XYChart.Series<Number, Number> series2 = new XYChart.Series<>();
     XYChart.Series<Number, Number> series3 = new XYChart.Series<>();



 	private ObjectInputStream loadFile;
 	private String fileLocation = System.getProperty("user.dir")+ "/table.dat";

	/**
	 * backButtonPressed
	 * in charge of taking the user back to the main menu
	 * @param e
	 */
	@FXML
	public void backButtonPressed(ActionEvent e){

		application.Main.mainStage.setScene(application.Main.scene2);
	}
	/**
	 * ageEducationPressed
	 * in charge of adding and removing the graph
	 * @param e
	 */
	@FXML
	public void  ageEducationPressed(ActionEvent e){
		if(ageEducation.isSelected()){

				xyChart.getData().add(series1);


    	}else{

				xyChart.getData().remove(series1);

    	}

	}
	/**
	 * ageIncomePressed
	 * in charge of adding and removing the graph
	 * @param e
	 */
	@FXML
	public void  ageIncomePressed(ActionEvent e){
		if(ageIncome.isSelected()){

				xyChart.getData().add(series2);

    	}else{

				xyChart.getData().remove(series2);

    	}
	}
	/**
	 * educationIncomePressed
	 * in charge of adding and removing the graph
	 * @param e
	 */
	@FXML
	public void educationIncomePressed(ActionEvent e){
		if(educationIncome.isSelected()){


				xyChart.getData().add(series3);

    	}else{

				xyChart.getData().remove(series3);

    	}
	}






	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

			fillGraph();





	}
	/**
	 * fillGraph method
	 *
	 * in charge of filling up all the graphs
	 */
	public void fillGraph(){
		try{

			loadFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileLocation)));
			try{
				Main.names = (List<String[]>) loadFile.readObject();
				 xAxis.setAutoRanging(true);
		         yAxis.setAutoRanging(true);


		         series1.setName("Age/Education");
		         series2.setName("Age/Income");
		         series3.setName("Education/Income");

		        	 int age = 0;
		        	 int income = 0;
		        	 int edu = 0;
		        	 for(int i = 0; i < Main.names.size();i++){

		        		 if(Main.names.get(i)[4].equals("Junior High")){
		        			 edu = 10;
		        		 }else if(Main.names.get(i)[4].equals("HighSchool")){
		        			 edu = 20;
		        		 }else if(Main.names.get(i)[4].equals("Profesional")){
		        			 edu = 30;
		        		 }
		        		 age = Integer.parseInt(Main.names.get(i)[5]);
		        		 income =Integer.parseInt( Main.names.get(i)[3]);
		             	 series1.getData().add(new XYChart.Data(edu ,age));
		        		 series2.getData().add(new XYChart.Data(income ,age));
		        		 series3.getData().add(new XYChart.Data(edu ,income));
		        	 }
		        	 loadFile.close();
		}catch(ClassNotFoundException e)
			{
			e.printStackTrace();
			}
		}catch(FileNotFoundException e)
			{
			e.printStackTrace();
			}catch(IOException e)
			{
				e.printStackTrace();
			}




	}

	}



