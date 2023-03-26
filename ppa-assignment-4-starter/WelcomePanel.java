import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.time.LocalDate;

public class WelcomePanel{
    @FXML private DatePicker toDate; // Variable for the "from" date, corresponding to fx:id on fxml
    @FXML private DatePicker fromDate; // Variable for the "to" date, corresponding to fx:id on fxml
    @FXML private Button prevButton;
    @FXML private Button nextButton;
    @FXML private Label errorLabel;
    
    // Methods return the date entered into the calender widget
    // system print for now to test
    @FXML
    private String returnToDate(){
        nextButton.setDisable(true);
        LocalDate date = toDate.getValue();
        if(date == null){
            errorLabel.setText("Enter a From/To date.");
        }
        String dateConv = toDate.getValue().toString();
        System.out.println("The date is " + dateConv);
        return dateConv;
    }
    
    @FXML
    private String returnFromDate(){
        nextButton.setDisable(true);
        LocalDate date = fromDate.getValue();
        if(date == null){
            errorLabel.setText("Enter a From/To date.");
        }
        String dateConv = fromDate.getValue().toString();
        System.out.println("The date is " + dateConv);
        return dateConv;
    }
    
    @FXML
    private Boolean getValidity(){
        Integer from = Integer.valueOf(returnFromDate().replace("-",""));
        Integer to = Integer.valueOf(returnToDate().replace("-",""));
        if (from > to){
            errorLabel.setText("To Date is before the From Date");
            return false;
        }
        else if ((from > 20200215 && from < 20221015)&& (to < 20221015 && to > 20200215)){
            return true;
        }
        errorLabel.setText("The date range is: 15/02/2020 to 15/10/2022");
        return false;
    }
    
    @FXML
    private Boolean ProcessDates(){
        nextButton.setDisable(true);
        if(getValidity() == true){
            nextButton.setDisable(false);
            errorLabel.setText("");
            return true;
        }
        return false;
    }
    
    @FXML
    private void switchToBoroughs() throws IOException{
        if(ProcessDates() == true){
            GUIManager.setRoot("Panel2");
        }
    }
    
    public LocalDate getFromDate(){
        return fromDate.getValue();
    }
    
    public LocalDate getToDate(){
        return toDate.getValue();
    }
    
}
