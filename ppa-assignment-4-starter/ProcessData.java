/**
 * Write a description of class ProcessData here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.ArrayList;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TableView;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class ProcessData{
    
    private HandleClick circleClick;
    private CovidDataLoader covidDataLoader;
    private ArrayList<CovidData> Coviddata;
    private ObservableList<CovidData> observeList = FXCollections.observableArrayList();
    
    public ProcessData(){
        circleClick = new HandleClick();
        covidDataLoader = new CovidDataLoader();
        Coviddata = covidDataLoader.load();
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
                observeList.add(key);
            }
        }
        return observeList;
    }
    
}
