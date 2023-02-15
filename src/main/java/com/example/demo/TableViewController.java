package com.example.demo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker;
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

    ObservableList<Workers> workersList = FXCollections.observableArrayList();
    ComeWorkerTableController comeWorkerTableController = new ComeWorkerTableController();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Workers> FactoryTable;

    @FXML
    private TableColumn<?,?> NameWorker;

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
    void initialize() {
        initData();

        NameWorker.setCellValueFactory(new PropertyValueFactory<>("NameWorker"));
        PostWorker.setCellValueFactory(new PropertyValueFactory<>("PostWorker"));
        YearWorker.setCellValueFactory(new PropertyValueFactory<>("YearWorker"));
        WorkShop.setCellValueFactory(new PropertyValueFactory<>("WorkShop"));

        FactoryTable.setItems(workersList);
    }
    public void initData() {
        workersList.add(new Workers("Банщиков Алексей Олегович", "1980", "Технолог", "Котельный цех"));
        workersList.add(new Workers("Самарскй Егор Игоревич", "1977", "Технолог", "Котельный цех"));
        workersList.add(new Workers("Килин Денис Иванович", "1973", "Слесарь", "Котельный цех"));
        workersList.add(new Workers("Константинов Андрей Ильич", "1990", "Электрик", "Котельный цех"));
        workersList.add(new Workers("Юшин Евгений Андреевич", "1986", "Слесарь", "Котельный цех"));
        workersList.add(new Workers("Иванов Максим Викторович", "1993", "Сварщик", "Котельный цех"));



            comeWorker.setOnAction(event -> {
                        comeWorker.getScene().getWindow();
                        comeWorkerTableController.bananaFicus();


            }

            );

        }
    }









