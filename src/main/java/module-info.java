module test.oauh.cz.javafxaplikace {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens test.oauh.cz.javafxaplikace to javafx.fxml;
    exports test.oauh.cz.javafxaplikace;
}