/*
 * Class for the second panel, used to display boroughs to the user
 */
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.shape.Circle;
import java.util.HashMap;

public class BoroughPanels{
    @FXML private Circle Hackney;
    @FXML private Circle Harrow;
    @FXML private Circle Brent;
    @FXML private Circle Camden;
    @FXML private Circle Islington;
    @FXML private Circle Havering;
    @FXML private Circle Greenwich;
    @FXML private Circle Newham;
    @FXML private Circle Barking_And_Dagenham;
    @FXML private Circle Westminster;
    @FXML private Circle Kensington_And_Chelsea;
    @FXML private Circle Ealing;
    @FXML private Circle Hillingdon;
    @FXML private Circle Tower_Hamlets;
    @FXML private Circle Redbridge;
    @FXML private Circle Enfield;
    @FXML private Circle Waltham_Forest;
    @FXML private Circle Haringey;
    @FXML private Circle Barnet;
    @FXML private Circle Bromley;
    @FXML private Circle Croydon;
    @FXML private Circle Sutton;
    @FXML private Circle Kingston_Upon_Thames;
    @FXML private Circle Southwark;
    @FXML private Circle Lambeth;
    @FXML private Circle Merton;
    @FXML private Circle Richmond_Upon_Thames;
    @FXML private Circle Lewisham;
    @FXML private Circle Bexley;
    @FXML private Circle City_Of_London;
    @FXML private Circle Wandsworth;
    @FXML private Circle Hammersmith_And_Fulham;
    @FXML private Circle Hounslow;
    
    private ProcessData process;
    public BoroughPanels(){
        process = new ProcessData();
    }
    
    @FXML
    private void switchToWelcome() throws IOException{
        GUIManager.setRoot("Panel1");
    }
    
    @FXML
    private void switchToStatistics() throws IOException{
        GUIManager.setRoot("Panel3");
    }
    
    private void changeCircleColour(){
        HashMap<String, Integer> deaths = process.getTotalDeathsHashMap();
    }
    
    @FXML
    private void switchToSpecificBorough(MouseEvent event) throws IOException{
        Stage stageTwo = new Stage();
        TableLoaderLayout tableLoader = new TableLoaderLayout();
        stageTwo.setTitle(process.getFxidString(event));
        stageTwo.setScene(new Scene(tableLoader, 1031, 376));
        stageTwo.setMaxHeight(420);
        stageTwo.setMaxWidth(1060);
        tableLoader.initialize(event);
        stageTwo.show();
    }
}
