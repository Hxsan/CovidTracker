import java.util.ArrayList;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TableView;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Write a description of class ProcessData here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ProcessData{
    
    private HandleClick circleClick;
    private CovidDataLoader covidDataLoader;
    
    //FXML variables
    @FXML
    private TableView<CovidData> Table;
    @FXML
    private TableColumn<CovidData, String> Date;
    @FXML
    private TableColumn<CovidData, String> Borough;
    @FXML
    private TableColumn<CovidData, Integer> Retail_and_Recreation;
    @FXML
    private TableColumn<CovidData, Integer> Grocery_and_Pharmacy;
    @FXML
    private TableColumn<CovidData, Integer> Parks;
    @FXML
    private TableColumn<CovidData, Integer> Transit_Stations;
    @FXML
    private TableColumn<CovidData, Integer> Workplaces;
    @FXML
    private TableColumn<CovidData, Integer> Residential;
    @FXML
    private TableColumn<CovidData, Integer> New_Cases;
    @FXML
    private TableColumn<CovidData, Integer> Total_Cases;
    @FXML
    private TableColumn<CovidData, Integer> New_Deaths;
    @FXML
    private TableColumn<CovidData, Integer> Total_Deaths;
        
    
    private ArrayList<CovidData> Coviddata;
    
    public ProcessData(){
        circleClick = new HandleClick();
        covidDataLoader = new CovidDataLoader();
        Coviddata = covidDataLoader.load();
    }
    
    public String getFxidString(MouseEvent event){
        return circleClick.getObjectId(event);
    }
    
    private ObservableList<CovidData> filterData(MouseEvent event){
        ObservableList<CovidData> observeList = FXCollections.observableArrayList();
        for(CovidData key : Coviddata){
            if(key.getBorough().equals(getFxidString(event))){
                observeList.add(key);
                System.out.println(key);
            }
        }
        return observeList;
    }
    
    public void initialise(MouseEvent event){
        ObservableList<CovidData> ourList = filterData(event);
        
        Date.setCellValueFactory(new PropertyValueFactory<>("Date"));
        Borough.setCellValueFactory(new PropertyValueFactory<>("Borough"));
        Retail_and_Recreation.setCellValueFactory(new PropertyValueFactory<>("Retail_and_Recreation"));
        Grocery_and_Pharmacy.setCellValueFactory(new PropertyValueFactory<>("Grocery_and_Pharmacy"));
        Parks.setCellValueFactory(new PropertyValueFactory<>("Parks"));
        Transit_Stations.setCellValueFactory(new PropertyValueFactory<>("Transit_Stations"));
        Workplaces.setCellValueFactory(new PropertyValueFactory<>("Workplaces"));
        Residential.setCellValueFactory(new PropertyValueFactory<>("Residential"));
        New_Cases.setCellValueFactory(new PropertyValueFactory<>("New_Cases"));
        Total_Cases.setCellValueFactory(new PropertyValueFactory<>("Total_Cases"));
        New_Deaths.setCellValueFactory(new PropertyValueFactory<>("New_Deaths"));
        Total_Deaths.setCellValueFactory(new PropertyValueFactory<>("Total_Deaths"));
        
        Table.setItems(ourList);
    }
    
}
