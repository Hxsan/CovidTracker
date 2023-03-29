import javafx.fxml.FXML;
import javafx.scene.control.Label;
 

/**
 * Represents one record in the COVID dataset.
 * This is essentially one row in the data table. Each column
 * has a corresponding field.
 */ 

public class CovidData {

    /*
    The date the COVID information (cases & deaths) was collected
    */
    private String date;
    
    /*
    The COVID information is organised by (London) borough
    */
    private String borough;
    
    
    /*
    The COVID information that's collected daily for each London borough
    */
    private int newCases;
    private int totalCases;
    private int newDeaths;
    private int totalDeaths;
    
    
    /*
    Google analysed location data from Android smartphones to measure movement
    in London.  The data shows percent change from the baseline.  For example, 
    a negative value means there's less human traffic compared to the baseline.
    */
    private int retailRecreationGMR;
    private int groceryPharmacyGMR;
    private int parksGMR;
    private int transitGMR;
    private int workplacesGMR;
    private int residentialGMR;

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


    public CovidData(String date, String borough, int retailRecreationGMR, int groceryPharmacyGMR, 
                        int parksGMR, int transitGMR, int workplacesGMR, int residentialGMR, 
                        int newCases, int totalCases, int newDeaths, int totalDeaths) {

        this.date = date;
        this.borough = borough;
        this.retailRecreationGMR = retailRecreationGMR;
        this.groceryPharmacyGMR = groceryPharmacyGMR;
        this.parksGMR = parksGMR;
        this.transitGMR = transitGMR;
        this.workplacesGMR = workplacesGMR;
        this.residentialGMR = residentialGMR;
        this.newCases = newCases;
        this.totalCases = totalCases;
        this.newDeaths = newDeaths;
        this.totalDeaths = totalDeaths;
    }


    public int chooseStat(Label statName){
        if (statName.equals(rnrStat)){
            return getRetailRecreationGMR();
        } else if (statName.equals(gnpStat)){
            return getGroceryPharmacyGMR();
        } else if(statName.equals(pStat)){
            return getParksGMR();
        } else if(statName.equals(tsStat)){
            return getTransitGMR();
        } else if(statName.equals(wStat)){
            return getWorkplacesGMR();
        } else if(statName.equals(rStat)){
            return getResidentialGMR();
        } else if(statName.equals(ncStat)){
            return getNewCases();
        } else if(statName.equals(ndStat)){
            return getNewDeaths();
        }
        return -1;
    }
    
    
    public String getDate() {
        return date;
    }


    public String getBorough() {
        return borough;
    }


    public int getRetailRecreationGMR() {
        return retailRecreationGMR;
    }


    public int getGroceryPharmacyGMR() {
        return groceryPharmacyGMR;
    }


    public int getParksGMR() {
        return parksGMR;
    }


    public int getTransitGMR() {
        return transitGMR;
    }


    public int getWorkplacesGMR() {
        return workplacesGMR;
    }


    public int getResidentialGMR() {
        return residentialGMR;
    }


    public int getNewCases() {
        return newCases;
    }


    public int getTotalCases() {
        return totalCases;
    }


    public int getNewDeaths() {
        return newDeaths;
    }


    public int getTotalDeaths() {
        return totalDeaths;
    }

    @Override
    public String toString() {
        return "Covid Record {" + 
        " date='" + date +'\'' +
        ", borough='" + borough +'\'' +
        ", retailRecreationGMR=" + retailRecreationGMR + 
        ", groceryPharmacyGMR=" + groceryPharmacyGMR + 
        ", parksGMR=" + parksGMR + 
        ", transitGMR=" + transitGMR + 
        ", workplacesGMR=" + workplacesGMR + 
        ", residentialGMR=" + residentialGMR + 
        ", newCases=" + newCases + 
        ", totalCases=" + totalCases + 
        ", newDeaths=" + newDeaths + 
        ", totalDeaths=" + totalDeaths + 
        "}";
    }
}
