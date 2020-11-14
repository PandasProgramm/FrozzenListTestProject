
/**
 * @author Created by Miguel Gutierrez on 11.11.2020
 * @since 1.11
 */

module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens org.example to javafx.fxml;
    //exports org.example;
}