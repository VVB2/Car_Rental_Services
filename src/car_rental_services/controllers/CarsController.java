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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class CarsController implements Initializable {

    @FXML
    private Pane Opel;
    @FXML
    private Pane Hyundai;
    @FXML
    private Pane Suzuki;
    @FXML
    private Pane Volvo;
    @FXML
    private Pane Ford_XV;
    @FXML
    private Pane Ford;
    String restore=String.format("-fx-background-color:#212121;-fx-background-radius:5;-fx-effect: dropshadow(three-pass-box, #fff, 3, 0, 0, 0)");
    String bstyle=String.format("-fx-border-color:#70ad4d;-fx-border-width:2;-fx-border-radius:5");


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void next(MouseEvent event) {
    }

    @FXML
    private void opel(MouseEvent event) {
        Opel.setStyle(bstyle);
        Hyundai.setStyle(restore);
        Ford_XV.setStyle(restore);
        Ford.setStyle(restore);
        Suzuki.setStyle(restore);
        Volvo.setStyle(restore);
    }

    @FXML
    private void hyundai(MouseEvent event) {
        Opel.setStyle(restore);
        Hyundai.setStyle(bstyle);
        Ford_XV.setStyle(restore);
        Ford.setStyle(restore);
        Suzuki.setStyle(restore);
        Volvo.setStyle(restore);
    }

    @FXML
    private void suzuki(MouseEvent event) {
        Opel.setStyle(restore);
        Hyundai.setStyle(restore);
        Ford_XV.setStyle(restore);
        Ford.setStyle(restore);
        Suzuki.setStyle(bstyle);
        Volvo.setStyle(restore);
    }

    @FXML
    private void volvo(MouseEvent event) {
        Opel.setStyle(restore);
        Hyundai.setStyle(restore);
        Ford_XV.setStyle(restore);
        Ford.setStyle(restore);
        Suzuki.setStyle(restore);
        Volvo.setStyle(bstyle);
    }

    @FXML
    private void fordxv(MouseEvent event) {
        Opel.setStyle(restore);
        Hyundai.setStyle(restore);
        Ford_XV.setStyle(bstyle);
        Ford.setStyle(restore);
        Suzuki.setStyle(restore);
        Volvo.setStyle(restore);
    }

    @FXML
    private void ford(MouseEvent event) {        
        Opel.setStyle(restore);
        Hyundai.setStyle(restore);
        Ford_XV.setStyle(restore);
        Ford.setStyle(bstyle);
        Suzuki.setStyle(restore);
        Volvo.setStyle(restore);
    }
    
}
