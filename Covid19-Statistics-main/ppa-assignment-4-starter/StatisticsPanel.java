
/**
 * Write a description of class StatisticsPanel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import java.util.ArrayList;
import javafx.scene.control.Label;
import javafx.scene.control.Button;


public class StatisticsPanel{
    
    private ProcessData process;
    @FXML private Label Statistic_Name;
    @FXML private Label Statistic;
    @FXML private Button prevButton;
    @FXML private Button nextButton;
    int statNumber = -1;
    
    public StatisticsPanel(){
        process = new ProcessData();
    }
    
    @FXML
    private void switchToBorough() throws IOException{
        GUIManager.setRoot("Panel2");
    }
    
    @FXML
    private void switchToAffectedBoroughs() throws IOException{
        GUIManager.setRoot("Panel4");
    }
    
    
    public void changeData(){
        if (statNumber == 0){
            Statistic.setText(String.valueOf(calclulateTotalDeaths()));
            Statistic_Name.setText("Total Number of Deaths\n(within time period)");
        }
        
        else if (statNumber == 1){
            Statistic.setText(String.valueOf(averageTotalCases()));
            Statistic_Name.setText("Average Total Cases\n(for a single borough)");
        }
        
        else if (statNumber == 2){
            Statistic.setText(String.valueOf(highestTotalDeaths()));
            Statistic_Name.setText("Date with Highest Total Deaths");
        }
        else if (statNumber == 3){
            Statistic.setText(String.valueOf(averageParks()));
            Statistic_Name.setText("Average of ParksGMR");
        }
        else if (statNumber == 4){
            Statistic.setText(String.valueOf(averageTransitStations()));
            Statistic_Name.setText("Average of TransitStationsGMR");
        }
        
        else if (statNumber > 4){
            statNumber = 0;
            changeData();
        }
        
        else{
            statNumber = 4;
            changeData();
        }
    }
    
    public void nextData(){
        statNumber +=1;
        changeData();
    }
    
    public void prevData(){
        statNumber -=1;
        changeData();
    }
    
    public int calclulateTotalDeaths(){
        int toDeaths = 0;
        int fromDeaths = 0;
        for(CovidData data : process.getCovidDataArr()){
            if(data.getDate().equals(process.getFromDate())){
                fromDeaths += data.getTotalDeaths();
            }
            
            if(data.getDate().equals(process.getToDate())){
                toDeaths += data.getTotalDeaths();
            }
        }
        return toDeaths - fromDeaths;
    }
    
    public double averageTotalCases(){
        int toCases = 0;
        int fromCases = 0;
        for(CovidData data : process.getCovidDataArr()){
            if(data.getDate().equals(process.getFromDate())){
                fromCases += data.getTotalCases();
            }
            
            if(data.getDate().equals(process.getToDate())){
                toCases += data.getTotalCases();
            }
        }
        return (toCases - fromCases)/33;
    }
    
    public String highestTotalDeaths(){
        return process.getToDate();
    }
    
    public double averageParks(){
        int total =0;
        int count = 0;
        for(CovidData key : process.getCovidDataArr()){
            if(!(process.convertDate(key.getDate()).before(process.convertDate(process.getFromDate())) || process.convertDate(key.getDate()).after(process.convertDate(process.getToDate())))){
                total += key.getParksGMR();
                count +=1;
            }
        }
        return total/count;
    }
    
    public int averageTransitStations(){
        int total =0;
        int count = 0;
        for(CovidData key : process.getCovidDataArr()){
            if(!(process.convertDate(key.getDate()).before(process.convertDate(process.getFromDate())) || process.convertDate(key.getDate()).after(process.convertDate(process.getToDate())))){
                total += key.getTransitGMR();
                count +=1;
            }
        }
        return total/count;
    }
}
