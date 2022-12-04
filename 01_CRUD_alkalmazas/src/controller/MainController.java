package controller;

 import com.sun.org.apache.xpath.internal.operations.Bool;
 import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
 import javafx.scene.control.*;
 import javafx.scene.control.cell.PropertyValueFactory;
 import library.Lelekszam;
 import library.Megye;
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
    private Button megyeView;
    @FXML
    private Button lelekszamView;
    @FXML
    private Button varosView;
    @FXML
    private Button deleteButton;

    @FXML
    private TableView<Varos> TableView;

    @FXML
    private TableColumn<Varos, Integer> idColumn;
    
    @FXML
    private TableColumn<Varos, String> nevColumn;

    @FXML
    private TableColumn<Varos, Integer> megyeidColumn;

    @FXML
    private TableColumn<Varos, Boolean> megyeszekhelyColumn;

    @FXML
    private TableColumn<Varos, Boolean> megyeijoguColumn;
    @FXML
    private TableView<Megye> TableViewMegye;
    @FXML
    private TableColumn<Megye, Integer> idmegyeColumn;
    @FXML
    private TableColumn<Megye, String> nevmegyeColumn;
    @FXML
    private TableView<Lelekszam> TableViewLelekszam;
    @FXML
    private TableColumn<Lelekszam, Integer> varosidColumn;
    @FXML
    private TableColumn<Lelekszam, Integer> evColumn;
    @FXML
    private TableColumn<Lelekszam, Integer> noColumn;
    @FXML
    private TableColumn<Lelekszam, Integer> osszesenColumn;



    @FXML
    private void insertButton() {
    	String query = "insert into Varos values("+cityIdField.getText()+",'"+cityNameField.getText()+"','"+countyIdField.getText()+"',"+countySeatField.getText()+","+countyCouncilField.getText()+")";
    	executeQuery(query);
    	showVaros();
    }

    @FXML 
    private void updateButton() {
    String query = "UPDATE Varos SET Name='"+cityNameField.getText()+"',CountyId='"+countyIdField.getText()+"',CountySeat="+countySeatField.getText()+",CountyCouncil="+countyCouncilField.getText()+" WHERE ID="+cityIdField.getText()+"";
    executeQuery(query);
        showVaros();
    }
    
    @FXML
    private void deleteButton() {
    	String query = "DELETE FROM Varos WHERE ID="+cityIdField.getText()+"";
    	executeQuery(query);
        showVaros();
    }
    @FXML
    private void megyeView(){
        String query = "Select * from Megye Where 1";
        showMegye();
        TableView.setVisible(false);
        TableView.setEditable(false);
        TableViewMegye.setVisible(true);
        TableViewMegye.setEditable(true);
        TableViewLelekszam.setVisible(false);
        TableViewLelekszam.setEditable(false);
    }
    @FXML
    private void lelekszamView(){
        String query = "Select * from Lelekszam Where 1";
        showLelekszam();
        TableView.setVisible(false);
        TableView.setEditable(false);
        TableViewMegye.setVisible(false);
        TableViewMegye.setEditable(false);
        TableViewLelekszam.setVisible(true);
        TableViewLelekszam.setEditable(true);
    }
    @FXML
    private void varosView(){
        String query = "Select * from Varos Where 1";
        showVaros();
        TableView.setVisible(true);
        TableView.setEditable(true);
        TableViewMegye.setVisible(false);
        TableViewMegye.setEditable(false);
        TableViewLelekszam.setVisible(false);
        TableViewLelekszam.setEditable(false);
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
        TableViewMegye.setVisible(false);
        showVaros();
    }
    
    public Connection getConnection() {
    	Connection conn;
    	try {
    		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/varosok","root","");
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
				books = new Varos(rs.getInt("Id"),rs.getString("nev"),rs.getInt("megyeid"),rs.getBoolean("megyeszekhely"),rs.getBoolean("megyeijogu"));
				booksList.add(books);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return booksList;
    }
    public ObservableList<Megye> getBooksMegyeList(){
        ObservableList<Megye> booksList = FXCollections.observableArrayList();
        Connection connection = getConnection();
        String query = "SELECT * FROM Megye ";
        Statement st;
        ResultSet rs;

        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Megye books;
            while(rs.next()) {
                books = new Megye(rs.getInt("Id"),rs.getString("nev"));
                booksList.add(books);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return booksList;
    }
    public ObservableList<Lelekszam> getBooksLelekszamList(){
        ObservableList<Lelekszam> booksList = FXCollections.observableArrayList();
        Connection connection = getConnection();
        String query = "SELECT * FROM Lelekszam ";
        Statement st;
        ResultSet rs;

        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Lelekszam books;
            while(rs.next()) {
                books = new Lelekszam(rs.getInt("varosid"),rs.getInt("ev"),rs.getInt("no"),rs.getInt("osszesen"));
                booksList.add(books);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return booksList;
    }
    public void showVaros() {
    	ObservableList<Varos> list = getBooksList();
        idColumn.setCellValueFactory(new PropertyValueFactory<Varos,Integer>("id"));
        nevColumn.setCellValueFactory(new PropertyValueFactory<Varos,String>("nev"));
        megyeidColumn.setCellValueFactory(new PropertyValueFactory<Varos,Integer>("megyeid"));
        megyeszekhelyColumn.setCellValueFactory(new PropertyValueFactory<Varos,Boolean>("megyeszekhely"));
        megyeijoguColumn.setCellValueFactory(new PropertyValueFactory<Varos,Boolean>("megyeijogu"));
    	TableView.setItems(list);
    }
    public void showMegye() {
        ObservableList<Megye> listmegye = getBooksMegyeList();
        idmegyeColumn.setCellValueFactory(new PropertyValueFactory<Megye,Integer>("id"));
        nevmegyeColumn.setCellValueFactory(new PropertyValueFactory<Megye,String>("nev"));
        if(megyeView.isPressed())
        {
            TableViewMegye.setVisible(true);
            TableViewMegye.setEditable(true);
            TableView.setVisible(false);
            TableView.setEditable(false);
        }
        TableViewMegye.setItems(listmegye);
    }
    public void showLelekszam() {
        ObservableList<Lelekszam> listlelekszam = getBooksLelekszamList();
        varosidColumn.setCellValueFactory(new PropertyValueFactory<Lelekszam,Integer>("id"));
        evColumn.setCellValueFactory(new PropertyValueFactory<Lelekszam,Integer>("ev"));
        noColumn.setCellValueFactory(new PropertyValueFactory<Lelekszam,Integer>("no"));
        osszesenColumn.setCellValueFactory(new PropertyValueFactory<Lelekszam,Integer>("osszesen"));
        if(lelekszamView.isPressed())
        {
            TableViewMegye.setVisible(false);
            TableViewMegye.setEditable(false);
            TableView.setVisible(false);
            TableView.setEditable(false);
        }
        TableViewLelekszam.setItems(listlelekszam);
    }
}
