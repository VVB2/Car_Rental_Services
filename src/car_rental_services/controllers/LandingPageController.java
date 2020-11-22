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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class LandingPageController implements Initializable {
    
    @FXML
    private BorderPane borderpane;
    Stage stage;
    private double x,y;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(netIsAvailable()) {
            loadUI("/car_rental_services/pages/Home.fxml");
        }
        else {
            loadUI("/car_rental_services/pages/Internet.fxml");
        }
    }    

    @FXML
    private void minimize(MouseEvent event) {
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    private void close(MouseEvent event) {
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void signinbtn(MouseEvent event) {
        loadUI("/car_rental_services/pages/SignUp.fxml");
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
    private void loginbtn(MouseEvent event) {
        loadUI("/car_rental_services/pages/LogIn.fxml");
    }


    @FXML
    private void home(MouseEvent event) {
        loadUI("/car_rental_services/pages/Home.fxml");
    }

    @FXML
    private void policies(MouseEvent event) {
    }

    @FXML
    private void aboutUs(MouseEvent event) {
    }
     
}
