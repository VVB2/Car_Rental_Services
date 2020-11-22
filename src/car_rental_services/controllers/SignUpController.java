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
import javafx.scene.control.Label;
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
public class SignUpController implements Initializable {

    @FXML
    private BorderPane borderpane;
    @FXML
    private PasswordField password;
    @FXML
    private TextField mail;
    @FXML
    private HBox errorpass;
    @FXML
    private HBox errormail;
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
        if(netIsAvailable()){
            loadUI("/car_rental_services/pages/LogIn.fxml");
        }
        else {
            loadUI("/car_rental_services/pages/Internet.fxml");
        }
    }

    @FXML
    private void signup(MouseEvent event) {
        if(password.getText().isEmpty()) {
            errorpass.setVisible(true);          
        }
        if(mail.getText().isEmpty()) {
            errormail.setVisible(true);
        }
        if(password.getText().length() < 8 || password.getText().matches("[aA-zZ ]+$") && !mail.getText().matches(".*\\b@gmail.com\\b")) {
            errorpass.setVisible(true);
            errormail.setVisible(true);
        }
        else {
            errorpass.setVisible(false);
            errormail.setVisible(false);
        }
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
