package controller;

 import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
 import javafx.event.ActionEvent;
 import javafx.fxml.FXML;
 import javafx.fxml.FXMLLoader;
 import javafx.fxml.Initializable;
 import javafx.scene.Parent;
 import javafx.scene.Scene;
 import javafx.scene.control.*;
 import javafx.scene.control.cell.PropertyValueFactory;
 import javafx.scene.layout.AnchorPane;
 import javafx.scene.layout.GridPane;
 import javafx.stage.Stage;
 import library.Lelekszam;
 import library.Megye;
 import library.Varos;
 import model.RestDel;
 import org.hibernate.SessionFactory;
 import org.hibernate.cfg.Configuration;

 import javax.net.ssl.HttpsURLConnection;
 import java.io.*;
 import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

 import java.util.ResourceBundle;
public class MainController implements Initializable {
@FXML
public void ElemekTörlése(){
    cityIdField.setVisible(false);
    cityNameField.setVisible(false);
    countyIdField.setVisible(false);
    countySeatField.setVisible(false);
    countyCouncilField.setVisible(false);
    megyeView.setVisible(false);
    lelekszamView.setVisible(false);
    TableView.setVisible(false);
    idColumn.setVisible(false);
    megyeidColumn.setVisible(false);
    nevColumn.setVisible(false);
    megyeszekhelyColumn.setVisible(false);
    idmegyeColumn.setVisible(false);
    megyeijoguColumn.setVisible(false);
    varosView.setVisible(false);
    TableViewLelekszam.setVisible(false);
    TableViewMegye.setVisible(false);
    idlabel.setVisible(false);
    namelabel.setVisible(false);
    countycouncillabel.setVisible(false);
    countyidlabel.setVisible(false);
    countyseatlabel.setVisible(false);
    insertButton.setVisible(false);
    deleteButton.setVisible(false);
    updateButton.setVisible(false);
    gpr1del.setVisible(false);
    Gridpane.setVisible(false);
    gpr1read.setVisible(false);
    gpr1mod.setVisible(false);
}
    @FXML
    private GridPane Gridpane;
    @FXML
    private GridPane gpr1del;
    @FXML
    private GridPane gpr1read;
    @FXML
    private GridPane gpr1mod;
    @FXML
    private Button insertButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button updateButton;
    @FXML
    private Label idlabel;
    @FXML
    private Label namelabel;
    @FXML
    private Label countycouncillabel;
    @FXML
    private Label countyidlabel;
    @FXML
    private Label countyseatlabel;

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
    private Button varosView;

