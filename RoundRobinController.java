package com.example.swe206project;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RoundRobinController {

    @FXML
    private TableColumn<RoundRobin, Integer> Draws;

    @FXML
    private TableColumn<RoundRobin, String> FifthRound;

    @FXML
    private TableColumn<RoundRobin, String> FirstRound;

    @FXML
    private TableColumn<RoundRobin, String> FourthRound;

    @FXML
    private TableColumn<RoundRobin, Integer> Losses;

    @FXML
    private TableView<RoundRobin> tableView;

    @FXML
    private Button NextTournament;

    @FXML
    private Button PreviousTournament;

    @FXML
    private TableColumn<RoundRobin, Integer> Score;

    @FXML
    private TableColumn<RoundRobin, String> SecoundRound;

    @FXML
    private TableView<RoundRobin> SecoundTable;

    @FXML
    private TableColumn<RoundRobin, String> Team;

    @FXML
    private TableColumn<RoundRobin, String> ThirdRound;

    @FXML
    private TableColumn<RoundRobin, String> Tournament;

    @FXML
    private TableColumn<RoundRobin, Integer> Wins;

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

    private List<RoundRobin> Matches = new ArrayList<>();

    private int currentLineIndex = 0;

    public void initialize() {

        Tournament.setCellValueFactory(new PropertyValueFactory<>("Tournament"));
        Team.setCellValueFactory(new PropertyValueFactory<>("Team"));
        Wins.setCellValueFactory(new PropertyValueFactory<>("Wins"));
        Losses.setCellValueFactory(new PropertyValueFactory<>("Losses"));
        Draws.setCellValueFactory(new PropertyValueFactory<>("Draws"));
        Score.setCellValueFactory(new PropertyValueFactory<>("Score"));

        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\mhaah\\Desktop\\semester 222\\SWE-206\\Labs\\LabProject\\Phase 3\\SWE-206 Project\\src\\main\\java\\com\\example\\swe206project\\Newahmed.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {

                List<String> Tournament = new ArrayList<>();
                List<String> Team = new ArrayList<>();
                List<Integer> Wins = new ArrayList<>();
                List<Integer> Losses = new ArrayList<>();
                List<Integer> Draws = new ArrayList<>();
                List<Integer> Score = new ArrayList<>();

                String[] parts = line.split("\\], \\[");
                Tournament.addAll(Arrays.asList(parts[0].replace("[", "").split(", ")));
                Team.addAll(Arrays.asList(parts[1].split(", ")));
                for (String s : parts[2].split(", ")) {
                    Wins.add(Integer.parseInt(s));
                }
                for (String s : parts[3].split(", ")) {
                    Losses.add(Integer.parseInt(s));
                }
                for (String s : parts[4].split(", ")) {
                    Draws.add(Integer.parseInt(s));
                }
                for (String s : parts[5].replace("]", "").split(", ")) {
                    Score.add(Integer.parseInt(s));
                }
                RoundRobin tournament = new RoundRobin(Tournament, Team, Wins, Losses, Draws, Score);
                Matches.add(tournament);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        updateTableView();
    }

    public void updateTable() {

        List<RoundRobin> tournamentData = Collections.singletonList(Matches.get(currentLineIndex));

        Tournament.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<RoundRobin, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<RoundRobin, String> p) {
                return new SimpleStringProperty(p.getValue().getTournament().toString());
            }
        });

        Team.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<RoundRobin, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<RoundRobin, String> p) {
                return new SimpleStringProperty(p.getValue().getTeam().toString());
            }
        });

        Wins.setCellValueFactory(new PropertyValueFactory<RoundRobin, Integer>("Wins"));
        Losses.setCellValueFactory(new PropertyValueFactory<RoundRobin, Integer>("Losses"));
        Draws.setCellValueFactory(new PropertyValueFactory<RoundRobin, Integer>("Draws"));
        Score.setCellValueFactory(new PropertyValueFactory<RoundRobin, Integer>("Score"));

        // Add the columns to the table
        tableView.getColumns().clear();
        tableView.getColumns().addAll(Tournament, Team, Wins, Losses, Draws, Score);

        // Create the table data
        ObservableList<RoundRobin> tableData = FXCollections.observableArrayList();

        // Iterate over the rows of the tournament data and create a Tournament object for each row
        for (int i = 0; i < tournamentData.size(); i++) {
            List<List<String>> row = parseRow(tournamentData.get(i).toString());
            RoundRobin tournament = new RoundRobin(row.get(0), parsePlayers(row.get(1).toString()),
                    Collections.singletonList(Integer.parseInt(row.get(2).toString())), Collections.singletonList(Integer.parseInt(row.get(3).toString())),
                    Collections.singletonList(Integer.parseInt(row.get(4).toString())), Collections.singletonList(Integer.parseInt(row.get(5).toString())));
            tableData.add(tournament);
        }

        // Set the table data
        tableView.setItems(tableData);
    }

    private List<List<String>> parseRow(String rowText) {
        List<List<String>> row = new ArrayList<>();

        // remove the enclosing square brackets
        rowText = rowText.substring(1, rowText.length() - 1);

        // split the row into 6 smaller lists
        String[] listStrings = rowText.split("], \\[");

        // parse each smaller list and add it to the row
        for (String listString : listStrings) {
            // add back the enclosing square brackets
            listString = "[" + listString + "]";
            List<String> list = parsePlayers(listString);
            row.add(list);
        }

        return row;
    }

    private List<String> parsePlayers(String playersText) {
        List<String> players = new ArrayList<>();

        // remove the enclosing square brackets
        playersText = playersText.substring(1, playersText.length() - 1);

        // split the player names by commas
        String[] playerNames = playersText.split(", ");

        // add each player name to the list of players
        for (String playerName : playerNames) {
            players.add(playerName);
        }

        return players;
    }

    @FXML
    public void onNextButtonClick() {
        currentLineIndex++;
        updateTableView();
    }

    @FXML
    public void onBackButtonClick() {
        currentLineIndex--;
        updateTableView();
    }
    private void updateTableView() {

        if (currentLineIndex == 0) {
            PreviousTournament.setDisable(true);
        } else {
            PreviousTournament.setDisable(false);
        }

        // Disable the "Next" button if we're at the end
        if (currentLineIndex == Matches.size() - 1) {
            NextTournament.setDisable(true);
        } else {
            NextTournament.setDisable(false);
        }

        // Update the TableView with the data for the current line
        tableView.setItems(FXCollections.observableArrayList(Matches.get(currentLineIndex)));
    }
}

