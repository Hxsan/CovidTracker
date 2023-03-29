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
        getHighestRnR();
        getHighestGnP();
        getHighestP();
        getHighestTS();
        getHighestW();
        getHighestR();
        getHighestNC();
        getHighestND();
        getHighestTC();
        getHighestTD();
        
        //getStats();
    }
    
    /**
     * Constructor for objects of class MostAffectedBoroughsPanel
     */
    public AffectedBoroughsPanel()
    {
        process = new ProcessData();
        
        /*
        stats.add(rnrStat);
        stats.add(gnpStat);
        stats.add(pStat);
        stats.add(tsStat);
        stats.add(wStat);
        stats.add(rStat);
        stats.add(ncStat);
        stats.add(ncStat);
        stats.add(ndStat);
        */
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
        int currentHighest = -100000000;
        String borough = "";
        String date = "";
        for(CovidData data : process.getCovidDataArr()){
            if(!(process.convertDate(data.getDate()).before(process.convertDate(process.getFromDate())) || process.convertDate(data.getDate()).after(process.convertDate(process.getToDate())))){
                if(data.getRetailRecreationGMR() > currentHighest){
                    currentHighest = data.getRetailRecreationGMR();
                    borough = data.getBorough();
                    date = data.getDate();
                }
            }
        }
        rnrStat.setText(""+ borough + "\n" + currentHighest + "\n" + date);
    }
    
    public void getHighestGnP()
    {
        int currentHighest = -100000000;
        String borough = "";
        String date = "";
        for(CovidData data : process.getCovidDataArr()){
            if(!(process.convertDate(data.getDate()).before(process.convertDate(process.getFromDate())) || process.convertDate(data.getDate()).after(process.convertDate(process.getToDate())))){
                if(data.getGroceryPharmacyGMR() > currentHighest){
                    currentHighest = data.getGroceryPharmacyGMR();
                    borough = data.getBorough();
                    date = data.getDate();
                }
            }
        }
        gnpStat.setText(""+ borough + "\n" + currentHighest + "\n" + date);
    }
    
    public void getHighestP()
    {
        int currentHighest = -100000000;
        String borough = "";
        String date = "";
        for(CovidData data : process.getCovidDataArr()){
            if(!(process.convertDate(data.getDate()).before(process.convertDate(process.getFromDate())) || process.convertDate(data.getDate()).after(process.convertDate(process.getToDate())))){
                if(data.getParksGMR() > currentHighest){
                    currentHighest = data.getParksGMR();
                    borough = data.getBorough();
                    date = data.getDate();
                }
            }
        }
        pStat.setText(""+ borough + "\n" + currentHighest + "\n" + date);
    }
    
    public void getHighestTS()
    {
        int currentHighest = -100000000;
        String borough = "";
        String date = "";
        for(CovidData data : process.getCovidDataArr()){
            if(!(process.convertDate(data.getDate()).before(process.convertDate(process.getFromDate())) || process.convertDate(data.getDate()).after(process.convertDate(process.getToDate())))){
                if(data.getTransitGMR() > currentHighest){
                    currentHighest = data.getTransitGMR();
                    borough = data.getBorough();
                    date = data.getDate();
                }
            }
        }
        tsStat.setText(""+ borough + "\n" + currentHighest + "\n" + date);
    }
    
    public void getHighestW()
    {
        int currentHighest = -100000000;
        String borough = "";
        String date = "";
        for(CovidData data : process.getCovidDataArr()){
            if(!(process.convertDate(data.getDate()).before(process.convertDate(process.getFromDate())) || process.convertDate(data.getDate()).after(process.convertDate(process.getToDate())))){
                if(data.getWorkplacesGMR() > currentHighest){
                    currentHighest = data.getWorkplacesGMR();
                    borough = data.getBorough();
                    date = data.getDate();
                }
            }
        }
        wStat.setText(""+ borough + "\n" + currentHighest + "\n" + date);
    }
    
    public void getHighestR()
    {
        int currentHighest = -100000000;
        String borough = "";
        String date = "";
        for(CovidData data : process.getCovidDataArr()){
            if(!(process.convertDate(data.getDate()).before(process.convertDate(process.getFromDate())) || process.convertDate(data.getDate()).after(process.convertDate(process.getToDate())))){
                if(data.getResidentialGMR() > currentHighest){
                    currentHighest = data.getResidentialGMR();
                    borough = data.getBorough();
                    date = data.getDate();
                }
            }
        }
        rStat.setText(""+ borough + "\n" + currentHighest + "\n" + date);
    }
    
    public void getHighestNC()
    {
        int currentHighest = -100000000;
        String borough = "";
        String date = "";
        for(CovidData data : process.getCovidDataArr()){
            if(!(process.convertDate(data.getDate()).before(process.convertDate(process.getFromDate())) || process.convertDate(data.getDate()).after(process.convertDate(process.getToDate())))){
                if(data.getNewCases() > currentHighest){
                    currentHighest = data.getNewCases();
                    borough = data.getBorough();
                    date = data.getDate();
                }
            }
        }
        ncStat.setText(""+ borough + "\n" + currentHighest + "\n" + date);
    }
    
    public void getHighestND()
    {
        int currentHighest = -100000000;
        String borough = "";
        String date = "";
        for(CovidData data : process.getCovidDataArr()){
            if(!(process.convertDate(data.getDate()).before(process.convertDate(process.getFromDate())) || process.convertDate(data.getDate()).after(process.convertDate(process.getToDate())))){
                if(data.getNewDeaths() > currentHighest){
                    currentHighest = data.getNewDeaths();
                    borough = data.getBorough();
                    date = data.getDate();
                }
            }
        }
        ndStat.setText(""+ borough + "\n" + currentHighest + "\n" + date);
    }
    
    public void getHighestTC(){
        for(CovidData data : process.getCovidDataArr()){
            if(data.getDate().equals(process.getToDate())){
                tcStat.setText("" + data.getBorough() + "\n" + data.getTotalCases() + "\n" + data.getDate());
            }
        }
    }
    
    public void getHighestTD(){
        for(CovidData data : process.getCovidDataArr()){
            if(data.getDate().equals(process.getToDate())){
                tdStat.setText("" + data.getBorough() + "\n" + data.getTotalDeaths() + "\n" + data.getDate());
            }
        }
    }
    
    /*
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
            }
            stat.setText(""+ borough + "\n" + currentHighest + "\n" + date);
                
            currentHighest = -100000000;
            borough = "";
            date = "";
        }
    }
    */
}
