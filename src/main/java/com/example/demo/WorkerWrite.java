package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.example.demo.TableViewController.workersList;


public class WorkerWrite {
    public static void WorkerWriterList() {

        File file = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try{
            file = new File("WorkerFile");
            if(!file.exists()){
                file.createNewFile();
            }
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(new ArrayList<Workers>(workersList));
            oos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                fos.close();
                oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
