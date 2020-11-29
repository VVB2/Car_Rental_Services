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
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

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
    @FXML
    private Pane signuppane;
    @FXML
    private Button signupbtn;
    @FXML
    private TextField username;
    @FXML
    private HBox success;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        signuppane.setVisible(true);    
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
        if(password.getText().isEmpty() || mail.getText().isEmpty() || username.getText().isEmpty()) {
            errorpass.setVisible(true); 
            errormail.setVisible(true);
        }
        else if(password.getText().length() < 8 || password.getText().matches("[aA-zZ ]+$")) {
            if(!mail.getText().matches(".*\\b@gmail.com\\b")) {
                errormail.setVisible(true);
                errorpass.setVisible(true); 
        }
            else {
                    errorpass.setVisible(true);
                }         
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
    private void invisible(MouseEvent event) {
        errormail.setVisible(false);
        errorpass.setVisible(false);
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
