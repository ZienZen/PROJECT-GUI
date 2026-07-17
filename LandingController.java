package com.example.prodjects_gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Controller for the LMS landing page (landing.fxml).
 * Each method below is a stub — wire it up to load the matching
 * screen (e.g. via FXMLLoader + scene swap) once those FXML files exist.
 */
public class LandingController {

    @FXML
    private Label statusLabel;

    @FXML
    private void openStudentDashboard() {
        statusLabel.setText("Opening Student Dashboard...");

    }

    @FXML
    private void openCourseManagement() {
        statusLabel.setText("Opening Course Management...");

    }

    @FXML
    private void openAssignmentSubmission() {
        statusLabel.setText("Opening Assignment Submission...");

    }

    @FXML
    private void openQuizPage() {
        statusLabel.setText("Opening Quiz Page...");

    }

    @FXML
    private void openViewGrades() {
        statusLabel.setText("Opening View Grades...");

    }
}