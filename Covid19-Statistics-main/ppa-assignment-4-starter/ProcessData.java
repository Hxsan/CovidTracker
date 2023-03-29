/**
 * Write a description of class ProcessData here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import javafx.scene.input.MouseEvent;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

import java.time.LocalDate;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ProcessData{
    private static String fromDate;
    private static String toDate;

    private DateFormat form = new SimpleDateFormat("yyyy-MM-dd");
    private Date formattedDate = null;
    
    private HandleClick circleClick;
    private CovidDataLoader covidDataLoader;
    private ArrayList<CovidData> Coviddata;
    private ObservableList<CovidData> observeList = FXCollections.observableArrayList();
    private HashMap<String, Integer> boroughData;
    
    public ProcessData(){
        circleClick = new HandleClick();
        covidDataLoader = new CovidDataLoader();
        Coviddata = covidDataLoader.load();
        boroughData = new HashMap<>();
    }
    
    public ArrayList<CovidData> getCovidDataArr(){
        return Coviddata;
    }
    
    public static String getFromDate(){
        return fromDate;
    }
    
    public static String getToDate(){
        return toDate;
    }
    
    public static void setFromDate(String date){
        fromDate = date;
    }
    
    public static void setToDate(String date){
        toDate = date;
    }
    
    
    public String getFxidString(MouseEvent event){
        String idName = circleClick.getObjectId(event);
        if(idName.contains("_") == true){
            idName = idName.replace("_", " "); 
        }
        return idName;
    }
    
    public ObservableList<CovidData> filterData(MouseEvent event){
        for(CovidData key : Coviddata){
            if(key.getBorough().equals(getFxidString(event))){
                if(!(convertDate(key.getDate()).before(convertDate(getFromDate())) || convertDate(key.getDate()).after(convertDate(getToDate())))){
                    observeList.add(key);
                }
            }
        }
        return observeList;
    }
    
    public HashMap<String, Integer> getTotalDeathsHashMap(){
        for(CovidData data : Coviddata){
            if(data.getDate().equals("2022-10-15")){
                boroughData.put(data.getBorough().replace(" ", "_"), data.getTotalDeaths());
            }
        }
        return boroughData;
    }
    
    public Date convertDate(String date){
        try{
            formattedDate = form.parse(date);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return formattedDate;
    }
}
