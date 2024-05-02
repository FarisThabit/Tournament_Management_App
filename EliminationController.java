package com.example.swe206project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class EliminationController {

    @FXML
    private Label l1;

    @FXML
    private Label l2;

    @FXML
    void backTournamentsPageIsClicked(ActionEvent event) throws IOException {

        Stage backTournamentsPage;
        Parent root = FXMLLoader.load(getClass().getResource("ShowTouramntsController.fxml"));
        Scene rASce = new Scene(root);
        backTournamentsPage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        backTournamentsPage.setScene(rASce);
        backTournamentsPage.setResizable(false);
        backTournamentsPage.show();

    }


}
