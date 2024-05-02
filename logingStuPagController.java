package com.example.swe206project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class logingStuPagController {

    @FXML
     TextField userName;
    @FXML

    TextField passWord;
    @FXML
    Label erorrfiled;
    @FXML
    private  Label stuName;
    @FXML
    private  Label userName1;




    @FXML
    private  void loging(ActionEvent event) throws IOException {
        try {
            logIn(userName.getText(), passWord.getText());

            Parent root = FXMLLoader.load(getClass().getResource("StudentProfile.fxml"));
            Stage StudentProfile;
            StudentProfile = (Stage)((Node) event.getSource()).getScene().getWindow();
            Scene adminDashBoardSce = new Scene(root);
            StudentProfile.setScene(adminDashBoardSce);
            StudentProfile.setTitle("Student Profile");
            StudentProfile.setResizable(false);
            this.getStuInfo();
            StudentProfile.show();
        }
        catch (Exception e) {
        erorrfiled.setText("Error:UserName or PasWord is not correct");
        }


    }
    private void getStuInfo() throws FileNotFoundException {
        Scanner myReader = new Scanner(new File("D:/SWELab206/The Project/SWE-206 Project/src/main/java/com/example/swe206project/Studentdetiles.txt"));
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            String[] arrOfStr = data.split(",");
            if(arrOfStr[0].equals(getUserName()) && arrOfStr[1].equals(getPassWord()) ){
                this.stuName.setText((arrOfStr[4] + arrOfStr[5]));
               this.userName1.setText(arrOfStr[0]);
                myReader.close();
                //return info;
            }
            myReader.nextLine();

        }
        //return new String[0];
    }

    public  String getPassWord() {
        return passWord.getText();
    }

    public String getUserName() {
        return userName.getText();
    }

    private static URI buildUri(String url, String key, String value) {
        try {
            if (url.charAt(url.length() - 1) != '?') {
                return new URI(url + "&" + key + "=" + value);
            }
            return new URI(url + key + "=" + value);
        } catch (Exception e) {
            return null;
        }

    }

    public static Map<String, String> logIn(String user, String password) throws Exception {
        String urlString = "https://us-central1-swe206-221.cloudfunctions.net/app/UserSignIn?";
        URI temp = buildUri(urlString, "username", user);
        temp = buildUri(temp.toString(), "password", password);
        Map<String, String> returnMap = new HashMap<>();

        URL url;
        try {
            url = temp.toURL();
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("GET");
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);
            int status = con.getResponseCode();
            if (status != 200)
                throw new Exception("invalid Credentials");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return returnMap;
    }


    @FXML
    private  void welcome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainPageController.fxml"));
        Stage StudentProfile;
        StudentProfile = (Stage)((Node) event.getSource()).getScene().getWindow();
        Scene adminDashBoardSce = new Scene(root);
        StudentProfile.setScene(adminDashBoardSce);
        StudentProfile.setTitle("Student Profile");
        StudentProfile.setResizable(false);
        StudentProfile.show();
    }



}
