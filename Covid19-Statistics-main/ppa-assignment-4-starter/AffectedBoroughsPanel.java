import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import java.util.ArrayList;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import java.util.HashMap;

/**
 * Write a description of class MostAffectedBoroughsPanel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AffectedBoroughsPanel
{
    private ProcessData process;
    
    @FXML private Label rnrStat;
    @FXML private Label gnpStat;
    @FXML private Label pStat;
    @FXML private Label tsStat;
    @FXML private Label wStat;
    @FXML private Label rStat;
    @FXML private Label ncStat;
    @FXML private Label tcStat;
    @FXML private Label ndStat;
    @FXML private Label tdStat;
    
    private ArrayList<Label> stats = new ArrayList<>();
    
    @FXML
    public void initialize(){
        getStats();
    }
    
    /**
     * Constructor for objects of class MostAffectedBoroughsPanel
     */
    public AffectedBoroughsPanel()
    {
        process = new ProcessData();
        
        stats.add(rnrStat);
        stats.add(gnpStat);
        stats.add(pStat);
        stats.add(tsStat);
        stats.add(wStat);
        stats.add(rStat);
        stats.add(ncStat);
        stats.add(ncStat);
        stats.add(ndStat);
    }

    
    @FXML
    private void switchToStatistics() throws IOException{
        GUIManager.setRoot("Panel3");
    }
    
    @FXML
    private void switchToWelcome() throws IOException{
        GUIManager.setRoot("Panel1");
    }
    
    public void getHighestRnR()
    {
        int currentHighest = -1000000000;
        String borough = "";
        String date = "";
        for(CovidData data : process.getCovidDataArr()){
            if (data.getRetailRecreationGMR() > currentHighest){
                currentHighest = data.getRetailRecreationGMR();
                borough = data.getBorough();
                date = data.getDate();
            }
        }
        rnrStat.setText(""+ borough + "\n" + currentHighest + "\n" + date);
    }
    
    public void getStats()
    {
        int currentHighest = -100000000;
        String borough = "";
        String date = "";
        
        
        for(Label stat : stats){
            for(CovidData data : process.getCovidDataArr()){
                if(!(process.convertDate(data.getDate()).before(process.convertDate(process.getFromDate())) || process.convertDate(data.getDate()).after(process.convertDate(process.getToDate())))){
                    if(data.chooseStat(stat) > currentHighest){
                        currentHighest = data.chooseStat(stat);
                        borough = data.getBorough();
                        date = data.getDate();
                    }
                }
                stat.setText(""+ borough + "\n" + currentHighest + "\n" + date);
                
                currentHighest = -100000000;
                borough = "";
                date = "";
            }
        }
    }
}
