package org.Main.Frozzen.List;

import data.user.User;
import data.user.UserService;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.sql.SQLException;


/**
 * Created by Miguel Gutierrez on 16.11.2020
 */
public class RegisterController {

    @FXML
    private TextField txtName;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private PasswordField txtPasswordConfuse;
    @FXML
    public Button btnRegister;
    @FXML
    public Button cancel;

    public void registration()throws IOException{
        try {
        UserService userService= new UserService();
        String username = txtName.getText();
        String userPassword=txtPassword.getText();
        if(txtPassword.getText().equals(txtPasswordConfuse.getText())){
            userPassword=txtPassword.getText();
        }
        User user= new User(username,userPassword);

          userService.save(user);
           // Alert alert= new Alert(Alert.AlertType.INFORMATION,"Registrierung ok");
            App.setRoot("login");
        }catch (SQLException sqlException){
            Alert alert= new Alert(Alert.AlertType.INFORMATION,"Registrierung fehlgeschlagen\n" +
                                   "Drücke OK um auf das Startmenü zu kommen",ButtonType.OK,ButtonType.CANCEL);
            if(alert.getResult()== ButtonType.OK)App.setRoot("login");
            else alert.close();
        }
    }
    public void cancel()throws IOException {
        App.setRoot("login");
    }

}
