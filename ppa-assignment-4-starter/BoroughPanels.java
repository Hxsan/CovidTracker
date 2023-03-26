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

public class BoroughPanels{
    private HandleClick clickEvent = new HandleClick();
    
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
        Stage stageTwo = new Stage();
        TableLoaderLayout tableLoader = new TableLoaderLayout();
        stageTwo.setTitle(clickEvent.getObjectId(event));
        stageTwo.setScene(new Scene(tableLoader, 946, 390));
        tableLoader.initialize(event);
        stageTwo.show();
    }
}
