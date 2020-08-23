package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import util.Helper;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
    String user;
    String pass;
    @FXML
    private Button login;

    @FXML Button register;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    void btnLogin(ActionEvent event) {
        user = username.getText();
        pass = password.getText();
        String query="SELECT * FROM `users` WHERE username='"+user+"' and password='"+pass+"'";
        ResultSet rs= Helper.getResult(query);
        try {
            if (rs.next()){
                Helper.changePage(event,"dashboard");
            }
            else {
                JOptionPane.showMessageDialog(null, "anda bukan siapa siapa");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @FXML
    void btnRegister(ActionEvent event) {
        Helper.changePage(event,"register");
    }

}