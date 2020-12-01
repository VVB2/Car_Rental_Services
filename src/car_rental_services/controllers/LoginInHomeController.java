/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car_rental_services.controllers;

import static car_rental_services.Car_Rental_Services.netIsAvailable;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class LoginInHomeController implements Initializable {
    
    @FXML
    private BorderPane borderpane;
    @FXML
    public Label name;
    @FXML
    private Pane rented;
    /**
     * Initializes the controller class. 
     */ 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        name.setText("More Info!");
    }    
      
    private void loadUI(String ui){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(ui));   
        } catch(IOException ex) {
            Logger.getLogger(LandingPageController.class.getName()).log(Level.SEVERE,null,ex);
        }
        borderpane.setCenter(root);
    }
    @FXML
    private void details(MouseEvent event) {
        if(netIsAvailable()){
            loadUI("/car_rental_services/pages/Details.fxml");
        }
        else {
            loadUI("/car_rental_services/pages/Internet.fxml");
        }
    }   

    @FXML
    private void showDetails(MouseEvent event) {
        rented.setVisible(true);
    }

    @FXML
    private void rentedCar(MouseEvent event) {
        if(netIsAvailable()) {
            loadUI("/car_rental_services/pages/Rented.fxml");
        }
        else {
            loadUI("/car_rental_services/pages/Internet.fxml");
        }
    }
    
}
