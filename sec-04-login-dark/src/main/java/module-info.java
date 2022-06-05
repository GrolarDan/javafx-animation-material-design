module dmk.jfxamd.login.dark {
    requires javafx.controls;
    requires javafx.fxml;
    requires MaterialFX;

    opens dmk.jfxamd.login.dark to javafx.fxml;
    exports dmk.jfxamd.login.dark;
}
