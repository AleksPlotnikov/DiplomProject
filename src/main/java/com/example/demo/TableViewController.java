package com.example.demo;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

import VacantList.VacantListController;
import VacantList.WorkerVacantWrite;
import WriteAndWorkingClasses.WorkerRead;
import WriteAndWorkingClasses.WorkerWrite;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import static WriteAndWorkingClasses.WriteAllWorkersTXT.writeAllWorkers;

public class TableViewController{

    public static ObservableList<Workers> workersList = FXCollections.observableArrayList(WorkerRead.workerReadList());
    ComeWorkerTableController comeWorkerTableController = new ComeWorkerTableController();

    public static ObservableList<Workers> workerVacantList = FXCollections.observableArrayList();
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
    private Button closeButton;
    @FXML
    private TextField searchBox;
    @FXML
    private Button searchButton;

    @FXML
    private Button sendOnVacationButton;

    @FXML
    private Button VacantList;

    @FXML
    private Button WriteAllWorkers;

    @FXML
    void initialize() {                                             // Метод формирующий данные в таблице.
        writeAllWorkers();
        searchWorker();
        cleanSearchBox();
        initData();
        sendWorkerVacantList();
        NameWorker.setCellValueFactory(new PropertyValueFactory<>("NameWorker"));
        PostWorker.setCellValueFactory(new PropertyValueFactory<>("PostWorker"));
        YearWorker.setCellValueFactory(new PropertyValueFactory<>("YearWorker"));
        WorkShop.setCellValueFactory(new PropertyValueFactory<>("WorkShop"));

        FactoryTable.setItems(workersList);
    }

    public void initData() {                                       // Метод позволяющий отображать работников в таблице.
        showVacantListMethod();
        comeWorkerMethod();
        removeWorker();
        sendWorkerVacantList();
        writeAllWorkersTXT();
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

    private void showVacantListMethod(){                                 // Метод показывающий таблицу отпусков.
        VacantList.setOnAction(event -> {
                    VacantList.getScene().getWindow();
                    FXMLLoader loaderComeWorker = new FXMLLoader();
                    loaderComeWorker.setLocation(getClass().getResource("VacantList.fxml"));
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

        private void sendWorkerVacantList(){                                // Метод отправляющий работника в список отпусков.
        sendOnVacationButton.setOnAction(event -> {
                Workers worker = FactoryTable.getSelectionModel().getSelectedItem();
            VacantListController.vacantList.add(worker);
                FactoryTable.getItems().remove(worker);
                WorkerVacantWrite.WorkerVacantWriterList();
                WorkerWrite.WorkerWriterList();
        });
        }

        public void writeAllWorkersTXT(){                                   // Метод для распечатки работников в текстовый документ.
        WriteAllWorkers.setOnAction(event -> {
            writeAllWorkers();
        });
        }

        private void cleanSearchBox() {                                     // Метод очищающий поисковую строку
            closeButton.setOnAction(event -> {
                searchBox.clear();
            });
        }
        private void searchWorker(){                                        // Метод должен искать работнов в table view
            searchButton.setOnAction(event -> {
                if(workersList.contains(searchBox.getText())){


                }
//                else if(searchBox.getText().isEmpty()){
//                    searchBox.setText("Введите имя");
//                }
//                else if(!NameWorker.getText().contains(searchBox.getText())){
//                    searchBox.setText("Таких работников нет");
//
//                }
            });
        }
    }










