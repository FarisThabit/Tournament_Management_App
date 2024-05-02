package com.example.swe206project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class AdminController {

    ArrayList<Admin> admArr = new ArrayList<Admin>();
    File inFile = new File("C:\\Users\\mhaah\\Desktop\\semester 222\\SWE-206\\Labs\\LabProject\\Phase 3\\SWE-206 Project\\src\\main\\java\\com\\example\\swe206project\\AdminDataBase.txt");

    int count = 0;

    @FXML
    private BorderPane bPadmin;

    @FXML
    private Button but1;

    @FXML
    private Label l1;

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
    private TextField tF1;

    @FXML
    private TextField tF2;

    @FXML
    private TextField tF3;



    @FXML
    void adminLoginIsClicked(ActionEvent event) throws FileNotFoundException, IOException {
        if (tF1.getText().isEmpty()  || tF2.getText().isEmpty()  || tF3.getText().isEmpty()) {
            l6.setText("Complete your info before you click login");
        } else {

            Scanner sc = new Scanner(inFile);
            sc.useDelimiter(",|\n");
            while (sc.hasNext()) {
                String name = sc.next();
                int id = Integer.parseInt(sc.next());
                String email = sc.next();
                Admin admin = new Admin(name, id, email);
                admArr.add(admin);
            }

            int tF22 = Integer.parseInt(tF2.getText());
            Admin admin = new Admin(tF1.getText(), tF22, tF3.getText());
            admArr.add(admin);
            PrintWriter pw = new PrintWriter(inFile);
            for (int i = 0; i < admArr.size(); i++) {
                pw.println(admArr.get(i).toString());


            }
            pw.close();
            Parent root = FXMLLoader.load(getClass().getResource("AdminDashBoardController.fxml"));
            Stage adminDashBoardStage;
            adminDashBoardStage = (Stage)((Node) event.getSource()).getScene().getWindow();
            Scene adminDashBoardSce = new Scene(root);
            adminDashBoardStage.setScene(adminDashBoardSce);
            adminDashBoardStage.setTitle("Admin DashBoard");
            adminDashBoardStage.setResizable(false);
            adminDashBoardStage.show();

        }
    }
}

