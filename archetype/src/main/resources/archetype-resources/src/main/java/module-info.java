module ${package} {
    requires javafx.controls;
    requires javafx.fxml;
    requires MaterialFX;

    opens ${package} to javafx.fxml;
    exports ${package};
}
