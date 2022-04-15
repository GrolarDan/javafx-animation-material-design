module dmk.jfxamd.login.simple {
    requires javafx.controls;
    requires javafx.fxml;

    opens dmk.jfxamd.login.simple to javafx.fxml;
    exports dmk.jfxamd.login.simple;
}
