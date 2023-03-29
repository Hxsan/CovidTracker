import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

/**
 * Write a description of class HandleClick here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class HandleClick implements EventHandler<MouseEvent>{
    private static String fxid;
    
    @Override
    public void handle(MouseEvent event) {
        Node target = (Node) event.getTarget();
        fxid = target.getId();
        
    }
    
    public String getObjectId(MouseEvent event){
        handle(event);
        return fxid;
    }
    
}
