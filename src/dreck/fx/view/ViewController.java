package dreck.fx.view;

import dreck.fx.model.DBConnection;
import dreck.fx.model.People;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ViewController 
{
	
	
	@FXML
	TextField label;
	
	@FXML
	TextField id;
	
	@FXML
	TextField name;
	
	@FXML
	protected void newPressed()
	{	
		People people = new People(new DBConnection().openConnection("postgres", "admin"));
		people.insertPerson(Integer.parseInt(id.getText()), name.getText());
		label.setText("Insertion done successfully with ID="+id.getText()+" and Name="+name.getText());
	}
	
	@FXML
	protected void editPressed()
	{	
		People people = new People(new DBConnection().openConnection("postgres", "admin"));
		people.updatePeople(Integer.parseInt(id.getText()), name.getText());
		label.setText("Updating of ID's=" + id.getText() + " NAME=" +name.getText()+ " done successfully");
	}
	
	@FXML
	protected void deletePressed()
	{	
		People people = new People(new DBConnection().openConnection("postgres", "admin"));
		people.deletePerson(Integer.parseInt(id.getText()), name.getText());
		label.setText("Deletion of " +id.getText()+ " done successfully");
	}
	
	@FXML
    private void initialize() 
	{
		
	}

	
}
