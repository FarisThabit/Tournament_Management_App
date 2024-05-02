package com.example.swe206project;

        import javafx.collections.FXCollections;
        import javafx.collections.ObservableList;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;
        import javafx.scene.control.TableColumn;
        import javafx.scene.control.TableView;
        import javafx.scene.control.cell.PropertyValueFactory;
        import javafx.stage.Stage;

        import java.io.BufferedReader;
        import java.io.FileReader;
        import java.io.IOException;

public class ShowTouramentsController {

    @FXML
    private TableColumn<Tournaments, Integer> capacity;

    @FXML
    private TableColumn<Tournaments, String> date;

    @FXML
    private Label l1;

    @FXML
    private Label l2;

    @FXML
    private TableColumn<Tournaments, Button> matches;

    @FXML
    private TableColumn<Tournaments, String> name;

    @FXML
    private TableView<Tournaments> tableView;

    @FXML
    private TableColumn<Tournaments, String> teamType;

    @FXML
    private TableColumn<Tournaments, String> type;

    @FXML
    void backMainPageIsClicked(ActionEvent event) throws IOException {

        Stage backMainPage;
        Parent root = FXMLLoader.load(getClass().getResource("MainPageController.fxml"));
        Scene rASce = new Scene(root);
        backMainPage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        backMainPage.setScene(rASce);
        backMainPage.setResizable(false);
        backMainPage.show();
    }

    @FXML
    void RoundRobinIsClicked(ActionEvent event) throws IOException {

        Stage backMainPage;
        Parent root = FXMLLoader.load(getClass().getResource("RoundRobinController.fxml"));
        Scene rASce = new Scene(root);
        backMainPage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        backMainPage.setScene(rASce);
        backMainPage.show();
    }

    @FXML
    void EliminationIsClicked(ActionEvent event) throws IOException {

        Stage backMainPage;
        Parent root = FXMLLoader.load(getClass().getResource("EliminationController.fxml"));
        Scene rASce = new Scene(root);
        backMainPage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        backMainPage.setScene(rASce);
        backMainPage.setResizable(false);
        backMainPage.show();
    }


    public void initialize() {

        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        teamType.setCellValueFactory(new PropertyValueFactory<>("teamType"));
        capacity.setCellValueFactory(new PropertyValueFactory<>("capacity"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));

        ObservableList<Tournaments> data = FXCollections.observableArrayList();
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\mhaah\\Desktop\\semester 222\\SWE-206\\Labs\\LabProject\\Phase 3\\SWE-206 Project\\src\\main\\java\\com\\example\\swe206project\\TourmentsDataBase.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                int capacity = Integer.parseInt(values[3]);
                Tournaments d = new Tournaments(values[0], values[1], values[2], capacity, values[4]);
                data.add(d);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        tableView.setItems(data);
    }

}
