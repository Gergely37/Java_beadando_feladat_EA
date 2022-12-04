package controller;

 import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
 import library.Varos;
 import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ResourceBundle;





public class MainController implements Initializable {

    @FXML
    private TextField cityIdField; // idField;
    
    @FXML
    private TextField cityNameField; // titleField;

    @FXML
    private TextField  countyIdField; // authorField;

    @FXML
    private TextField countySeatField; // yearField;

    @FXML
    private TextField countyCouncilField; // pagesField;

    @FXML
    private Button insertButton;

    @FXML
    private Button updateButton;

    @FXML
    private Button deleteButton;

    @FXML
    private TableView<Varos> TableView;
    
    @FXML
    private TableColumn<Varos>, Integer> idColumn;
    
    @FXML
    private TableColumn<Varos>, String> nameColumn;

    @FXML
    private TableColumn<Varos>, Integer> countyIdColumn;

    @FXML
    private TableColumn<Varos>, Boolean> countySeatColumn;

    @FXML
    private TableColumn<Varos>, Boolean> countyCouncilColumn;

    @FXML
    private void insertButton() {
    	String query = "insert into Varos values("+cityIdField.getText()+",'"+cityNameField.getText()+"','"+countyIdField.getText()+"',"+countySeatField.getText()+","+countyCouncilField.getText()+")";
    	executeQuery(query);
    	showBooks();
    }
    
    
    @FXML 
    private void updateButton() {
    String query = "UPDATE Varos SET Name='"+cityNameField.getText()+"',CountyId='"+countyIdField.getText()+"',CountySeat="+countySeatField.getText()+",CountyCouncil="+countyCouncilField.getText()+" WHERE ID="+cityIdField.getText()+"";
    executeQuery(query);
	showBooks();
    }
    
    @FXML
    private void deleteButton() {
    	String query = "DELETE FROM Varos WHERE ID="+cityIdField.getText()+"";
    	executeQuery(query);
    	showBooks();
    }
    
    public void executeQuery(String query) {
    	Connection conn = getConnection();
    	Statement st;
    	try {
			st = conn.createStatement();
			st.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	showBooks();
    }
    
    public Connection getConnection() {
    	Connection conn;
    	try {
    		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/varos","root","admin");
    		return conn;
    	}
    	catch (Exception e){
    		e.printStackTrace();
    		return null;
    	}
    }
    
    public ObservableList<Varos> getBooksList(){
    	ObservableList<Varos> booksList = FXCollections.observableArrayList();
    	Connection connection = getConnection();
    	String query = "SELECT * FROM Varos ";
    	Statement st;
    	ResultSet rs;
    	
    	try {
			st = connection.createStatement();
			rs = st.executeQuery(query);
			Varos books;
			while(rs.next()) {
				books = new Varos(rs.getInt("Id"),rs.getString("Name"),rs.getInt("CountyId"),rs.getBoolean("CountySeat"),rs.getBoolean("CountyCouncil"));
				booksList.add(books);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return booksList;
    }
    
    // I had to change ArrayList to ObservableList I didn't find another option to do this but this works :)
    public void showBooks() {
    	ObservableList<Varos> list = getBooksList();

        idColumn.setCellValueFactory(new PropertyValueFactory<Varos,Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Varos,String>("name"));
        countyIdColumn.setCellValueFactory(new PropertyValueFactory<Varos,Integer>("countyId"));
        countySeatColumn.setCellValueFactory(new PropertyValueFactory<Varos,Boolean>("countySeat"));
        countyCouncilColumn.setCellValueFactory(new PropertyValueFactory<Varos,Boolean>("countyCouncil"));
    	
    	TableView.setItems(list);
    }

}
