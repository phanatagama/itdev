package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import util.Helper;

import javax.swing.*;
import java.sql.SQLException;

public class Register {

    @FXML
    private TextField username;

    @FXML
    private TextField full_name;

    @FXML
    private PasswordField password;

    @FXML
    void btnBack(ActionEvent event) {
        Helper.changePage(event,"login");
    }

    @FXML
    void btnSubmit(ActionEvent event) {
        String query="INSERT INTO `users` (`id`, `username`, `password`, `full_name`) VALUES (NULL, '"+username.getText()+
                "', '"+password.getText()+"', '"+full_name.getText()+"');";
        boolean login=true;
        try {
            login=Helper.insert(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (!login){
            Helper.changePage(event,"dashboard");
        }else {
            JOptionPane.showMessageDialog(null, "Gagal Register");
        }


    }

}