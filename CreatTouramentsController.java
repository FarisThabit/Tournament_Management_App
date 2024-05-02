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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CreatTouramentsController {
    ArrayList<Tournaments> tourArr = new ArrayList<>();
    File infile = new File("C:\\Users\\mhaah\\Desktop\\semester 222\\SWE-206\\Labs\\LabProject\\Phase 3\\SWE-206 Project\\src\\main\\java\\com\\example\\swe206project\\TourmentsDataBase.txt");

    @FXML
    private AnchorPane aPL;

    @FXML
    private BorderPane bPADB;

    @FXML
    private AnchorPane bPR;

    @FXML
    private Button but2;

    @FXML
    private Button butt1;

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
    private TextField tF4;

    @FXML
    private TextField tf3;

    @FXML
    private TextField tF5;

    @FXML
    private Label l7;

    @FXML
    private Label l8;



    @FXML
    void addIsClicked(ActionEvent event) throws FileNotFoundException {
        if(tF1.getText().isEmpty() || tF2.getText().isEmpty()||tf3.getText().isEmpty()||tF4.getText().isEmpty()){
            l4.setText("Fill all the info before you click add");
        }
        else{
            Scanner sc = new Scanner(infile);
            while (sc.hasNext()){
                sc.useDelimiter(",|\n");
                String name = sc.next();
                String type = sc.next();
                String teamType = sc.next();
                int capacity = Integer.parseInt(sc.next());
                String date = sc.next();
                Tournaments tournament = new Tournaments(name,type,teamType,capacity,date);
                tourArr.add(tournament);
            }
            int tf33 = Integer.parseInt(tf3.getText());
            Tournaments tournament = new Tournaments(tF1.getText(), tF2.getText(), tF5.getText(),tf33, tF4.getText());
            tourArr.add(tournament);
            PrintWriter pw = new PrintWriter(infile);
            for(int i = 0; i<tourArr.size(); i++){
                pw.println(tourArr.get(i).toString());
            }
            pw.close();

            l6.setText("The tourament has been created" );


        }


    }

    @FXML
    void homeIsClicked(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AdminDashBoardController.fxml"));
        Stage mainPageStage;
        mainPageStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene mainPageSce = new Scene(root);
        mainPageStage.setScene(mainPageSce);
        mainPageStage.setResizable(false);
        mainPageStage.show();
    }



}
