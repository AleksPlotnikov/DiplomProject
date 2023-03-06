package com.example.demo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ComeWorkerTableController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    protected TextField FactoryField;

    @FXML
    protected TextField NameField;

    @FXML
    protected TextField PostField;

    @FXML
    protected TextField YearField;

    @FXML
    protected Button comeWorkerButton;

    @FXML
    void initialize() {

        comeWorkerButton.setOnAction(event -> {
            TableViewController.workersList.add(new Workers(NameField.getText(),YearField.getText(),
                    PostField.getText(),FactoryField.getText()));
                        WorkerWrite.WorkerWriterList();
                        comeWorkerButton.getScene().getWindow().hide();
            }
            );
        }
}


