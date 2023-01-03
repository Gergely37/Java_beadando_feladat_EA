//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javax.net.ssl.HttpsURLConnection;
import library.Lelekszam;
import library.Megye;
import library.Varos;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainController implements Initializable {
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
    private TextField cityIdField;
    @FXML
    private TextField cityNameField;
    @FXML
    private TextField countyIdField;
    @FXML
    private TextField countySeatField;
    @FXML
    private TextField countyCouncilField;
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
    private static String getResponseValue;
    private String putResponseValue;
    private String deleteResponseValue;
    static HttpsURLConnection connection;
    static String token = "c5b05a628e26a5a955b5ba030f6143627cfd9ee8e7ff1a90de04fbfc6661105f";

    public MainController() {
    }

    @FXML
    public void ElemekTörlése() {
        this.cityIdField.setVisible(false);
        this.cityNameField.setVisible(false);
        this.countyIdField.setVisible(false);
        this.countySeatField.setVisible(false);
        this.countyCouncilField.setVisible(false);
        this.megyeView.setVisible(false);
        this.lelekszamView.setVisible(false);
        this.TableView.setVisible(false);
        this.idColumn.setVisible(false);
        this.megyeidColumn.setVisible(false);
        this.nevColumn.setVisible(false);
        this.megyeszekhelyColumn.setVisible(false);
        this.idmegyeColumn.setVisible(false);
        this.megyeijoguColumn.setVisible(false);
        this.varosView.setVisible(false);
        this.TableViewLelekszam.setVisible(false);
        this.TableViewMegye.setVisible(false);
        this.idlabel.setVisible(false);
        this.namelabel.setVisible(false);
        this.countycouncillabel.setVisible(false);
        this.countyidlabel.setVisible(false);
        this.countyseatlabel.setVisible(false);
        this.insertButton.setVisible(false);
        this.deleteButton.setVisible(false);
        this.updateButton.setVisible(false);
        this.gpr1del.setVisible(false);
        this.Gridpane.setVisible(false);
        this.gpr1read.setVisible(false);
        this.gpr1mod.setVisible(false);
    }

    @FXML
    void initialize() {
        this.ElemekTörlése();
        Configuration cfg = (new Configuration()).configure("hibernate.cfg.xml");
        this.factory = cfg.buildSessionFactory();
    }

    @FXML
    void goToCrud() {
        this.ElemekTörlése();
    }

    @FXML
    private void insertButton() {
        String query = "insert into Varos values(" + this.cityIdField.getText() + ",'" + this.cityNameField.getText() + "','" + this.countyIdField.getText() + "'," + this.countySeatField.getText() + "," + this.countyCouncilField.getText() + ")";
        this.executeQuery(query);
        this.showVaros();
    }

    @FXML
    private void updateButton() {
        String query = "UPDATE Varos SET Name='" + this.cityNameField.getText() + "',CountyId='" + this.countyIdField.getText() + "',CountySeat=" + this.countySeatField.getText() + ",CountyCouncil=" + this.countyCouncilField.getText() + " WHERE ID=" + this.cityIdField.getText() + "";
        this.executeQuery(query);
        this.showVaros();
    }

    @FXML
    private void deleteButton() {
        String query = "DELETE FROM Varos WHERE ID=" + this.cityIdField.getText() + "";
        this.executeQuery(query);
        this.showVaros();
    }

    @FXML
    private void megyeView() {
        String query = "Select * from Megye Where 1";
        this.showMegye();
        this.TableView.setVisible(false);
        this.TableView.setEditable(false);
        this.TableViewMegye.setVisible(true);
        this.TableViewMegye.setEditable(true);
        this.TableViewLelekszam.setVisible(false);
        this.TableViewLelekszam.setEditable(false);
    }

    @FXML
    private void lelekszamView() {
        String query = "Select * from Lelekszam Where 1";
        this.showLelekszam();
        this.TableView.setVisible(false);
        this.TableView.setEditable(false);
        this.TableViewMegye.setVisible(false);
        this.TableViewMegye.setEditable(false);
        this.TableViewLelekszam.setVisible(true);
        this.TableViewLelekszam.setEditable(true);
    }

    @FXML
    private void varosView() {
        String query = "Select * from Varos Where 1";
        this.showVaros();
        this.TableView.setVisible(true);
        this.TableView.setEditable(true);
        this.TableViewMegye.setVisible(false);
        this.TableViewMegye.setEditable(false);
        this.TableViewLelekszam.setVisible(false);
        this.TableViewLelekszam.setEditable(false);
    }

    public void executeQuery(String query) {
        Connection conn = this.getConnection();

        try {
            Statement st = conn.createStatement();
            st.executeUpdate(query);
        } catch (Exception var5) {
            var5.printStackTrace();
        }

    }

    public void initialize(URL location, ResourceBundle resources) {
        this.TableViewMegye.setVisible(false);
        this.showVaros();
    }

    public Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/varosok", "root", "");
            return conn;
        } catch (Exception var3) {
            var3.printStackTrace();
            return null;
        }
    }

    public ObservableList<Varos> getBooksList() {
        ObservableList<Varos> booksList = FXCollections.observableArrayList();
        Connection connection = this.getConnection();
        String query = "SELECT * FROM Varos ";

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            while(rs.next()) {
                Varos books = new Varos(rs.getInt("Id"), rs.getString("nev"), rs.getInt("megyeid"), rs.getBoolean("megyeszekhely"), rs.getBoolean("megyeijogu"));
                booksList.add(books);
            }
        } catch (Exception var7) {
            var7.printStackTrace();
        }

        return booksList;
    }

    public ObservableList<Megye> getBooksMegyeList() {
        ObservableList<Megye> booksList = FXCollections.observableArrayList();
        Connection connection = this.getConnection();
        String query = "SELECT * FROM Megye ";

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            while(rs.next()) {
                Megye books = new Megye(rs.getInt("Id"), rs.getString("nev"));
                booksList.add(books);
            }
        } catch (Exception var7) {
            var7.printStackTrace();
        }

        return booksList;
    }

    public ObservableList<Lelekszam> getBooksLelekszamList() {
        ObservableList<Lelekszam> booksList = FXCollections.observableArrayList();
        Connection connection = this.getConnection();
        String query = "SELECT * FROM Lelekszam ";

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            while(rs.next()) {
                Lelekszam books = new Lelekszam(rs.getInt("varosid"), rs.getInt("ev"), rs.getInt("no"), rs.getInt("osszesen"));
                booksList.add(books);
            }
        } catch (Exception var7) {
            var7.printStackTrace();
        }

        return booksList;
    }

    public void showVaros() {
        ObservableList<Varos> list = this.getBooksList();
        this.idColumn.setCellValueFactory(new PropertyValueFactory("id"));
        this.nevColumn.setCellValueFactory(new PropertyValueFactory("nev"));
        this.megyeidColumn.setCellValueFactory(new PropertyValueFactory("megyeid"));
        this.megyeszekhelyColumn.setCellValueFactory(new PropertyValueFactory("megyeszekhely"));
        this.megyeijoguColumn.setCellValueFactory(new PropertyValueFactory("megyeijogu"));
        this.TableView.setItems(list);
    }

    public void showMegye() {
        ObservableList<Megye> listmegye = this.getBooksMegyeList();
        this.idmegyeColumn.setCellValueFactory(new PropertyValueFactory("id"));
        this.nevmegyeColumn.setCellValueFactory(new PropertyValueFactory("nev"));
        if (this.megyeView.isPressed()) {
            this.TableViewMegye.setVisible(true);
            this.TableViewMegye.setEditable(true);
            this.TableView.setVisible(false);
            this.TableView.setEditable(false);
        }

        this.TableViewMegye.setItems(listmegye);
    }

    public void showLelekszam() {
        ObservableList<Lelekszam> listlelekszam = this.getBooksLelekszamList();
        this.varosidColumn.setCellValueFactory(new PropertyValueFactory("id"));
        this.evColumn.setCellValueFactory(new PropertyValueFactory("ev"));
        this.noColumn.setCellValueFactory(new PropertyValueFactory("no"));
        this.osszesenColumn.setCellValueFactory(new PropertyValueFactory("osszesen"));
        if (this.lelekszamView.isPressed()) {
            this.TableViewMegye.setVisible(false);
            this.TableViewMegye.setEditable(false);
            this.TableView.setVisible(false);
            this.TableView.setEditable(false);
        }

        this.TableViewLelekszam.setItems(listlelekszam);
    }

    public void goToRest1() throws IOException {
        this.ElemekTörlése();
        this.Gridpane.setVisible(true);
        this.gpr1del.setVisible(true);
        this.gpr1read.setVisible(true);
        this.gpr1mod.setVisible(true);
    }

    public static String getGetResponseValue() {
        return getResponseValue;
    }

    public static void GET(String id) throws IOException {
        System.out.println("\nGET...");
        String url = "https://gorest.co.in/public/v1/users";
        if (id != null) {
            url = url + "/" + id;
            URL usersURL = new URL(url);
            connection = (HttpsURLConnection)usersURL.openConnection();
            connection.setRequestMethod("GET");
        }

        if (id != null) {
            connection.setRequestProperty("Authorization", "Bearer " + token);
        }

        request3(200);
    }

    static void request1() {
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
        if (statusCode == code) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer jsonResponseData = new StringBuffer();
            String readLine = null;

            while((readLine = in.readLine()) != null) {
                jsonResponseData.append(readLine);
            }

            in.close();
            getResponseValue = new String("A kérés válasza: " + jsonResponseData.toString());
            gpr1readtext.setText(jsonResponseData.toString());
        } else {
            System.out.println("Hiba!!!");
            getResponseValue = new String("A kérés válasza: Hiba a kért erőforrás nem található!");
        }

        connection.disconnect();
    }

    public void restDeleteButton() throws IOException {
        System.out.println("\nDELETE...");
        String ID = this.rest1delID.getText();
        String url = "https://gorest.co.in/public/v1/users/" + ID;
        URL postUrl = new URL(url);
        connection = (HttpsURLConnection)postUrl.openConnection();
        connection.setRequestMethod("DELETE");
        request1();
        request3(204);
    }

    public void restPostButton() throws IOException {
        System.out.println("\nPOST...");
        String name = this.restpostname.getText();
        String gender = this.restpostgender.getText();
        String email = this.restpostemail.getText();
        String status = this.restpoststatus.getText();
        URL postUrl = new URL("https://gorest.co.in/public/v1/users/");
        connection = (HttpsURLConnection)postUrl.openConnection();
        connection.setRequestMethod("POST");
        request1();
        String params = "{\"name\":\"" + name + "\", \"gender\":\"" + gender + "\", \"email\":\"" + email + "\", \"status\":\"" + status + "\"}";
        request2(params);
        request3(201);
    }
}
