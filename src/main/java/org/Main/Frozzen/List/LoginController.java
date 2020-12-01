package org.Main.Frozzen.List;

import data.user.User;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.function.Supplier;

/**
 * Created by Miguel Gutierrez on 14.11.2020
 */
public class LoginController {


    @FXML
    private TextField txtUserName;

    @FXML
    private PasswordField txtPassword;

    public boolean log()throws NumberFormatException{
    do{
        String userName= txtUserName.getText();
        String userPassword= txtPassword.getText();

        if(!(txtUserName.getText().isEmpty())&&!(txtPassword.getText().isEmpty())){
            Supplier<User>user= User::new;

            return true;
        }
    }while(true);
   }
   @FXML
   public void registration() throws IOException {
        App.setRoot("register");
   }

}
