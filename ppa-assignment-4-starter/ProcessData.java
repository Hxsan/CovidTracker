import java.util.ArrayList;
import javafx.scene.input.MouseEvent;

/**
 * Write a description of class ProcessData here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ProcessData{
    
    private HandleClick circleClick = new HandleClick();
    private CovidDataLoader covidDataLoader = new CovidDataLoader();
    private ArrayList<CovidData> Coviddata;
    
    public ProcessData(){
        Coviddata = covidDataLoader.load();
    }
    
    public String getFxidString(MouseEvent event){
        return circleClick.getObjectId(event);
    }
    
    public void handleData(MouseEvent event){
        int count = 0;
        for(CovidData key : Coviddata){
            if(key.getBorough().equals(getFxidString(event))){
                count++;
                System.out.println(key);
            }
        }
        System.out.println(count);
    }
}
