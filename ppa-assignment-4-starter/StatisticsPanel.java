
/**
 * Write a description of class StatisticsPanel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.IOException;
import javafx.fxml.FXML;

public class StatisticsPanel extends GUIManager{
    @FXML
    private void switchToBorough() throws IOException{
        GUIManager.setRoot("Panel2");
    }
}
