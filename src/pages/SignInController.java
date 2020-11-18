/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class SignInController implements Initializable {

    @FXML
    private Button loginscene;
    @FXML
    private Pane signupscene;
    @FXML
    private Button anchorpane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        signupscene.setVisible(false);
    }    


    @FXML
    private void signup(MouseEvent event) {
    }

    @FXML
    private void login(MouseEvent event) {
        signupscene.setVisible(true);
        loginscene.setVisible(false);
    }
    
}
