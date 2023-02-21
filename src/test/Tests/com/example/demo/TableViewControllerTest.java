package com.example.demo;

import org.junit.jupiter.api.Test;

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
        tableViewController.workersList.add(new Workers(WorkerRead.workerReadList()));
    }
    @Test
    void initData_TableBlank(){
        tableViewController.workersList.filtered(n -> tableViewController.workersList.toString().isBlank());
    }
    @Test
    void initData_Follow_comeWorkerTableController(){
        tableViewController.workersList.equals(tableViewController.comeWorkerTableController);
    }
}