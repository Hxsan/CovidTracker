/*
 * Class for the second panel, used to display boroughs to the user
 */
import java.io.IOException;
import javafx.fxml.FXML;

public class BoroughPanels {
    @FXML
    private void switchToWelcome() throws IOException{
        GUIManager.setRoot("Panel1");
    }
}