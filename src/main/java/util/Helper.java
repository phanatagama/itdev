package util;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class Helper {
    public static void changePage(Event event, String viewName) {
        Node node = (Node) event.getSource();
        Scene oldScene = node.getScene();
        Stage stage = (Stage) oldScene.getWindow();
        try {
            Parent view = FXMLLoader.load(Helper.class.getResource("../"+viewName + ".fxml"));
            Scene newScene = new Scene(view);
            stage.setScene(newScene);
            stage.show();
        } catch (IOException e) {
            System.err.println("View Tidak Ditemukan");
            e.printStackTrace();
        }
    }


    // HOST, username, password, nama database
    private static final String HOST = "127.0.0.1";
    private static final String DATABASE = "itdev";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = String.format("jdbc:mysql://%s/%s", HOST, DATABASE);
            Connection connection = DriverManager.getConnection(url, "masif088", "masif088A123");
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static ResultSet getResult(String query) {
        Connection connection = getConnection();
        ResultSet resultSet = null;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    public static boolean insert(String query) throws SQLException {
        return getConnection().prepareCall(query).execute();
    }
    public static boolean update(String query) throws SQLException {
        return getConnection().prepareCall(query).execute();
    }


}