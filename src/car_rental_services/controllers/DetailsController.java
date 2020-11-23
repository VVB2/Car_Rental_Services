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
import javafx.scene.control.Button;
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
    private void check(MouseEvent event) {
        checkDetails.setVisible(true);
        enterDetails.setVisible(false);
    }

    @FXML
    private void back(MouseEvent event) {
        checkDetails.setVisible(false);
        enterDetails.setVisible(true);
    }

    @FXML
    private void next(MouseEvent event) {
    }

    
}
