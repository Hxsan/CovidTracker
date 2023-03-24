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

public class BoroughPanels extends GUIManager{
    private ProcessData process = new ProcessData();
    
    @FXML
    private void switchToWelcome() throws IOException{
        GUIManager.setRoot("Panel1");
    }
    
    @FXML
    private void switchToStatistics() throws IOException{
        GUIManager.setRoot("Panel3");
    }
    
    @FXML
    private void switchToSpecificBorough(MouseEvent event) throws IOException{
        Parent root;
        try {
            
            root= FXMLLoader.load(getClass().getClassLoader().getResource("Panel2_1.fxml"));
            Stage stage = new Stage();
            stage.setTitle(process.getFxidString(event));
            stage.setScene(new Scene(root, 946, 390));
            stage.show();
            process.handleData(event);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}