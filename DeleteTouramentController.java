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

public class DeleteTouramentController {
    ArrayList<Tournaments> tourArr = new ArrayList<>();
    File infile = new File("C:\\Users\\mhaah\\Desktop\\semester 222\\SWE-206\\Labs\\LabProject\\Phase 3\\SWE-206 Project\\src\\main\\java\\com\\example\\swe206project\\TourmentsDataBase.txt");

    @FXML
    private BorderPane bP;

    @FXML
    private Button but1;

    @FXML
    private Button but2;

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
    private Label l7;

    @FXML
    private Label l8;

    @FXML
    private Label l9;

    @FXML
    private Label l10;


    @FXML
    private TextField tF1;


    @FXML
    private Button but3;


    @FXML
    void deleteIsClicked(ActionEvent event)throws FileNotFoundException {
        Scanner sc = new Scanner(infile);
        sc.useDelimiter(",|\n");
        int count = 0;
        boolean courseFound = false;
        while(sc.hasNext()){
            String tempInfo = sc.next();
            if(count%5 == 0 && tF1.getText().equals(tempInfo)){
                courseFound = true;

            }
            count++;
        }
            if(courseFound){
                Scanner scn = new Scanner(infile);
                scn.useDelimiter(",|\n");
                while(scn.hasNext()){
                    String tempInfo2 = scn.next();
                    if(tF1.getText().equals(tempInfo2)){
                        String tourmeantName = tempInfo2;
                        String type = scn.next();
                        String teamType = scn.next();
                        int capacit =  Integer.parseInt(scn.next());
                        String dueDate = scn.next();

                    }
                    else{
                        Tournaments tournaments = new Tournaments(tempInfo2, scn.next(),scn.next(),Integer.parseInt(scn.next()),scn.next());
                        tourArr.add(tournaments);
                    }
                }
                PrintWriter pw = new PrintWriter(infile);
                for(int i = 0; i< tourArr.size();i++){
                    pw.println(tourArr.get(i));
                }
                pw.close();
                l10.setText("The tourment has been delated");

            }
            else{
                l9.setText("The provided tourment does not exist");
            }
        }




    @FXML
    void showTouramentsClicked(ActionEvent event)throws IOException {
        Stage showTuoramentsStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("ShowTouramntsController.fxml"));
        Scene showTuoramentsSce = new Scene(root);
        showTuoramentsStage.setScene(showTuoramentsSce);
        showTuoramentsStage.setResizable(false);
        showTuoramentsStage.show();
    }
    @FXML
    void adminDashBoardButtIsClicked(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AdminDashBoardController.fxml"));
        Stage adminDahsBoardStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene adminDashBoardSce = new Scene(root);
        adminDahsBoardStage.setScene(adminDashBoardSce);
        adminDahsBoardStage.setResizable(false);
        adminDahsBoardStage.show();
    }

}
