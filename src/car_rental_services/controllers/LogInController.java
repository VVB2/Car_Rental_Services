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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import utils.ConnectionUtil;

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
    }    
    
    public LogInController() throws SQLException {
        con = ConnectionUtil.conDB();
    }
    
    
    @FXML
    private void login(MouseEvent event) throws InterruptedException {
        if(logIn().equals("Success")) {
            Thread.sleep(500);
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
    private String logIn() {
        String status = "Success";
        String email = mail.getText();
        String pass = password.getText();
        if(email.isEmpty() || password.getText().isEmpty()) {
            errormessage.setVisible(true);
            status = "Error";
        } else {
            String sql = "SELECT * FROM users Where email = ? and password = ?";
            try {
                preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, pass);
                resultSet = preparedStatement.executeQuery();
                if (!resultSet.next()) { 
                    errormessage.setVisible(true);
                    status = "Error";
                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                status = "Exception";
            }
        }       
        return status;
    }
    
}
