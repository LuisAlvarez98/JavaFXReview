package application;

import javafx.beans.property.SimpleStringProperty;

/**
 * @author Luis Alvarez
 * @since 10/27/2016
 * @version 1.0
 *
 */
public class Workers {




	private final SimpleStringProperty firstName;
	private final SimpleStringProperty lastName;
	private final SimpleStringProperty id;
	private final SimpleStringProperty income;
	private final SimpleStringProperty education;
	private final SimpleStringProperty age;

	public Workers(String fName, String lName, String wId, String wIncome, String wEducation, String wAge){

		this.firstName = new SimpleStringProperty(fName);
		this.lastName = new SimpleStringProperty(lName);
		this.id = new SimpleStringProperty(wId);
		this.income = new SimpleStringProperty(wIncome);
		this.education = new SimpleStringProperty(wEducation);
		this.age = new SimpleStringProperty(wAge);
	}

	public  String getFirstName(){
		return firstName.get();
	}
	public void setFirstName(String fName){
		firstName.set(fName);
	}
	public  String getLastName(){
		return lastName.get();
	}
	public void setLastName(String lName){
		firstName.set(lName);
	}
	public  String getId(){
		return id.get();
	}
	public void setId(String wId){
		id.set(wId);
	}
	public  String getIncome(){
		return income.get();
	}
	public void setIncome(String wIncome){
		income.set(wIncome);
	}
	public  String getEducation(){
		return education.get();
	}
	public void setEducation(String wEducation){
		education.set(wEducation);
	}
	public  String getAge(){
		return age.get();
	}
	public void setAge(String wAge){
		age.set(wAge);
	}
}
