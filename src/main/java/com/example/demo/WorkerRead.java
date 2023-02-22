package com.example.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class WorkerRead {
    public static ArrayList<Workers> workerReadList() {

        FileInputStream fis = null;
        ObjectInputStream ois = null;
        ArrayList <Workers> worker;
        try {
            fis = new FileInputStream("WorkerFile");
            ois = new ObjectInputStream(fis);
           worker = (ArrayList<Workers>) ois.readObject();


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fis.close();
                ois.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return worker;
    }
}
