import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import java.util.ArrayList;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

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
    
    /**
     * Constructor for objects of class MostAffectedBoroughsPanel
     */
    public AffectedBoroughsPanel()
    {
        process = new ProcessData();
    }
    private ArrayList<Label> stats = new ArrayList<>();
    
    private void addToArrList(){
        stats.add(rnrStat);
        stats.add(rnrStat);
        stats.add(rnrStat);
        stats.add(rnrStat);
        stats.add(rnrStat);
        stats.add(rnrStat);
        stats.add(rnrStat);
    }
    
    @FXML
    private void switchToStatistics() throws IOException{
        GUIManager.setRoot("Panel3");
    }
    
    @FXML
    private void switchToWelcome() throws IOException{
        GUIManager.setRoot("Panel1");
    }
    
    public void getHighestRnRGMR(int y)
    {
        int currentHighest = -1000000000;
        String borough = "";
        String date = "";
        for(CovidData data : process.getCovidDataArr()){
            if (data.getRetailRecreationGMR()> currentHighest){
                currentHighest = data.getRetailRecreationGMR();
                borough = data.getBorough();
                date = data.getDate();
            }
        }
        rnrStat.setText(""+ borough + "\n" + currentHighest + "\n" + date);
    }

    public void getHighestGnPGMR(int y)
    {
        int currentHighest = -1000000000;
        String borough = "";
        String date = "";
        for(CovidData data : process.getCovidDataArr()){
            if (data.getGroceryPharmacyGMR()> currentHighest){
                currentHighest = data.getGroceryPharmacyGMR();
                borough = data.getBorough();
                date = data.getDate();
            }
        }
        
    }
}
