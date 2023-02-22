package com.example.demo;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class TableViewController {

    static ObservableList<Workers> workersList = FXCollections.observableArrayList(WorkerRead.workerReadList());
    ComeWorkerTableController comeWorkerTableController = new ComeWorkerTableController();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Workers> FactoryTable;

    @FXML
    private TableColumn<?, ?> NameWorker;

    @FXML
    private TableColumn<?, ?> PostWorker;

    @FXML
    private TableColumn<?, ?> WorkShop;

    @FXML
    private TableColumn<?, ?> YearWorker;

    @FXML
    private Button comeWorker;

    @FXML
    private Button removeWorker;

    @FXML
    void initialize() {                                             // Метод формирующий данные в таблице.

        initData();

        NameWorker.setCellValueFactory(new PropertyValueFactory<>("NameWorker"));
        PostWorker.setCellValueFactory(new PropertyValueFactory<>("PostWorker"));
        YearWorker.setCellValueFactory(new PropertyValueFactory<>("YearWorker"));
        WorkShop.setCellValueFactory(new PropertyValueFactory<>("WorkShop"));

        FactoryTable.setItems(workersList);
    }
    public void initData() {                                       // Метод позволяющий отображать работников в таблице.

        comeWorkerMethod();
        removeWorker();
    }
    private void comeWorkerMethod() {                                  // Метод вызывающий меню для приема работника.
        comeWorker.setOnAction(event -> {
                    comeWorker.getScene().getWindow();
                    FXMLLoader loaderComeWorker = new FXMLLoader();
                    loaderComeWorker.setLocation(getClass().getResource("comeWorkerTable.fxml"));
                    try {
                        loaderComeWorker.load();

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    Parent root = loaderComeWorker.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.showAndWait();
        }
        );
    }
    private void removeWorker() {                                            // Метод удаляющий работника из таблицы.
        removeWorker.setOnAction(event1 -> {
                    int worker = FactoryTable.getSelectionModel().getSelectedIndex();
                    FactoryTable.getItems().remove(worker);
                    WorkerWrite.WorkerWriterList();
        }
        );
    }
}