    @FXML
    private Button megyeView;
    @FXML
    private Button lelekszamView;

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
    SessionFactory factory;
    @FXML
    private TableColumn<Lelekszam, Integer> osszesenColumn;
    @FXML void initialize(){
        ElemekTörlése();
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        factory = cfg.buildSessionFactory();
        }
    @FXML
    private AnchorPane mainAnchorPane;
    @FXML
    private Menu crud;
    @FXML
    private MenuItem Rest1read;
    @FXML
    private TextField rest1delID;
    @FXML
    private TextField restpostid;
    @FXML
    private TextField restpostname;
    @FXML
    private TextField restpostgender;
    @FXML
    private TextField restpostemail;
    @FXML
    private TextField restpoststatus;
    Stage stage;
    @FXML
    Parent root;
    @FXML
    private static TextArea gpr1readtext;
    @FXML void goToCrud(){
        ElemekTörlése();

    }
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
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nevColumn.setCellValueFactory(new PropertyValueFactory<>("nev"));
        megyeidColumn.setCellValueFactory(new PropertyValueFactory<>("megyeid"));
        megyeszekhelyColumn.setCellValueFactory(new PropertyValueFactory<>("megyeszekhely"));
        megyeijoguColumn.setCellValueFactory(new PropertyValueFactory<>("megyeijogu"));
    	TableView.setItems(list);
    }
    public void showMegye() {
        ObservableList<Megye> listmegye = getBooksMegyeList();
        idmegyeColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nevmegyeColumn.setCellValueFactory(new PropertyValueFactory<>("nev"));
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
        varosidColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        evColumn.setCellValueFactory(new PropertyValueFactory<>("ev"));
        noColumn.setCellValueFactory(new PropertyValueFactory<>("no"));
        osszesenColumn.setCellValueFactory(new PropertyValueFactory<>("osszesen"));
        if(lelekszamView.isPressed())
        {
            TableViewMegye.setVisible(false);
            TableViewMegye.setEditable(false);
            TableView.setVisible(false);
            TableView.setEditable(false);
        }
        TableViewLelekszam.setItems(listlelekszam);
    }
    public void goToRest1() throws IOException {
        ElemekTörlése();
        Gridpane.setVisible(true);
        gpr1del.setVisible(true);
        gpr1read.setVisible(true);
        gpr1mod.setVisible(true);
    }
    public static String getGetResponseValue() {
        return getResponseValue;
    }
    private static String getResponseValue;

    private String putResponseValue;
    private String deleteResponseValue;
    static HttpsURLConnection connection;
    static String token = "c5b05a628e26a5a955b5ba030f6143627cfd9ee8e7ff1a90de04fbfc6661105f";
    public static void GET(String id) throws IOException {
        System.out.println("\nGET...");
        String url = "https://gorest.co.in/public/v1/users";
        if(id!=null) {
            url = url + "/" + id;
            URL usersURL = new URL(url);
            connection = (HttpsURLConnection) usersURL.openConnection();
            connection.setRequestMethod("GET");
        }
        if(id!=null)
            connection.setRequestProperty("Authorization", "Bearer " + token);
        request3(HttpsURLConnection.HTTP_OK);
    }
    static void request1(){
        // Setting Header Parameters
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Authorization", "Bearer " + token);
        connection.setUseCaches(false);
        connection.setDoOutput(true);
    }

    static void request2(String params) throws IOException {
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream(), "UTF-8"));
        wr.write(params);
        wr.close();
        connection.connect();
    }
    public static void request3(int code) throws IOException {
        int statusCode = connection.getResponseCode();
        System.out.println("Status code: " + statusCode);
        if(statusCode == code){
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer jsonResponseData = new StringBuffer();
            String readLine = null;
            while ((readLine = in.readLine()) != null){
                jsonResponseData.append(readLine);
            }
            in.close();
            getResponseValue = new String("A kérés válasza: " + jsonResponseData.toString());
            gpr1readtext.setText(jsonResponseData.toString());
        }else{
            System.out.println("Hiba!!!");
            getResponseValue = new String("A kérés válasza: Hiba a kért erőforrás nem található!");
        }
        connection.disconnect();
    }
    public void restDeleteButton() throws IOException {
        System.out.println("\nDELETE...");
        String ID = rest1delID.getText();
        String url = "https://gorest.co.in/public/v1/users"+"/"+ID;
        URL postUrl = new URL(url);
        connection = (HttpsURLConnection) postUrl.openConnection();
        connection.setRequestMethod("DELETE");
        request1();
        request3(HttpsURLConnection.HTTP_NO_CONTENT);
    }
    public void restPostButton() throws IOException{
        System.out.println("\nPOST...");
        String name = restpostname.getText();
        String gender = restpostgender.getText();
        String email = restpostemail.getText();
        String status = restpoststatus.getText();
        URL postUrl = new URL("https://gorest.co.in/public/v1/users"+"/");
        connection = (HttpsURLConnection) postUrl.openConnection();
        connection.setRequestMethod("POST");
        request1();
        String params = "{\"name\":\""+name+"\", \"gender\":\""+gender+"\", \"email\":\""+email+"\", \"status\":\""+status+"\"}";
        request2(params);
        request3(HttpsURLConnection.HTTP_CREATED);
    }

}
