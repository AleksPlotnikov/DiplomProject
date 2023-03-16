package VacantList;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.demo.TableViewController;
import WriteAndWorkingClasses.WorkerWrite;
import com.example.demo.Workers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class VacantListController {
    public static ObservableList<Workers> vacantList = FXCollections.observableArrayList(WorkerVacantRead.workerReadVacantList());
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Workers> FactoryVacant;

    @FXML
    private TableColumn<?, ?> NameWorkerVacant;

    @FXML
    private TableColumn<?, ?> PostWorkerVacant;

    @FXML
    private TableColumn<?, ?> WorkShopVacant;

    @FXML
    private TableColumn<?, ?> YearWorkerVacant;

    @FXML
    private Button ReturnFromVacant;

    @FXML
    void initialize() {
        returnFromVacant();
        initData();
        NameWorkerVacant.setCellValueFactory(new PropertyValueFactory<>("NameWorker"));
        PostWorkerVacant.setCellValueFactory(new PropertyValueFactory<>("PostWorker"));
        YearWorkerVacant.setCellValueFactory(new PropertyValueFactory<>("YearWorker"));
        WorkShopVacant.setCellValueFactory(new PropertyValueFactory<>("WorkShop"));


        FactoryVacant.setItems(vacantList);

    }

    public void initData(){

    }

    public void returnFromVacant(){
        ReturnFromVacant.setOnAction(event -> {
            Workers worker = FactoryVacant.getSelectionModel().getSelectedItem();
            TableViewController.workersList.add(worker);
            FactoryVacant.getItems().remove(worker);
            WorkerVacantWrite.WorkerVacantWriterList();
            WorkerWrite.WorkerWriterList();
        });
    }


}