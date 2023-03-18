import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;

import java.time.LocalDate;

public class WelcomePanel {
    @FXML private DatePicker toDate; // Variable for the "from" date, corresponding to fx:id on fxml
    @FXML private DatePicker fromDate; // Variable for the "to" date, corresponding to fx:id on fxml
    
    // Methods return the date entered into the calender widget
    // system print for now to test
    @FXML
    private void returnToDate() throws IOException{
        LocalDate date = toDate.getValue();
        System.out.println("The date is " + date);
    }

    @FXML
    private void returnFromDate() throws IOException{
        LocalDate date = fromDate.getValue();
        System.out.println("The date is " + date);
    }

}
