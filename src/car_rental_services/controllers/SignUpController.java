/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car_rental_services.controllers;

import static car_rental_services.Car_Rental_Services.netIsAvailable;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import utils.ConnectionUtil;

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
    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        signuppane.setVisible(true);     
    }    

    public SignUpController() throws SQLException {
        con = ConnectionUtil.conDB();
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
        if(signUp().equals("Success")) {
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
    private String signUp() {
        String status = "Success";
        if(username.getText().isEmpty() || mail.getText().isEmpty() || password.getText().isEmpty()) {
            errorpass.setVisible(true);
            errormail.setVisible(true);
            status = "Error";
        }
        else if(password.getText().length() < 8 || password.getText().matches("[aA-zZ ]+$")) {
            if(!mail.getText().matches(".*\\b@gmail.com\\b")) {
                errormail.setVisible(true);
                errorpass.setVisible(true); 
                status = "Error";
        }
            else {
                    errorpass.setVisible(true);
                    status = "Error";
                }         
        }
        else {
            String sql = "insert into users (username,email,password) values (?,?,?)";
            try {
                preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, username.getText());
                preparedStatement.setString(2, mail.getText());
                preparedStatement.setString(3, password.getText());
                preparedStatement.execute();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                status = "Exception";
            }
        }       
        return status;
    }
}
