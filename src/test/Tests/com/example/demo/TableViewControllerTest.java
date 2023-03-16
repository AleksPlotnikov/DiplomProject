package com.example.demo;

import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;

class TableViewControllerTest {
    TableViewController tableViewController = new TableViewController();
    @Test
    void initialize() {
    }

    @Test
    void initData_Sort() {
        tableViewController.workersList.stream().sorted();
    }
    @Test
    void initData_AddWorkers(){
        tableViewController.workersList.add(new Workers());
    }
    @Test
    void initData_TableBlank(){
        tableViewController.workersList.filtered(n -> tableViewController.workersList.toString().isBlank());
    }
    @Test
    void initData_Follow_comeWorkerTableController(){
        tableViewController.workersList.equals(tableViewController.comeWorkerTableController);
    }
    @Test
    void WorkerWriterListIfNotNull(){
        FileWriter file = null;
        try {
            file = new FileWriter("WriteAllWorkers.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (file != null) {
            try {
                file.write(String.valueOf(file));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @Test
    void WorkerWriterListIfNull(){
        FileWriter file = null;
        try {
            file = new FileWriter("WriteAllWorkers.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(file == null){
            try{
                file.write(String.valueOf(file));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}