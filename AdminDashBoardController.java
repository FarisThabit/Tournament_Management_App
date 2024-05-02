package com.example.swe206project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminDashBoardController {

    @FXML
    private BorderPane BpAdminDashBoard;

    @FXML
    private AnchorPane aPL;

    @FXML
    private Button but1;

    @FXML
    private Button but2;

    @FXML
    private Button but4;

    @FXML
    private Label l1;

    @FXML
    private Label l2;

    @FXML
    private Label l3;

    @FXML
    private Button but3;
    @FXML
    private Label l4;



    @FXML
    void CreatAtouramentIsClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CreatTouramentsController.fxml"));
        Stage creatAtouramentStage;
        creatAtouramentStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene creatAtouramentSce = new Scene(root);
        creatAtouramentStage.setScene(creatAtouramentSce);
        creatAtouramentStage.setTitle("Touraments Registration Page");
        creatAtouramentStage.setResizable(false);
        creatAtouramentStage.show();

    }
    @FXML
    void deleteTouramentsClicked(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("DeleteTouramentsController.fxml"));
        Stage deleteTouramentsStage;
        deleteTouramentsStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene deleteTouramentsSce = new Scene(root);
        deleteTouramentsStage.setScene(deleteTouramentsSce);
        deleteTouramentsStage.setTitle("Touraments Delation Page");
        deleteTouramentsStage.setResizable(false);
        deleteTouramentsStage.show();
    }

    @FXML
    void editTouramentIsClicked(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EditTouramentsController.fxml"));
        Stage editTouramentsStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene editTouramentsSce = new Scene(root);
        editTouramentsStage.setScene(editTouramentsSce);
        editTouramentsStage.setResizable(false);
        editTouramentsStage.setTitle("Edit Touraments Page");
        editTouramentsStage.show();

    }


    @FXML
    void closeTourButIsClicked(ActionEvent event) {
        but1.setDisable(true);
        but2.setDisable(true);
        but3 .setDisable(true);
        l4.setText("The touraments have been closed");

    }

}
