/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car_rental_services.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class DetailsController implements Initializable {

    @FXML
    private Button monthbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void months(MouseEvent event) {
        monthbtn.setStyle("-fx-border-color: #70ad4d");
        monthbtn.setStyle("-fx-text-fill: #fff");
        monthbtn.setStyle("-fx-border-width: 2px");
    }
    
}
