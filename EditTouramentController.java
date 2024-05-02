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
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class EditTouramentController {


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
    private TextField tF2;

    @FXML
    private TextField tF3;

    @FXML
    private TextField tF4;

    @FXML
    private TextField tF5;

    @FXML
    private TextField tF6;

    @FXML
    private Label l11;



    @FXML
    void editButtClicked(ActionEvent event)throws FileNotFoundException {
        Boolean touramentExist = false;
        Boolean Update = false;
        int count = 0;
        ArrayList<Tournaments> tourArr = new ArrayList<Tournaments>();
        File infile = new File("C:\\Users\\mhaah\\Desktop\\semester 222\\SWE-206\\Labs\\LabProject\\Phase 3\\SWE-206 Project\\src\\main\\java\\com\\example\\swe206project\\TourmentsDataBase.txt");
        Scanner sc = new Scanner(infile);
        sc.useDelimiter(",|\n");
        while(sc.hasNext()){
            String tempInfo = sc.next();
            if(count%5 == 0 && tF1.getText().equals(tempInfo)){
                touramentExist = true;
                System.out.println(1);
            }
            count++;
        }
        if(touramentExist){
            Scanner nsc = new Scanner(infile);
            nsc.useDelimiter(",|\n");
            while (nsc.hasNext()){
                String name = nsc.next();
                if(name.equals(tF1.getText())){
                    String type = nsc.next();
                    String teamType = nsc.next();
                    int capacity = Integer.parseInt(nsc.next());
                    String dueDate = nsc.next();

                    if(tF2.getText().isEmpty()){}
                    else{
                        name = tF2.getText();
                    }
                    if(tF3.getText().isEmpty()){}
                    else{
                        type = tF3.getText();
                    }
                    if(tF4.getText().isEmpty()){}
                    else{
                        teamType = tF4.getText();
                    }
                    if(tF5.getText().isEmpty()){}
                    else{
                        capacity = Integer.parseInt(tF5.getText());
                    }
                    if(tF6.getText().isEmpty()){}
                    else{
                        dueDate = tF6.getText();
                    }
                    Tournaments tempTour = new Tournaments(name,type,teamType,capacity,dueDate);
                    tourArr.add(tempTour);
                    Update = true;


                }
                else{
                    Tournaments tempTour = new Tournaments(name,nsc.next(), nsc.next(),Integer.parseInt(nsc.next()),nsc.next());
                    tourArr.add(tempTour);

                }
            }

        }
        else{
            l10.setText("The provided tourment does not exist");
        }
        if(Update){
            PrintWriter pw = new PrintWriter(infile);
            for(int i = 0; i<tourArr.size();i++){
                pw.println(tourArr.get(i));
            }
            pw.close();
            l10.setText("The provided tourament has been edited");

        }

    }
    @FXML
    void adminDashButtIsClicked(ActionEvent event)throws IOException {
       Parent root = FXMLLoader.load(getClass().getResource("AdminDashBoardController.fxml"));
        Stage adminDashBoardStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene adminDashboardsce = new Scene(root);
        adminDashBoardStage.setScene(adminDashboardsce);
        adminDashBoardStage.setResizable(false);
        adminDashBoardStage.show();
    }


}
