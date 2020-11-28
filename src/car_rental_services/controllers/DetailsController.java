/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car_rental_services.controllers;

import static car_rental_services.Car_Rental_Services.netIsAvailable;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTimePicker;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class DetailsController implements Initializable {
    private Button monthbtn;
    @FXML
    private VBox enterDetails;
    @FXML
    private VBox checkDetails;
    @FXML
    private BorderPane borderpane;
    @FXML
    private TextField start;
    @FXML
    private TextField end;
    @FXML
    private JFXDatePicker pickupdate;
    @FXML
    private JFXTimePicker pickuptime;
    @FXML
    private JFXDatePicker dropoffdate;
    @FXML
    private JFXTimePicker dropofftime;
    @FXML
    private Label error;
    @FXML
    private Label startpoint;
    @FXML
    private Label endpoint;
    @FXML
    private Label timepickup;
    @FXML
    private Label datedropoff;
    @FXML
    private Label timedropoff;
    @FXML
    private Label datepickup;
    
    LocalDate date = LocalDate.now().plusDays(1); 
    LocalTime time = LocalTime.now();

    private void loadUI(String ui){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(ui));   
        } catch(IOException ex) {
            Logger.getLogger(LandingPageController.class.getName()).log(Level.SEVERE,null,ex);
        }
        borderpane.setCenter(root);
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO 
        enterDetails.setVisible(true);
        checkDetails.setVisible(false);
        pickupdate.setValue(date);
        pickuptime.setValue(time);
    }    

    private void months(MouseEvent event) {
        monthbtn.setStyle("-fx-border-color: #70ad4d");
        monthbtn.setStyle("-fx-text-fill: #fff");
        monthbtn.setStyle("-fx-border-width: 2px");
    }

    @FXML
    private void home(MouseEvent event) {
        if(netIsAvailable()) {
            loadUI("/car_rental_services/pages/Home.fxml");
        }
        else {
            loadUI("/car_rental_services/pages/Internet.fxml");
        }
    }

    @FXML
    private void check(MouseEvent event) throws ParseException {
        if(start.getText().isEmpty() || end.getText().isEmpty() || dropoffdate.getValue() == null || dropofftime.getValue() == null) {
            error.setVisible(true);
        }
        else {
            startpoint.setText(start.getText().substring(0, 1).toUpperCase() + start.getText().substring(1));
            endpoint.setText(end.getText().substring(0, 1).toUpperCase() + end.getText().substring(1));
            timepickup.setText(pickuptime.getValue().toString().substring(0,5).trim());
            datepickup.setText(pickupdate.getValue().toString());
            timedropoff.setText(dropofftime.getValue().toString());
            datedropoff.setText(dropoffdate.getValue().toString());
            checkDetails.setVisible(true);
            enterDetails.setVisible(false);
        }
    }

    @FXML
    private void back(MouseEvent event) {
        checkDetails.setVisible(false);
        enterDetails.setVisible(true);
    }

    @FXML
    private void next(MouseEvent event) {
        if(netIsAvailable()) {
            loadUI("/car_rental_services/pages/Cars.fxml");
        }
        else {
            loadUI("/car_rental_services/pages/Internet.fxml");
        }
    }  

    @FXML
    private void invisible(MouseEvent event) {
        error.setVisible(false);
    }
}
