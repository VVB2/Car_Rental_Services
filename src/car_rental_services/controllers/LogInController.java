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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class LogInController implements Initializable {

    @FXML
    private BorderPane borderpane;
    @FXML
    private HBox errormessage;
    @FXML
    private TextField mail;
    @FXML
    private PasswordField password;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void login(MouseEvent event) {
        if(mail.getText().isEmpty() || password.getText().isEmpty()) {
            errormessage.setVisible(true);
        }
        if(!mail.getText().matches(".*\\b@gmail.com\\b")) {
            errormessage.setVisible(true);
        }
        else {
            if(netIsAvailable()) {
                loadUI("/car_rental_services/pages/LoginInHome.fxml");
            }
            else {
                loadUI("/car_rental_services/pages/Internet.fxml");
            }
        }
    }

    @FXML
    private void signup(MouseEvent event) {
        if(netIsAvailable()){
            loadUI("/car_rental_services/pages/SignUp.fxml");
        }
        else {
            loadUI("/car_rental_services/pages/Internet.fxml");
        }
    }

    @FXML
    private void invisible(MouseEvent event) {
        errormessage.setVisible(false);
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
    
}
