package com.example.viewbindingtest;

import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class DataManager {
    private static DataManager dataManager = new DataManager();
    private ArrayList<CarInfo> carList;

    private DataManager() {
        carList = makeCarList();
    }

    public ArrayList<CarInfo> getCarList() {
        return carList;
    }

    public static DataManager GetInstance(){
        return dataManager;
    }
    private static ArrayList<CarInfo> makeCarList(){
        ArrayList<CarInfo> cars = new ArrayList<>();

        cars.add(new CarInfo("2010 Ford","5000","160000","REBUILD",R.drawable.ford));
        cars.add(new CarInfo("2016 Dodge","10000","160000","Engine Trouble",R.drawable.dodge));
        cars.add(new CarInfo("2013 Honda","3000","213000","Still runs well",R.drawable.honda));
        cars.add(new CarInfo("2012 Nissan","8000","100000","Needs new tired",R.drawable.nissan));
        cars.add(new CarInfo("2011 Toyota","5000","80000","Rust on the sides",R.drawable.toyota));

        return cars;
    }
}
