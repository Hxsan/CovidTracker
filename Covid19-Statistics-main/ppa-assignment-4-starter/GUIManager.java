/**
 * GUIManager is the main class used to initiate the GUI
 * And start the FX Application, it uses stages and FXML in order
 * to load the GUI elements to the user
 * 
 * @version: 3.1
 * @author: Mohammed Ahmed(K22026228), Shahriar Miah(K22023070), Christopher Herre(K22001776), Talal AlOhali(K21130307)
 * 
 */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public class GUIManager extends Application{
    
    private static Scene scene;

    /**
     * Uses @Override to replace the method in the super class
     * Sets up the GUI window to be loaded by the main method.
     */
    @Override
    public void start(Stage stage) throws IOException {
        // Creates the stage and scene for the GUI to be placed
        scene = new Scene(loadFXML("Panel1"), 730, 505);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.setTitle("Covid Borough Viewer");
        stage.show();
    }

    /**
     * Loads the FXML file corresponding and sets it as the root class
     */
    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    /**
     * Converts the FXML into a loadable format
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GUIManager.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    /**
     * Starts up the FX Application
     */
    public static void main(String[] args) {
        launch();
    }

}
