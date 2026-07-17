package com.example.prodjects_gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label messageLabel;

    @FXML
    private void handleLogin() {

        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.equals("derk.reyes@cit.edu") &&
                password.equals("1234")) {

            messageLabel.setStyle("-fx-text-fill: green;");
            messageLabel.setText("Login Successful!");

        } else {

            messageLabel.setStyle("-fx-text-fill: red;");
            messageLabel.setText("Invalid Username or Password!");
        }
    }

    @FXML
    private void openRegister(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("register-view.fxml"));

        Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.setTitle("Register");
        stage.show();
    }

    public void login(ActionEvent event) throws IOException {

        // Optional: validate username/password here

        Parent root = FXMLLoader.load(getClass().getResource("landing-view.fxml"));

        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.setTitle("Learning Management System");
        stage.show();
    }

}