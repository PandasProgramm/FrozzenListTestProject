
/**
 * @author Created by Miguel Gutierrez on 11.11.2020
 * @since 1.11
 */

package org.Main.Frozzen.List;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
