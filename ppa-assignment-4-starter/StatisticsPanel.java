
/**
 * Write a description of class StatisticsPanel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class StatisticsPanel{
    @FXML
    private void switchToBorough(MouseEvent event) throws IOException{
        GUIManager.setRoot("Panel2");
    }
}
