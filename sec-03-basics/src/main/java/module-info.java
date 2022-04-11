module dmk.jfxamd.basics {
    requires javafx.controls;
    requires javafx.fxml;

    opens dmk.jfxamd.basics to javafx.fxml;
    exports dmk.jfxamd.basics;
}
