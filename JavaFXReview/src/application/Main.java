package application;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


/**
 * @author Luis Alvarez
 * @since 10/27/2016
 * @version 1.0
 *
 */
public class Main extends Application {
	public static Parent root;
	public static Parent second;
	public static Parent third;
	public static Parent fourth;
	public static Parent fifth;
	public static Parent six;


	public static List<String[]> names = new ArrayList<String[]>();
	public static Scene scene1;
	public static Scene scene2;
	public static Scene scene3;
	public static Scene scene4;
	public static Scene scene5;
	public static Scene scene6;

	public static Stage mainStage;
	@Override

	public void start(Stage primaryStage) {
		try {
			root = FXMLLoader.load(getClass().getResource("/application/LoginGUI.fxml"));
			second = FXMLLoader.load(getClass().getResource("/application/MenuGUI.fxml"));
			third = FXMLLoader.load(getClass().getResource("/application/InputWorkerGUI.fxml"));
			fourth = FXMLLoader.load(getClass().getResource("/application/WorkerTableGUI.fxml"));
			fifth = FXMLLoader.load(getClass().getResource("/application/GraphsGUI.fxml"));
			six = FXMLLoader.load(getClass().getResource("/application/RegisterGUI.fxml"));
			
			scene1 = new Scene(root);
			scene2 = new Scene(second);
			scene3 = new Scene(third);
			scene4 = new Scene(fourth);
			scene5 = new Scene(fifth);
			scene6 = new Scene(six);
			primaryStage.setResizable(false);
			scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene1);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
