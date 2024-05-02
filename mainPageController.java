package com.example.swe206project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;


public class mainPageController {

    @FXML
    private AnchorPane APL;

    @FXML
    private AnchorPane APR;

    @FXML
    private BorderPane Bp;

    @FXML
    private Button but1;

    @FXML
    private Button but2;

    @FXML
    private Button but3;

    @FXML
    private Label l1;

    @FXML
    private Label l10;

    @FXML
    private Label l11;

    @FXML
    private Label l12;

    @FXML
    private Label l13;

    @FXML
    private Label l14;

    @FXML
    private Label l15;

    @FXML
    private Label l2;

    @FXML
    private Label l3;

    @FXML
    private Label l4;

    @FXML
    private Label l5;

    @FXML
    private Label l6;

    @FXML
    private Label l7;

    @FXML
    private Label l8;

    @FXML
    private Label l9;

    @FXML
    void loginAdminIsClicked(ActionEvent event) throws IOException {
        Stage registrationAdminStage;
        Parent root = FXMLLoader.load(getClass().getResource("AdminController.fxml"));
        Scene rASce = new Scene(root);
        registrationAdminStage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        registrationAdminStage.setScene(rASce);
        registrationAdminStage.setTitle("Admin Registration Page");
        registrationAdminStage.setResizable(false);
        registrationAdminStage.show();
    }
    @FXML
    void showNextTouramentIsClicked(ActionEvent event) throws IOException {
        Stage ShowTouraments;
        Parent root = FXMLLoader.load(getClass().getResource("ShowTouramntsController.fxml"));
        Scene rASce = new Scene(root);
        ShowTouraments = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        ShowTouraments.setScene(rASce);
        ShowTouraments.setResizable(false);
        ShowTouraments.show();
    }

    @FXML
    void logAsStudentIsClicked(ActionEvent event) throws IOException {

        Stage ShowTouraments;
        Parent root = FXMLLoader.load(getClass().getResource("logingStuPag.fxml"));
        Scene rASce = new Scene(root);
        ShowTouraments = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        ShowTouraments.setScene(rASce);
        ShowTouraments.setResizable(false);
        ShowTouraments.show();
    }


}
