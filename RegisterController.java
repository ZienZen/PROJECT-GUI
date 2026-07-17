package com.example.prodjects_gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class RegisterController {

    @FXML
    private ComboBox<String> registerAs;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private Label messageLabel;

    @FXML
    public void initialize() {

        registerAs.getItems().addAll(
                "STUDENT",
                "INSTRUCTOR"
        );

    }

    @FXML
    private void registerUser(ActionEvent event) {

        String role = registerAs.getValue();
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String username = usernameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        if (role == null ||
                firstName.isEmpty() ||
                lastName.isEmpty() ||
                username.isEmpty() ||
                email.isEmpty() ||
                password.isEmpty() ||
                confirmPassword.isEmpty()) {

            messageLabel.setStyle("-fx-text-fill:red;");
            messageLabel.setText("Please complete all fields.");
            return;
        }

        if (!password.equals(confirmPassword)) {

            messageLabel.setStyle("-fx-text-fill:red;");
            messageLabel.setText("Passwords do not match.");
            return;
        }

        try {

            Connection conn = DBConnection.getConnection();


            String sql = "INSERT INTO users(first_name,last_name,username,email,password,role) VALUES(?,?,?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, username);
            ps.setString(4, email);
            ps.setString(5, password);
            ps.setString(6, role);

            int result = ps.executeUpdate();

            if (result > 0) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Registration Successful!");
                alert.showAndWait();

                Parent root = FXMLLoader.load(getClass().getResource("login-view.fxml"));

                Stage stage = (Stage) firstNameField.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("Login");
                stage.show();

            } else {

                messageLabel.setStyle("-fx-text-fill:red;");
                messageLabel.setText("Registration Failed.");

            }

            conn.close();

        } catch (Exception e) {

            e.printStackTrace();

            messageLabel.setStyle("-fx-text-fill:red;");
            messageLabel.setText("Database Error.");

        }

    }

    @FXML
    private void backToLogin(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("login-view.fxml"));

        Stage stage = (Stage) firstNameField.getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.setTitle("Login");
        stage.show();

    }

}