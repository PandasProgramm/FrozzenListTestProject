
/**
 * @author Created by Miguel Gutierrez on 11.11.2020
 * @since 1.11
 */

package org.Main.Frozzen.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class PrimaryController {

    @FXML
    private Button btnLogin;
    @FXML
    private void switchToLogin() throws IOException {
        App.setRoot("login");
    }
}

