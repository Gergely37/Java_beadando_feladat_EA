//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package RC;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class RestClient {
    private static String getResponseValue;
    private String putResponseValue;
    private String deleteResponseValue;
    static HttpsURLConnection connection;
    static String token = "c5b05a628e26a5a955b5ba030f6143627cfd9ee8e7ff1a90de04fbfc6661105f";

    public RestClient() {
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

    static void request3(int code) throws IOException {
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
        } else {
            System.out.println("Hiba!!!");
            getResponseValue = new String("A kérés válasza: Hiba a kért erőforrás nem található!");
        }

        connection.disconnect();
    }

    public static void POST(String name, String gender, String email, String status) throws IOException {
        System.out.println("\nPOST...");
        URL postUrl = new URL("https://gorest.co.in/public/v1/users");
        connection = (HttpsURLConnection)postUrl.openConnection();
        connection.setRequestMethod("POST");
        request1();
        String params = "{\"name\":\"" + name + "\", \"gender\":\"" + gender + "\", \"email\":\"" + email + "\", \"status\":\"" + status + "\"}";
        request2(params);
        request3(201);
    }

    public static void PUT(String ID, String name, String gender, String email, String status) throws IOException {
        System.out.println("\nPUT...");
        String url = "https://gorest.co.in/public/v1/users/" + ID;
        URL postUrl = new URL(url);
        connection = (HttpsURLConnection)postUrl.openConnection();
        connection.setRequestMethod("PUT");
        request1();
        String params = "{\"name\":\"" + name + "\", \"gender\":\"" + gender + "\", \"email\":\"" + email + "\", \"status\":\"" + status + "\"}";
        request2(params);
        request3(200);
    }

    public static void DELETE(String ID) throws IOException {
        System.out.println("\nDELETE...");
        String url = "https://gorest.co.in/public/v1/users/" + ID;
        URL postUrl = new URL(url);
        connection = (HttpsURLConnection)postUrl.openConnection();
        connection.setRequestMethod("DELETE");
        request1();
        request3(204);
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
}
