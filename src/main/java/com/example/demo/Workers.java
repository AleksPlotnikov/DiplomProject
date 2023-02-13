package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Workers {
    private String NameWorker;
    private String YearWorker;
    private String PostWorker;
    private String WorkShop;


    public Workers(String nameWorker, String yearWorker, String postWorker, String workShop) {
        NameWorker = nameWorker;
        YearWorker = yearWorker;
        PostWorker = postWorker;
        WorkShop = workShop;
    }



    public Workers() {
    }


    public String getNameWorker() {
        return NameWorker;
    }

    public void setNameWorker(String NameWorker) {
        NameWorker = NameWorker;
    }

    public String getYearWorker() {
        return YearWorker;
    }

    public void setYearWorker(String yearWorker) {
        YearWorker = yearWorker;
    }

    public String getPostWorker() {
        return PostWorker;
    }

    public void setPostWorker(String postWorker) {
        PostWorker = postWorker;
    }

    public String getWorkShop() {
        return WorkShop;
    }

    public void setWorkShop(String workShop) {
        WorkShop = workShop;
    }

}


