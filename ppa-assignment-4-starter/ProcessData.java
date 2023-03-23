import java.util.ArrayList;

/**
 * Write a description of class ProcessData here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ProcessData{
    private CovidDataLoader covidDataLoader = new CovidDataLoader();
    private ArrayList<CovidData> Coviddata;
    
    public ProcessData(){
        Coviddata = covidDataLoader.load();
    }
    
    public void handleData(){
        int count = 0;
        for(CovidData key : Coviddata){
            if(key.getBorough().equals("Camden")){
                count++;
                System.out.println(key.getDate());
            }
        }
        System.out.println(count);
    }
}
