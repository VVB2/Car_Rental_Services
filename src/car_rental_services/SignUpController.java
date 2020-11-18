/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car_rental_services;

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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class SignUpController implements Initializable {

    @FXML
    private Pane loginscene;
    @FXML
    private Pane signupscene;
    @FXML
    private Button anchorpane;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loginscene.setVisible(false);
    }    

    @FXML
    private void login(MouseEvent event) {
        
    }

    @FXML
    private void signup(MouseEvent event) {
        signupscene.setVisible(false);
        loginscene.setVisible(true);
    }
    
}
